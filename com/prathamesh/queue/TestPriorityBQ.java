package com.prathamesh.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class TestPriorityBQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<PriorityBQ> bq = new PriorityBlockingQueue();
		ProducerPBQ p1 = new ProducerPBQ(bq,"Producer");
		ConsumerPBQ c1 = new ConsumerPBQ(bq,"Consumer");
		p1.start();
		c1.start();
	}

}
class PriorityBQ implements Comparable{
	private int iD;
	private String nAme;
	@Override
	public String toString() {
		return "\nPriorityBQ [iD=" + iD + ", nAme=" + nAme + "]";
	}
	public PriorityBQ(int iD, String nAme) {
		super();
		this.iD = iD;
		this.nAme = nAme;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		
		return this.iD-((PriorityBQ)o).iD;
	}
}
class ProducerPBQ extends Thread{
private BlockingQueue<PriorityBQ> queue;
	public ProducerPBQ(BlockingQueue queue,String name) {
	super(name);
	this.queue = queue;
}
	@Override
	public void run() {
		while(true){
		
		try {
			int randomnum=ThreadLocalRandom.current().nextInt(1, 10);
			PriorityBQ pq=new PriorityBQ(randomnum,"abc");
			System.out.println("\nProducing item : " + pq);
			queue.put(pq);
			System.out.println("After Production queue : " + queue);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
class ConsumerPBQ extends Thread{
	private BlockingQueue<PriorityBQ> queue;
	public ConsumerPBQ(BlockingQueue queue,String name) {
		super(name);
		this.queue = queue;
	}
	@Override
	public void run() {
		while(true){
		try {
			PriorityBQ pq1 = queue.take();
			System.out.println("\nConsuming item : " + pq1);
			System.out.println("After Consumption queue : " + queue);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
	
}