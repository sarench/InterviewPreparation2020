package com.sarench;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executorService = Executors.newFixedThreadPool(4);

		CyclicBarrier barrier = new CyclicBarrier(3, ()-> System.out.println("barrier ends"));
		executorService.submit(new Task(barrier));
		executorService.submit(new Task(barrier));
		executorService.submit(new Task(barrier));

		Thread.sleep(2000);
		
		System.out.println("End");
	}

	static class Task implements Runnable {

		private CyclicBarrier barrier;

		public Task(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			while (true) {
				try {
					barrier.await();
					Thread.sleep(2000);
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Hi");
			}

		}
	}

}
