package com.sarench;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserExample {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executorService = Executors.newFixedThreadPool(4);

		Phaser phaser = new Phaser(3);
		executorService.submit(new Task(phaser));
		executorService.submit(new Task(phaser));
		executorService.submit(new Task(phaser));

		//phaser.awaitAdvance(1);

		Thread.sleep(2000);

		System.out.println("End");
	}

	static class Task implements Runnable {

		private Phaser phaser;

		public Task(Phaser phaser) {
			this.phaser = phaser;
		}

		// As CountDown latch
		/*@Override
		public void run() {
			phaser.arrive();
			System.out.println("Hi");

		}*/

		// As Cyclic Barrier
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Arrived Parties : "+ phaser.getArrivedParties());
				phaser.arriveAndAwaitAdvance();
				System.out.println(phaser.getPhase());
			}
			

		}
	}

}
