package com.prathamesh.concurrency;

import java.util.concurrent.Exchanger;

public class TestExchanger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exchanger exchanger = new Exchanger();
		Exchange ex1 =new Exchange(exchanger, "A");
		Exchange ex2=new Exchange(exchanger, "B");
		ex1.start();
		ex2.start();

	}

}
class Exchange extends Thread{
	Exchanger ex;
	String name;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String nm=this.name;
		try {
			this.name=(String) this.ex.exchange(this.name);
System.out.println(Thread.currentThread().getName() + " exchanged " + nm + " for " + this.name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Exchange(Exchanger ex, String name) {
		super();
		this.ex = ex;
		this.name = name;
	}
}