import java.io.IOException;
import java.util.Scanner;

/* SELF ASSESSMENT 
Class Rational 
I declared two member variables: numerator and denominator (marks out of 4: 4).
Comment: I declared these as private ints 
Constructor 1 
My program takes take two integers as parameters (for numerator and denominator) and initialises the member variables with the corresponding values . If the denominator is equal to 0 I throw an exception (marks out of 5: 5).
Comment: my code does this 
Constructor 2 
My program takes only one integer as parameter (numerator), and set the numerator to this value . I set the denominator to 1 in this case, as the resulting rational number in this case is an integer (marks out of 3: 3).
Comment: my code does this
Add Method 
My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator which the addition of the two objects - this and the parameter. My program does not overwrite any of the other two rational numbers (marks out of 8: 8).
Comment: I believe m program does this
Subtract Method 
I have implemented this the same as add method, except it implements subtraction (marks out of 8: 8).
Comment: I believe my program does this
Multiply Method 
I have implemented this the same as add method, except it implements multiplication (marks out of 8: 8).
Comment: I believe my program does this
Divide Method 
I have implemented this the same as add method, except it implements divide (marks out of 8: 8).
Comment: I believe my program does this 
Equals Method 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication between numerators/denominators for the purpose of comparison, as integer division will lead to incorrect results. I return a boolean value ((marks out of 8: 8).
Comment: I believe my program does this
isLessThan 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication as integer division will lead to incorrect results. I return a boolean value (marks out of 8: 6).
Comment: My program does this but also prints out smaller if they are equal 
Simplify Method 
My program returns a rational number but not a new rational number, instead it returns the current reference which is this. It doesn't take any parameters as it works only with the reference object. I first find the greatest common divisor (GCD) between the numerator and denominator, and then obtain the new numerator and denominator by dividing to the GCD (marks out of 8: 8).
Comment: I believe my program does this
gcd function 
My program returns the greatest common divider of two integers: the numerator and the denominator (marks out of 6: 6).
Comment: I believe my program does this
toString Method 
My program returns a string showing the fraction representation of the number, eg. "1/2". It takes no parameters (marks out of 4: 4).
Comment: My program prints out the correct answer

Test Client Class 
My program asks the user for two rational numbers, creates two rational objects using the constructor and passing in the provided values, calls addition, subtraction, multiplication, division, comparison and simplification and prints out the results (marks out of 22: 22).
Comment: I believe my program does all these things
total: 98/100
*/
public class RationalNumbers {
	public static void main(String[] args) throws IOException {
		boolean finished = false;
		Scanner inputScanner = new Scanner(System.in);
		while (!finished) {
			System.out.print("Enter a numerator (or type 'quit') ");
			if (inputScanner.hasNextInt()) {
				int numeratorEntered = inputScanner.nextInt();
				System.out.print("Enter a denominator ");
				if (inputScanner.hasNextInt()) {
					int denominatorEntered = inputScanner.nextInt();
					calculations fraction1 = new calculations(numeratorEntered, denominatorEntered);
					System.out.print("Enter another numerator ");
					if (inputScanner.hasNextInt()) {
						int secondNumerator = inputScanner.nextInt();
						System.out.print("Enter another denominator ");
						if (inputScanner.hasNextInt()) {
							int secondDenominator = inputScanner.nextInt();
							calculations fraction2 = new calculations(secondNumerator, secondDenominator);
							fraction1.add(fraction2);
							fraction1.subtract(fraction2);
							fraction1.multiply(fraction2);
							fraction1.divide(fraction2);
							if (fraction1.equals(fraction2) == true) {
								System.out.println("These fractions are equal");
							}
							if (fraction1.isLessThan(fraction2) == true) {
								System.out.println("The first fraction is smaller than the second");
							} else if (fraction1.isLessThan(fraction2) == false) {
								System.out.println("The second fraction is smaller than the first");
							}
						}
					}
				}
			} /*
				 * else if (inputScanner.hasNext("quit")) {
				 * inputScanner.close(); finished = true;
				 * System.out.print("Goodbye"); } else { System.out.println(
				 * "Please enter a number greater than 0 ");
				 * inputScanner.hasNextInt(); }
				 */
		}
	}

}
