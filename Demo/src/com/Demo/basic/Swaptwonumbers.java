package com.Demo.basic;

public class Swaptwonumbers {

	public void beforeswap(){
		int num1 = 100;
		int num2 = 200;
	System.out.println("before swapping");
	System.out.println("number1 is "+num1);
	System.out.println("number2 is "+num2);
		
	}
	
	
	public static void main(String[] args) {
		
		int num1 = 100;
		int num2 = 200;
		int temp;
	
	temp=num1;
	num1=num2;
	num2=temp;
	Swaptwonumbers sw = new Swaptwonumbers();
	sw.beforeswap();
	System.out.println("After swapping");
	System.out.println("number1 is "+num1);
	System.out.println("number2 is "+num2);
	}

}
