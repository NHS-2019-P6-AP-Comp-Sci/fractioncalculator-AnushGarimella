/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// This is the scanner that will take my input
		Scanner firstInput = new Scanner(System.in);
		System.out.println("Welocome to fraction calculator!");
		// TODO: Read the input from the user and call produceAnswer with an equation
		System.out.println("Please enter the values to be calculated");
		// The String "fraction" will take the input from the Scanner "firstInput".
		int x = 0;
		while (x <= 100) {
			String fraction = firstInput.nextLine();
			if (!fraction.equals("quit")) {
				System.out.println(produceAnswer(fraction));
			} else {
				System.out.println("Program terminated");
				break;
			}
		}

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		// TODO: Implement this function to produce the solution to the input
		Scanner math = new Scanner(input);
		String firstOperand = math.next();
		String operator = math.next();
		String secondOperand = math.next();
		String result = "";		
		String whole = "whole:";
		String numerator = " numerator:";
		String denominator = " denominator:";;
		int x = secondOperand.indexOf("_");
		int y = secondOperand.indexOf("/");
		if (!secondOperand.contains("_") && !secondOperand.contains("/")) {
			result += whole + secondOperand;
			result += numerator + 0;
			result += denominator + 1; 
		} else if (!secondOperand.contains("_")) {
			result += whole + 0;
			result += numerator + secondOperand.substring(x + 1, y);
			result += denominator + secondOperand.substring(y + 1, secondOperand.length());
		} else {
			result += (whole + secondOperand.substring(0, x));
			result += (numerator + secondOperand.substring(x + 1, y));
			result += (denominator + secondOperand.substring(y + 1, secondOperand.length()));
		}
		return result;
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
