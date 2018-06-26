package com.prathamesh.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TestCountdownLatch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
/**
 * CountDownLatch demo +  methods of CountDownLatch
 */
CountDownLatch latch = new CountDownLatch(3);
Developer d1 = new Developer ("aaaaaa", latch);
Developer d2 = new Developer ("bbbbbb", latch);
Developer d3 = new Developer ("cccccc", latch);
d1.start();
d2.start();
d3.start();
System.out.println("current count = " + latch.getCount());//Third method
Thread.sleep(5000);
latch.await();// First method
System.out.println("\n All Developer's task is completed !");

CountDownLatch latch1 = new CountDownLatch(2);
Tester t1 = new Tester ("ddddd",latch1);
Tester t2 = new Tester ("eeeee",latch1);
t1.start();
t2.start();
Thread.sleep(5000);
latch.await(2000, TimeUnit.MILLISECONDS);//second method---overloaded await
System.out.println("\n All Tester's task is completed !");
	}

}

class Developer extends Thread{
	private String devName;
	private CountDownLatch latch;
	@Override
	public void run() {
		System.out.println("\n Executing task of Developer" + Thread.currentThread().getName());
		for(int i=0;i<10;i++){
			System.out.print("  " + i);
		}
		System.out.println("\n Task of Developer " + Thread.currentThread().getName() + " is completed");
		System.out.println("\n");
		latch.countDown();//Fourth method
	}
	public Developer(String devName, CountDownLatch latch) {
		super();
		this.devName = devName;
		this.latch = latch;
	}
	@Override
	public String toString() {
		return "Developer [devName=" + devName + ", latch=" + latch + "]";
	}
}
class Tester extends Thread{
	private String testerName;
	private CountDownLatch latch;
	@Override
	public void run() {
       System.out.println("\n");
		System.out.println("\n Executing task of Tester " + Thread.currentThread().getName());
		for(int i=10;i<20;i++){
			System.out.print("  " + i);
		}
		System.out.println("\n Task of Tester " + Thread.currentThread().getName() + " is completed");
		System.out.println("\n");
		latch.countDown();
	}
	public Tester(String testerName, CountDownLatch latch) {
		super();
		this.testerName = testerName;
		this.latch = latch;
	}
	@Override
	public String toString() {
		return "Tester [testerName=" + testerName + ", latch=" + latch + "]";
	}
}