package com.Demo.basic;

public class Factorial {


	public static void main(String[] args) {
		int num =6;
		int factorial = num;
		for(int i = (num-1);i>1;i--){
		
		 factorial = factorial*i;
		}
		
		System.out.println(factorial);

	}

}
 