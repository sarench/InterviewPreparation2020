import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ScatterGather {

	AtomicInteger integer = new AtomicInteger(1);

	public static void main(String[] args) throws InterruptedException {
		new ScatterGather().getPrices("tv").entrySet().stream()
				.forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

		new ScatterGather().getPrices("tv").forEach((k, v) -> System.out.println(k + " = " + v));
	}

	Map<String, Integer> getPrices(String productId) throws InterruptedException {

		CountDownLatch latch = new CountDownLatch(3);
		Map<String, Integer> priceMap = new ConcurrentHashMap<String, Integer>();
		ExecutorService eService = Executors.newFixedThreadPool(10);

		eService.submit(new PriceReceiver(productId, "amazon", priceMap, latch));
		eService.submit(new PriceReceiver(productId, "flipKart", priceMap, latch));
		eService.submit(new PriceReceiver(productId, "ebay", priceMap, latch));

		latch.await();

		return priceMap;

	}

	class PriceReceiver implements Runnable {

		String productId;
		String url;
		Map<String, Integer> priceMap;
		CountDownLatch latch;

		PriceReceiver(String productId, String url, Map<String, Integer> priceMap, CountDownLatch latch) {
			this.productId = productId;
			this.url = url;
			this.priceMap = priceMap;
			this.latch = latch;
		}

		@Override
		public void run() {
			priceMap.put(url, integer.getAndIncrement());
			latch.countDown();

		}

	}

}
