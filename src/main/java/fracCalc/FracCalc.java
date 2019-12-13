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
		/*
		 * String result = ""; String whole = "whole:"; String numerator =
		 * " numerator:"; String denominator = " denominator:";
		 */
		int w1 = 0;
		int num1 = 0;
		int den1 = 0;
		if (firstOperand.contains("_") && firstOperand.contains("/")) {
			w1 += Integer.valueOf(firstOperand.substring(0, firstOperand.indexOf('_')));
			num1 += Integer.valueOf(firstOperand.substring(firstOperand.indexOf('_') + 1, firstOperand.indexOf('/')));
			den1 += Integer.valueOf(firstOperand.substring(firstOperand.indexOf('/') + 1, firstOperand.length()));
		} else if (!firstOperand.contains("_") && firstOperand.contains("/")) {
			w1 += 0;
			num1 += Integer.valueOf(firstOperand.substring(0, firstOperand.indexOf("/")));
			den1 += Integer.valueOf(firstOperand.substring(firstOperand.indexOf('/') + 1, firstOperand.length()));
		} else if (!firstOperand.contains("_") && !firstOperand.contains("/")) {
			w1 = Integer.valueOf(firstOperand.substring(0, firstOperand.length()));
			num1 = 0;
			den1 = 1;
		}
		int w2 = 0;
		int num2 = 0;
		int den2 = 0;
		if (secondOperand.contains("_") && secondOperand.contains("/")) {
			w2 += Integer.valueOf(secondOperand.substring(0, secondOperand.indexOf('_')));
			num2 += Integer
					.valueOf(secondOperand.substring(secondOperand.indexOf('_') + 1, secondOperand.indexOf('/')));
			den2 += Integer.valueOf(secondOperand.substring(secondOperand.indexOf('/') + 1, secondOperand.length()));
		} else if (!secondOperand.contains("_") && secondOperand.contains("/")) {
			w2 += 0;
			num2 += Integer.valueOf(secondOperand.substring(0, secondOperand.indexOf("/")));
			den2 += Integer.valueOf(secondOperand.substring(secondOperand.indexOf('/') + 1, secondOperand.length()));
		} else if (!secondOperand.contains("_") && !secondOperand.contains("/")) {
			w2 += Integer.valueOf(secondOperand.substring(0, secondOperand.length()));
			num2 += 0;
			den2 += 1;
		}
		int w3 = 0;
		int num3 = 0;
		int den3 = 0;
		if (w1 < 0) {
			num1 = (den1 * w1) - num1;
		} else {
			num1 = (den1 * w1) + num1;

		}
		if (w2 < 0) {
			num2 = (den2 * w2) - num2;
		} else {
			num2 = (den2 * w2) + num2;
		}
		if (operator.contentEquals("+")) {
			num3 += ((num1 * den2) + (num2 * den1));
			den3 += (den1 * den2);
			if (den1 == den2) {
				num3 = num1 + num2;
				den3 = den2;
			}

		} else if (operator.contentEquals("-")) {
			num3 += (num1 * den2) - (num2 * den1);
			den3 += (den1 * den2);
			if (den1 == den2) {
				num3 = num1 - num2;
				den3 = den2;
			}

		} else if (operator.contentEquals("*")) {
			num3 += (num1 * num2);
			den3 += (den1 * den2);
			if (w1 == 0 || w2 == 0) {
				w3 = 0;
			}
		} else if (operator.equals("/")) {
			num3 += (num1 * den2);
			den3 += (den1 * num2);
			if (num2 == 0) {
				return "Cannot divide by 0";
			}
			if (firstOperand.contentEquals("0") || firstOperand.contentEquals("-0")) {
				return "0";
			}
		}

		/*
		 * int x = secondOperand.indexOf("_"); int y = secondOperand.indexOf("/"); if
		 * (!secondOperand.contains("_") && !secondOperand.contains("/")) { result +=
		 * whole + secondOperand; result += numerator + 0; result += denominator + 1; }
		 * else if (!secondOperand.contains("_")) { result += whole + 0; result +=
		 * numerator + secondOperand.substring(x + 1, y); result += denominator +
		 * secondOperand.substring(y + 1, secondOperand.length()); } else { result +=
		 * (whole + secondOperand.substring(0, x)); result += (numerator +
		 * secondOperand.substring(x + 1, y)); result += (denominator +
		 * secondOperand.substring(y + 1, secondOperand.length())); }
		 */
		String whole = String.valueOf(w3);
		String numerator = String.valueOf(num3);
		String denominator = String.valueOf(den3);
		String answer = numerator + "/" + denominator;

		if (num3 % 2 == 0 && den3 % 2 == 0) {
			while (num3 % 2 == 0 && den3 % 2 == 0) {
				answer = String.valueOf((num3 / 2) + "/" + (den3 / 2));
				num3 /= 2;
				den3 /= 2;
				if (num3 % 2 != 0 && den3 % 2 != 0) {
					break;
				}
			}
		} else if (num3 % 3 == 0 && den3 % 3 == 0) {
			while (num3 % 3 == 0 && den3 % 3 == 0) {
				answer = String.valueOf((num3 / 3) + "/" + (den3 / 3));
				num3 /= 3;
				den3 /= 3;
				if (num3 % 3 != 0 && den3 % 3 != 0) {
					break;
				}
			}
		}
		if (firstOperand.contentEquals("0") || secondOperand.contentEquals("0")) {
			answer = "0";
		}
		if (num3 == 0 && den3 == 0 && operator.contentEquals("+")) {
			answer = String.valueOf(w1 + w2);
		} else if (num3 == 0 && den3 == 0 && operator.contentEquals("-")) {
			answer = String.valueOf(w1 - w2);
		} else if (num3 == 0 && den3 == 0 && operator.contentEquals("*")) {
			answer = String.valueOf(w1 * w2);
		} else if (num3 == 0 && den3 == 0 && operator.contentEquals("/")) {
			answer = String.valueOf(w1 / w2);
		} else if (num3 == 0 && den3 > 0) {
			answer = "0";
		}
		int num4 = Math.abs(num3 % den3);
		int den4 = Math.abs(den3);
		int num6 = num4 / 3;
		int den6 = den4 / 3;
		if (Math.abs(num3) > den3) {
			answer = String.valueOf((num3 / den3) + "_" + num4 + "/" + den4);
			if (num4 == 0) {
				answer = String.valueOf(num3 / den3);
			} else if (num3 / den3 == 0) {
				answer = String.valueOf((num4) + "/" + (den4));
				if (firstOperand.contains("-") || secondOperand.contains("-")) {
					answer = String.valueOf(-1 * (num4) + "/" + (den4));
				}
			} else if (num4 % 2 == 0 && den4 % 2 == 0) {
				while (num4 % 2 == 0 && den4 % 2 == 0) {
					answer = String.valueOf((num3 / den3) + "_" + (num4 / 2) + "/" + (den4 / 2));
					num4 /= 2;
					den4 /= 2;
					if (num4 % 2 != 0 || den4 % 2 != 0) {
						break;
					}
				}

			} else if (num4 % 3 == 0 && den4 % 3 == 0) {
				while (num4 % 3 == 0 && den4 % 3 == 0) {
					answer = String.valueOf((num3 / den3) + "_" + (num4 / 3) + "/" + (den4 / 3));
					num4 /= 3;
					den4 /= 3;
					if (num4 % 3 != 0 || den4 % 3 != 0) {
						break;
					}
				}

			}

		}

		if (den3 == 1) {
			answer = String.valueOf(num3);
		} else if (den3 == -1) {
			answer = String.valueOf(num3 * -1);
		}
		if (num3 == den3) {
			answer = "1";
		}

		return answer;
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
