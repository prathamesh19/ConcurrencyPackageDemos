package com.prathamesh.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

	
	/**
	 * PROBLEM STATEMENT-- 4 THREADS ARE THERE. EACH HAS TO WAIT FOR OTHER'S TO PRINT 0-25, 26-50, 51-75 
	 * AND 76-100 AND THEN STOP EXECUTION.
	 * 
	 * @author prathamesh
	 * @param args
	 * @throws InterruptedException
	 * @throws BrokenBarrierException
	 */
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
CyclicBarrier barrier=new CyclicBarrier(4,new BarrierAction());
		A a =new A(barrier,"\n Thread A");
		B b=new B(barrier,"\n Thread B");
		C c=new C(barrier,"\n Thread C");
		D d= new D(barrier,"\n Thread D");
		a.start();
		b.start();
		c.start();
		d.start();
	}

}
class BarrierAction extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("\n ------------Current Barrier Reached !--------------");
	}
	
}

class A extends Thread{
CyclicBarrier barrier1;
	public A(CyclicBarrier barrier1,String name) {
	super(name);
	this.barrier1 = barrier1;
}
	@Override
	public void run() {
		
		try {
			
			System.out.println("\n Thread A task 1 started");   
       for (int i=0;i<=25;i++){
	   System.out.print(" " + i);
         }
       System.out.println("\n Thread A task 1 completed");
       
		barrier1.await();
		Thread.sleep(5000);
		
		System.out.println("\n Thread A task 2 started");
       for(int i=26;i<=50;i++){
    	   System.out.print(" " + i);
       }
       System.out.println("\n Thread A task 2 completed");
       
       barrier1.await();
       Thread.sleep(5000);
       
       System.out.println("\n Thread A task 3 started");
       for(int i=51;i<=75;i++){
    	   System.out.print(" " + i);
       }
       System.out.println("\n Thread A task 3 completed");
       
       barrier1.await();
       Thread.sleep(5000);
       
       System.out.println("\n Thread A task 4 started");
       for(int i=76;i<=100;i++){
    	   System.out.print(" " + i);
       }
       System.out.println("\n Thread A task 4 completed");
       
       barrier1.await();
       Thread.sleep(5000);
       
       
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class B extends Thread{
CyclicBarrier barrier1;
	public B(CyclicBarrier barrier1,String name) {
	super(name);
	this.barrier1 = barrier1;
}
	@Override
	public void run() {
		
		try {
			
			System.out.println("\n Thread B task 1 started");   
       for (int i=0;i<=25;i++){
	   System.out.print(" " + i);
         }
       System.out.println("\n Thread B task 1 completed");
       
		barrier1.await();
		Thread.sleep(5000);
		
		System.out.println("\n Thread B task 2 started");
       for(int i=26;i<=50;i++){
    	   System.out.print(" " + i);
       }
       System.out.println("\n Thread B task 2 completed");
       
       barrier1.await();
       Thread.sleep(5000);
       
       System.out.println("\n Thread B task 3 started");
       for(int i=51;i<=75;i++){
    	   System.out.print(" " + i);
       }
       System.out.println("\n Thread B task 3 completed");
       
       barrier1.await();
       Thread.sleep(5000);
       
       System.out.println("\n Thread B task 4 started");
       for(int i=76;i<=100;i++){
    	   System.out.print(" " + i);
       }
       System.out.println("\n Thread B task 4 completed");
       
       barrier1.await();
       Thread.sleep(5000);
       
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class C extends Thread{
CyclicBarrier barrier1;
	public C(CyclicBarrier barrier1,String name) {
	super(name);
	this.barrier1 = barrier1;
}
	@Override
	public void run() {
		
		try {
			
			System.out.println("\n Thread C task 1 started");   
       for (int i=0;i<=25;i++){
	   System.out.print(" " + i);
         }
       System.out.println("\n Thread C task 1 completed");
       
		barrier1.await();
		Thread.sleep(5000);
		
		System.out.println("\n Thread C task 2 started");
       for(int i=26;i<=50;i++){
    	   System.out.print(" " + i);
       }
       System.out.println("\n Thread C task 2 completed");
       
       barrier1.await();
       Thread.sleep(5000);
       
       System.out.println("\n Thread C task 3 started");
       for(int i=51;i<=75;i++){
    	   System.out.print(" " + i);
       }
       System.out.println("\n Thread C task 3 completed");
       
       barrier1.await();
       Thread.sleep(5000);
       
       System.out.println("\n Thread C task 4 started");
       for(int i=76;i<=100;i++){
    	   System.out.print(" " + i);
       }
       System.out.println("\n Thread C task 4 completed");
       
       barrier1.await();
       Thread.sleep(5000);
       
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class D extends Thread{
CyclicBarrier barrier1;
	public D(CyclicBarrier barrier1,String name) {
	super(name);
	this.barrier1 = barrier1;
}
	@Override
	public void run() {
		
		try {
			
			System.out.println("\n Thread D task 1 started");   
       for (int i=0;i<=25;i++){
	   System.out.print(" " + i);
         }
       System.out.println("\n Thread D task 1 completed");
       
		barrier1.await();
		Thread.sleep(5000);
		
		System.out.println("\n Thread D task 2 started");
       for(int i=26;i<=50;i++){
    	   System.out.print(" " + i);
       }
       System.out.println("\n Thread D task 2 completed");
       
       barrier1.await();
       Thread.sleep(5000);
       
       System.out.println("\n Thread D task 3 started");
       for(int i=51;i<=75;i++){
    	   System.out.print(" " + i);
       }
       System.out.println("\n Thread D task 3 completed");
       
       barrier1.await();
       Thread.sleep(5000);
       
       System.out.println("\n Thread D task 4 started");
       for(int i=76;i<=100;i++){
    	   System.out.print(" " + i);
       }
       System.out.println("\n Thread D task 4 completed");
       
       barrier1.await();
       Thread.sleep(5000);
       
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}