package com.prathamesh.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class TestDelayBQ {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			BlockingQueue<DelayBQ> bq1 = new DelayQueue<DelayBQ>();
			ProducerDQ p1 = new ProducerDQ(bq1,"Producer");
			ConsumerDQ c1 = new ConsumerDQ(bq1,"Consumer");
			p1.start();
			c1.start();
			
		}
	}


class DelayBQ implements Delayed{
	private int iD;
private long startTime;

	@Override
public String toString() {
	return "\nDelayQ [iD=" + iD + ", startTime=" + startTime + "]";
}

	public DelayBQ(int iD, long startTime) {
	super();
	this.iD = iD;
	this.startTime = System.currentTimeMillis() + startTime;
}

@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		long diff=startTime-System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}
	@Override
		    public int compareTo(Delayed o) {
		        if (this.startTime < ((DelayBQ) o).startTime) {
	                return -1;
		        }
		        if (this.startTime > ((DelayBQ) o).startTime) {
		            return 1;
		        }
		        return 0;		        
		    }

}
class ProducerDQ extends Thread{
private BlockingQueue queue;
	public ProducerDQ(BlockingQueue queue,String name) {
	super(name);
	this.queue = queue;
}
	@Override
	public void run() {
		while(true){
		
		try {
			int randomnum=ThreadLocalRandom.current().nextInt(1, 10);
			DelayBQ q=new DelayBQ(randomnum,6000);
			System.out.println("\nProducing item : " + q);
			queue.put(q);
			System.out.println("After Production queue : " + queue);
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
class ConsumerDQ extends Thread{
	private BlockingQueue queue;
	public ConsumerDQ(BlockingQueue queue,String name) {
		super(name);
		this.queue = queue;
	}
	@Override
	public void run() {
		while(true){
		try {
			DelayBQ q1= (DelayBQ) queue.take();
			System.out.println("\nConsuming item : " + q1);
			System.out.println("After Consumption queue : " + queue);
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
}
	
