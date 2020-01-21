package com.sarench;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {

	Lock lockA = new ReentrantLock();
	Lock lockB = new ReentrantLock();

	public static void main(String[] args) {
		new DeadLockExample().execute();

	}

	void execute() {
		new Thread(this::executeThis).start();
		new Thread(this::executeThat).start();
		System.out.println("End Main");
	}

	private void executeThat() {
		lockA.lock();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lockB.lock();
		lockB.lock();
		lockA.lock();
		System.out.println("End executeThat");
	}

	private void executeThis() {
		lockB.lock();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lockA.lock();
		lockA.lock();
		lockB.lock();
		System.out.println("End executeThis");
	}

}
