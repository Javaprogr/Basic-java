package com.Demo.basic;

public class Reversejava {

	
	public static void main(String[] args) {
	
		
		int number = 12345;
		int reversedNumber = 0;
		while(number > 0){
            
            //use modulus operator to strip off the last digit
            int temp = number%10;
           
           
			//create the reversed number
            reversedNumber = reversedNumber*10 + temp;
            number = number/10;
             
    }
   
    //output the reversed number
    System.out.println("Reversed Number is: " + reversedNumber);
		
		
	}

}
