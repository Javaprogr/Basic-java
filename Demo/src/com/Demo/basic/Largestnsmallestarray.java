package com.Demo.basic;

public class Largestnsmallestarray {

	
	public static void main(String[] args) {

		
		int a[]=new int[]{45,56,64,82,12,31};
		
		int small = a[0];
		int large = a[0];
		
		for (int i = 0;i<a.length;i++){
			
			if(a[i]>large)
				large = a[i];
				elseif(a[i]<small) ;
					small = a[i];
				
				
				
			
		}
			System.out.println("Number is large " +large);
			System.out.println("Number is small " +small);
	
	}

	private static void elseif(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
