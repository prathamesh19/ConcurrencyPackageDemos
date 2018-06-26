package com.prathamesh.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayBQDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(5);
ProducerABQ p1 = new ProducerABQ(bq,"Producer");
ConsumerABQ c1 = new ConsumerABQ(bq,"Consumer");
p1.start();
c1.start();
	}

}
class ProducerABQ extends Thread{
private BlockingQueue<Integer> queue;
	public ProducerABQ(BlockingQueue queue,String name) {
	super(name);
	this.queue = queue;
}
	@Override
	public void run() {
		while(true){
		
		try {
			int randomnum=ThreadLocalRandom.current().nextInt(1, 10);
			System.out.println("Producing item : " + randomnum);
			queue.put(randomnum);
			System.out.println("After Production queue : " + queue);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
class ConsumerABQ extends Thread{
	private BlockingQueue<Integer> queue;
	public ConsumerABQ(BlockingQueue queue,String name) {
		super(name);
		this.queue = queue;
	}
	@Override
	public void run() {
		while(true){
		try {
			Integer randomno = queue.take();
			System.out.println("Consuming item : " + randomno);
			System.out.println("After Consumption queue : " + queue);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
	
}