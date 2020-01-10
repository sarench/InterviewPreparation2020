package com.sarench;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

	//static int i = 1;
	static AtomicInteger atomicInteger = new AtomicInteger(1);

	public static void main(String[] args) {
		MyBlockingQueue<Integer> blockingQueue = new MyBlockingQueue<Integer>(10);
		//BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>();
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		Runnable producer = () -> {
			while (true) {
				try {
					blockingQueue.put(atomicInteger.getAndIncrement());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		};

		Runnable consumer = () -> {
			while (true)
				try {
					System.out.println(blockingQueue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		};

		executorService.submit(producer);
		executorService.submit(producer);
		executorService.submit(producer);
		executorService.submit(producer);

		executorService.submit(consumer);
		// executorService.submit(consumer);

	}

}

class MyBlockingQueue<T> {

	int size;
	Lock lock = new ReentrantLock();
	Condition readCondition = lock.newCondition();
	Condition writeCondition = lock.newCondition();

	MyBlockingQueue(int size) {
		this.size = size;
	}

	Queue<T> queue = new LinkedList<T>();

	public void put(T i) throws InterruptedException {
		lock.lock();
		try {
			while (queue.size() == size)
				writeCondition.await();
			queue.add(i);
			writeCondition.signal();
		} finally {
			lock.unlock();
		}
	}
	
	public void putOld(T i) throws InterruptedException {
		synchronized (this) {
			while (queue.size() == size)
				wait();
			queue.add(i);
			notifyAll();
		}
	}
	
	public T takeOld() throws InterruptedException {
		synchronized(this){
			while (queue.size() == 0)
				wait();

			T item = queue.poll();
			notifyAll();
			return item;
		}

	}

	public T take() throws InterruptedException {
		lock.lock();
		try {
			while (queue.size() == 0)
				writeCondition.await();

			T item = queue.poll();
			writeCondition.signal();
			return item;

		} finally {
			lock.unlock();
		}
	}

}
