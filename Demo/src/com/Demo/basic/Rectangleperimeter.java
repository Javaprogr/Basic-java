package com.Demo.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rectangleperimeter {

	public static void main(String[] args) {

		 int l = 0;
		 int w =0;
		 try { 
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 System.out.println("enter length");
			l=Integer.parseInt(br.readLine());
		 System.out.println("enter width");
			w =Integer.parseInt(br.readLine());
			
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		  int  Perimeter = 2*(1+w);
		  
		  System.out.println("Perimeter of rectangle " + Perimeter);
		
		

	}

}
