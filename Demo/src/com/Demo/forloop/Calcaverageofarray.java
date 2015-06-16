package com.Demo.forloop;

public class Calcaverageofarray {

	
	public static void main(String[] args) {
		
		int[] num = new int[]{10,20,30,40};
		
		int sum = 0;
	for(int i = 0;i<num.length;i++)	{
		sum= sum+num[i];
	
		}
	System.out.println("Sum is "+sum);
	int Average = sum/num.length;
	System.out.println("Avg is "+Average);
	}

}
