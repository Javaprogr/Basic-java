package com.Demo.forloop;

public class Fabincoseries {

	
	public static void main(String[] args) {
		int fab=0;
		int num=1;
		int c;
			
		for(int i = 1;i<10;i++){
			
		c=fab+num;
		fab=num;
		num=c;
		
		System.out.println(c);
		
		}

	}

}
