package com.Demo.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Evenoddnumber {


	public static void main(String[] args) {
	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter any number ");
		
		int a = 0;
		try {
			a = Integer.parseInt(bfr.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		if(a%2==0){
			
			System.out.println("number is even "+a);
			
		}
		else{
			System.out.println("number is odd "+a);
		}
	}

}
