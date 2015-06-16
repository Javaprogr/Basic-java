package com.Demo.basic;

public class Javaclasstest {
	
	private String name;
	
	public void setName(String n){
		name =n;
	}
	
	public String getName(){
		return name;
		
	}

	public static void main(String[] args) {
		
Javaclasstest jc = new Javaclasstest();
jc.setName("vyas");
System.out.println(" Hello "+ jc.getName());

	}

}
