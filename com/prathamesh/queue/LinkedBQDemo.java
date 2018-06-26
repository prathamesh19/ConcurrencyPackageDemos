package com.prathamesh.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class LinkedBQDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<Integer> bq1 = new LinkedBlockingQueue<Integer>();
		ProducerLBQ p1 = new ProducerLBQ(bq1,"Producer");
		ConsumerLBQ c1 = new ConsumerLBQ(bq1,"Consumer");
		p1.start();
		c1.start();
	}

}
class ProducerLBQ extends Thread{
private BlockingQueue<Integer> queue;
	public ProducerLBQ(BlockingQueue queue,String name) {
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
class ConsumerLBQ extends Thread{
	private BlockingQueue<Integer> queue;
	public ConsumerLBQ(BlockingQueue queue,String name) {
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