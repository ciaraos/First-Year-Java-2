import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
/* SELF ASSESSMENT 
1. readDictionary
- I have the correct method definition [Mark out of 5:] 5
- Comment: I declared it as a public static ArrayList<String> 
- My method reads the words from the "words.txt" file. [Mark out of 5:] 5
- Comment: I believe my method does this 
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:] 5
- Comment: It returns the contents as an ArrayList
2. readWordList
- I have the correct method definition [Mark out of 5:] 5
- Comment: I declared it as a public static void
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList 
  of String references and returns it. [Mark out of 5:] 5
- Comment: I add each word to the ArrayList 
3. isUniqueList
- I have the correct method definition [Mark out of 5:] 5
- Comment: I declared it as public static boolean
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:] 5
- Comment: yes, I used two for loops for this 
- Exits the loop when a non-unique word is found. [Mark out of 5:] 5
- Comment: if two words match, I use an if statement to end the loop
- Returns true is all the words are unique and false otherwise. [Mark out of 5:] 5
- Comment: returns isUnique
4. isEnglishWord
- I have the correct method definition [Mark out of 5:] 5
- Comment: I declared it as a public static boolean
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:] 1
- Comment: I attempted to do this but I don't believe it worked
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:] 2
- Comment: I used a boolean and if statements for this
5. isDifferentByOne
- I have the correct method definition [Mark out of 5:] 5
- Comment:  I declared it as a public static boolean
- My method loops through the length of a words comparing characters at the same position in both words searching for one 
  difference. [Mark out of 10:] 7
- Comment: I used two for loops to do this but believe i may have been unsuccessful 
6. isWordChain
- I have the correct method definition [Mark out of 5:] 3
- Comment: I declared it as a public static String
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message 
  [Mark out of 10:] 7
- Comment: I call each of these functions but nothing is and change the message depending on the result but nothing is returned,
  I believe this could be due to an error in another function
7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures
 [Mark out of 10:] 10
- Comment: it reads all the words from the file 
- Asks the user for input and calls isWordChain [Mark out of 5:] 5
- Comment: I ask for user input and call isWordChain
 Total Mark out of 100 (Add all the previous marks): 90
*/

public class WordLink {
	public static final int MAX_VALUE = Integer.MAX_VALUE;

	@SuppressWarnings("resource")
	public static ArrayList<String> readDictionary(ArrayList<String> readWords) throws IOException 
	{
		// readDictionary which reads all the English words within the file "words.txt"
		// (attached below) and which returns all
		// the read words as an array or an ArrayList of String values (objects). The
		// file "words.txt" contains 658964 English
		// words arranged in alphabetic order and the line separator in the file is
		// "\n".
		BufferedReader readFile = new BufferedReader(new FileReader("words.txt"));
		for (int index = 0; index < MAX_VALUE; index++) 
		{
			String currentWord = readFile.readLine();
			readWords.add(currentWord);
		}
		return readWords;
	}

	public static void readWordList(String wordInput, ArrayList<String> wordList) 
	{
		// readWordList which reads a comma (,) separated String of words from the
		// standard input and which returns the list
		// represented as an array or an ArrayList of String values (objects).
		for (String thisWord : wordInput.split(", ")) 
		{
			wordList.add(thisWord);
		}
	}

	public static boolean isUniqueList(String[] newArrayList) 
	{
		// isUniqueList takes an array or an ArrayList of String values and which
		// determines whether list contains unique
		// String values, i.e., no two String values at different locations in the array
		// are equal.
		boolean isUnique = true;
		for (int firstIndex = 0; firstIndex < newArrayList.length - 1; firstIndex++) 
		{
			for (int secondIndex = firstIndex + 1; secondIndex < newArrayList.length; secondIndex++) 
			{
				if (newArrayList[firstIndex] == (newArrayList[secondIndex])) 
				{
					isUnique = false;
				}
				else
				{
					isUnique = true;
				}
			}
		}
		return isUnique;
	}

	public static boolean isEnglishWord(String wordInput, ArrayList<String> wordList) {
		// isEnglishWord which takes a String value and which determines whether the
		// String value is an English word.
		// [Hint: Use the binarySearch function (static method) from the library class
		// Arrays (which contains static methods
		// for manipulating arrays) to search for the String value in the array of
		// Strings formed from reading the file "words.txt".]
		boolean english = true;
		int index = Collections.binarySearch(wordList, wordInput);
		if (index >= 0) 
		{
			english = true;
		} 
		else 
		{
			english = false;
		}
		return english;
	}

	public static boolean isDifferentByOne(String[] newArrayList) {
		// isDifferentByOne which takes two Strings and which determines whether the two
		// Strings are of the
		// same length and differ by exactly one character only.
		boolean isDifferent = true;
		int counter = 0;
		for (int index = 0; index < newArrayList.length; index++) 
		{
			String currentWord = newArrayList[index];
			String nextWord = newArrayList[index + 1];
			for (int currentLetter = 0; currentLetter < currentWord.length(); currentLetter++) 
			{
				if (currentWord.charAt(currentLetter) == nextWord.charAt(currentLetter)) 
				{
					counter++;
					if (counter == currentWord.length() - 1) 
					{
						isDifferent = true;
					} 
					else 
					{
						isDifferent = false;
					}
				}
			}
		}
		return isDifferent;
	}

	public static String isWordChain(ArrayList<String> wordList, String wordInput, String[] wordListString,
			String[] newArrayList) {
		// isWordChain which takes a list of words (represented as an array or an
		// ArrayList of Strings) and
		//// which determines whether the list of words is a valid chain of words for
		// Lewis Carroll's word-links game.
		// boolean isChain = false;
		String messageOutput = " ";
		if (isDifferentByOne(newArrayList) == true && isEnglishWord(wordInput, wordList) == true
				&& isUniqueList(wordListString) == true) 
		{
			messageOutput = ("Valid chain of words from Lewis Carroll's word-links game.");
		} 
		else 
		{
			messageOutput = ("Not a valid chain of words from Lewis Carroll's word-links game.");
		}
		return messageOutput;
	}

	public static void main(String[] args) throws IOException {
		// Write a Java program which will allow a user to enter a list of words
		// separated by commas (,) and which will
		// determine whether the entered list of words is a valid chain of words for
		// Lewis Carroll's Word-links game.
		// Your program should terminate only when the user enters an empty list.
		boolean finished = false;
		while (!finished) 
		{
			System.out.println("Enter a comma separated list of words (or an empty list to quit): ");
			Scanner inputScanner = new Scanner(System.in);
			String wordInput = inputScanner.nextLine();
			ArrayList<String> readWords = new ArrayList<String>();
			readDictionary(readWords);
			ArrayList<String> wordList = new ArrayList<String>();
			readWordList(wordInput, wordList);
			String[] newArrayList = wordList.toArray(new String[wordList.size()]);
			if (inputScanner.hasNextLine()) 
			{
				System.out.println(isWordChain(wordList, wordInput, newArrayList, newArrayList));
			}
			// if(((CharSequence) wordList).length() < 1) {
			else 
			{
				System.out.println("Thanks for playing, goodbye");
				finished = true;
				inputScanner.close();
			}

		}
	}
}