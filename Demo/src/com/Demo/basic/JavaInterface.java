package com.Demo.basic;

interface java{
	
	public void hello();
	
}



public class JavaInterface  implements java {

	public void hello() {
		System.out.println("helloworld");
		
	}
	public static void main(String[] args) {
		
		JavaInterface JI = new JavaInterface();
		JI.hello();
	}


	

}
