package com.Demo.basic;

public class Swapwithouttemp {
	
	public static void main(String[] args) {
		
		int a=10;
		int b=20;
		System.out.println("before sawp");
		System.out.println("number is "+a);
		System.out.println("number is "+b);
		
		System.out.println("After sawp");
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("number is "+a);
		System.out.println("number is "+b);
		
	}
	
	
	
	// Below  prg is also correct
	/*static int a=10;
	static int b= 20;
	public void sawp1(int a, int b){
		 a =b;
		 System.out.println("number is "+a);
	}
	
	public void sawp2(int a, int b){
		 b =a;
		 System.out.println("number is "+b);
	}
	
	public static void main(String[] args) {
		Swapwithouttemp sw = new Swapwithouttemp();
		
		System.out.println("before sawp");
		System.out.println("number is "+a);
		System.out.println("number is "+b);
		
		System.out.println("After sawp");
		sw.sawp1(90,100);
		sw.sawp2(90,100);
		
	
	
	}*/

}
