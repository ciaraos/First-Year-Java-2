
/* SELF ASSESSMENT 
   1. createSequence:
Did I use the correct method definition?
Mark out of 5: 5
Comment: I used public static int[]
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5: 5
Comment: yes, I passed it as a parameter and initialised it
Did I return the correct item?
Mark out of 5: 5
Comment: I returned the array
   2. crossOutMultiples
Did I use the correct method definition?
Mark out of 5: 5
Comment: I used public static int[]
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2: 2
Comment: yes, I used if statements
Did I loop through the array using the correct multiple?
Mark out of 5: 5
Comment: yes, I looped through the array using the correct multiple
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3: 3
Comment: yes, I crossed out the correct items in the array
   3. sieve   
Did I have the correct function definition?
Mark out of 5: 5
Comment: yes, I used public static int[]
Did I make calls to other methods?
Mark out of 5: 5
Comment: I called crossOutHigherMultiples within sieve
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2: 2
Comment: yes, my array crosses out all numbers that are not prime
   4. sequenceTostring  
Did I have the correct function definition?
Mark out of 5: 5
Comment: yes, I used public static string
Did I ensure the parameter to be used is not null?
Mark out of 3: 3
Comment: yes I used an if statement
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10: 10
Comment: yes, I updated the String
   5. nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5: 5
Comment: public static string   
Did I ensure the parameter to be used is not null?  
Mark out of 3: 3
Comment: yes, I used an if statement
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5: 5
Comment: yes, only prime numbers are printed out
   6. main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5: 5
Comments: yes, I used if statements
Did I make calls to other methods (at least one)?
Mark out of 5: 5
Comment: I called createSequence, sieve, sequenceToString and nonCrossedOutSubseqToString 
Did I print the output as shown in the question?  
Mark out of 5: 5
Comment: I print out the sequence, non primes and primes 
   7. Overall
Is my code indented correctly?
Mark out of 4: 4
Comments: I indented where necessary
Do my variable names make sense?
Mark out of 4: 4
Comments: I believe my variable names make sense and are easy to follow
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4: 4
Comments: I believe they do
      Total Mark out of 100 (Add all the previous marks): 100
*/
import java.util.Scanner;

public class SieveOfEratosthenes {
	public static int[] createSequence(int integerEntered, int[] integerArray) 
	{
		int answer = 2;
		for (int index = 0; index < integerArray.length && answer <= integerEntered; index++) 
		{
			integerArray[index] = answer;
			System.out.print(answer);
			if (integerArray[index] == integerEntered) 
			{
				System.out.print(".");
			} 
			else 
			{
				System.out.print(", ");
			}
			answer++;
		}
		System.out.print("\n");
		return integerArray;
	}

	public static int[] crossOutHigherMultiples(int[] integerArray, double primeChecker) 
	{
		if (integerArray != null) 
		{
			for (int index = 0; index < integerArray.length; index++) 
			{
				if (integerArray[index] % primeChecker == 0 && integerArray[index] != primeChecker
						&& integerArray[index] > 0) 
				{
					integerArray[index] *= -1;
				}
			}
			return integerArray;
		}
		return null;
	}

	public static int[] sieve(int integerEntered, int[] integerArray) 
	{
		double primeChecker = Math.sqrt(integerEntered);
		for (int index = 0; integerArray[index] <= primeChecker; index++) 
		{
			int primeChecker2 = integerArray[index];
			if (primeChecker2 > 0) 
			{
				crossOutHigherMultiples(integerArray, primeChecker2);
				System.out.println(sequenceToString(integerArray));
			}
		}
		return integerArray;
	}

	public static String sequenceToString(int[] integerArray) 
	{
		String outputString = "";
		if (integerArray != null) 
		{
			for (int index = 0; index < integerArray.length - 1; index++) 
			{
				if (integerArray[index] > 0) 
				{
					if (index == integerArray.length - 1) 
					{
						outputString += integerArray[index];
					} 
					else 
					{
						outputString += integerArray[index] + ", ";
					}
				} 
				else 
				{
					outputString += "[" + (integerArray[index] * -1) + "], ";
				}
			}
			outputString = outputString.substring(0, outputString.length() - 2);
			outputString += ".";
			return outputString;
		}
		return null;
	}

	public static String nonCrossedOutSubseqToString(int[] integerArray, int integerEntered) 
	{
		String answerString = "";
		if (integerArray != null) 
		{
			for (int index = 0; index < integerArray.length; index++) 
			{
				if (integerArray[index] > 0) 
				{
					answerString += integerArray[index] + ", ";
				}
			}
			answerString = answerString.substring(0, answerString.length() - 2);
			answerString += ".";
			return answerString;
		}
		return null;
	}

	public static void main(String[] args) {
		boolean finished = false;
		while (!finished) 
		{
			System.out.print("Enter a positive integer N, whose value is at least 2 (or type 'exit') ");
			Scanner inputScanner = new Scanner(System.in);
			if (inputScanner.hasNextInt()) 
			{
				int integerEntered = inputScanner.nextInt();
				int[] integerArray = new int[integerEntered];
				createSequence(integerEntered, integerArray);
				sieve(integerEntered, integerArray);
				System.out.println(nonCrossedOutSubseqToString(integerArray, integerEntered));
			} 
			else if (inputScanner.hasNext("exit")) 
			{
				System.out.print("Goodbye");
				inputScanner.close();
				finished = true;
			} 
			else 
			{
				System.out.println("Invalid input, please enter a whole positive integer, whose value is 2 or more e.g. 4");
			}

		}
	}

}
