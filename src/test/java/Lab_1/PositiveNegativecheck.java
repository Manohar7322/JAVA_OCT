package Lab_1;

import java.util.Scanner;

public class PositiveNegativecheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner Scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        double number=Scanner.nextDouble();
        if(number>0) 
        {
        	System.out.println("The number is positive");
        }
        else if(number<0) 
        {
        	System.out.println("The number is negative");
        }
        else {
        	System.out.println("The number is Zero");
        }
        
        Scanner.close();
        }
	}


