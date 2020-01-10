import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) throws ParseException {
		
		Optional<String> s=Stream.of("Sar","kalp","Krithi").reduce((w1,w2) ->w1.length()==w2.length()?w1:w2);
		System.out.println(s.get());
		
		System.out.println(Stream.of(1,3,2).reduce((w1,w2) ->w1+w2));
		
		List<String> l= Arrays.asList("Sar","Sar","Krithi");
		
		//l.stream().collect(Collectors.toMap(w ->w, w->Collections.frequency(l, w))).forEach((k,v)->System.out.println(k+" = "+v));
		
		l.stream().collect(Collectors.groupingBy(w ->w,Collectors.counting())).forEach((k,v)->System.out.println(k+" = "+v));
		
		
		ExecutorService executorService=Executors.newFixedThreadPool(10);

		/*
		 * SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); Date
		 * txnDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-29"); Date
		 * bizDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-28");
		 * 
		 * if (txnDate.before(bizDate) || txnDate.compareTo(bizDate) == 0) {
		 * System.out.println("txnDate.before(bizDate) : " + txnDate.before(bizDate));
		 * System.out.println("txnDate.compareTo(bizDate) == 0 : " +
		 * (txnDate.compareTo(bizDate) == 0)); } else {
		 * System.out.println("txnDate.after(bizDate) : " + txnDate.after(bizDate));
		 * System.out.println("txnDate.compareTo(bizDate) == 0 : " +
		 * (txnDate.compareTo(bizDate) == 0)); }
		 */
		
		//System.out.println("convertStringToBigDecimal : " + convertStringToBigDecimal("0.97"));
	}

	public static BigDecimal convertStringToBigDecimal(String amount) {
		try {
			if (amount != null && !"".equals(amount)) {
				return new BigDecimal(amount);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}

 class F implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer x) {
        return x + 1;
    }
}

 class G implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer y) {
        return 2 * y;
    }
}

 class H implements  Function<Integer, Integer> {

    @Override
    public Integer apply(Integer x) {
        F f = new F();
        var g = new G();
        Integer y = f.apply(x);
        return g.apply(y);
    }
}
