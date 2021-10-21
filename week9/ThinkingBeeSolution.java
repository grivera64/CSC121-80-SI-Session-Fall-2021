//package week9;

/*
 * 
 * Name: ThinkingBeeSolution.java
 * Purpose: A program used to extract the number of times
 * 			the "Bee Movie" script (and any other script!) says the word "bee"
 * 			(or any other word!)
 * Author: Giovanni Rivera (grivera64)
 * Date: 10/17/2021
 * 
 */

/* 
 * 
 * Algorithm
 * 
 * Input:
 * 1. Ask the user for a file name (in our case: "Bee Movie Script.txt")
 * 
 * 2. Verify the file exists
 * 		- if the file doesn't exist, quit the program
 * 
 * 3. Verify that the file has content
 * 		- if the file has no content, quit the program
 * 
 * 4. Ask the user for the word to search for (in our case: "Bee")
 * 
 * Process:
 * 1. Create an int variable called numberOfAppearances to track the word's appearances
 * 
 * 2. Read the file word-by-word, keeping track of the current word we're on
 * 		
 * 		- if the current word contains the the word we are searching for ("bee"),
 * 		then we found an instance of bee. As a result, we increment numberOfAppearances by 1
 * 
 * Output:
 * 1. Print the searched word and its number of appearances as so:
 * 
 * The word "WORD" appeared ## times in FILE.
 * (End with new line)
 * 
 */

/* ==== Required Imports ==== */
import java.io.IOException;														// Stops our program from crashing if file doesn't exist
import java.io.File;															// Allows us to find and open files
import java.util.Scanner;														//Allows to read input from keyboard and file

/* A class for the name of our Java file */
public class ThinkingBeeSolution
{
	
	/* Entry point for the program */
	public static void main(String[] args) throws IOException 					// DON'T FORGET TO THROWS
	{
		
		/* Initialize our keyboard's access via a Scanner object */
		Scanner keyboard = new Scanner(System.in);
		
		/* Local Variables */
		String nameOfFile;
		File fileObject;
		Scanner fileScanner;
		
		/* ================================ Input ========================== */
		
		/* Ask the user for a file */
		System.out.print("Please enter the movie's script file: ");
		nameOfFile = keyboard.nextLine();
		
		/* Attempt to find and open the file */
		fileObject = new File(nameOfFile);
		if (!fileObject.exists())
		{
			
			/* If the file does not exist, hard stop the program */
			System.out.println("The file does not exist! Aborting program!");
			System.exit(1);														// Indicates that we had an error
			
		}
		
		fileScanner = new Scanner(fileObject);
		
		if (!fileScanner.hasNext()) 											// Make sure the first thing in the file 
		{																		// isn't an EOF sign
			
			System.out.println("The file is empty! Aborting program!");
			System.exit(1);														// Indicates that we had an error
			
		}
		
		/* ================================ Process =========================== */
		
		/* Local variables */
		String searchWord;
		String currentWord;
		int numberOfAppearances = 0;											// we first start with 0 appearances
		
		/* Ask user for what word to search for */
		System.out.println("What word would you like to search for?");
		searchWord = keyboard.nextLine();										// Take in word from keyboard
		searchWord = searchWord.toUpperCase();									// Keeps consistent spelling
		
		/* Search through every word in the file */
		while (fileScanner.hasNext())											// while we haven't read our
		{																		// entire script
			
			currentWord = fileScanner.next();									// extract a word from script file
			currentWord = currentWord.toUpperCase();							// Keeps consistent spelling
			
//			System.out.println(currentWord);									// Uncomment this to view entire script
																				// NOT RECOMMENDED; it's LONG
			
			/* If and only if the search word matches the current word */
			if (currentWord.contains(searchWord))
			{
			
				numberOfAppearances++;											// Increment the number of appearances
																				// by one (1)
				
			}
			
		}
		
		/* =============================== Output ========================= */
		
		/* Print out our results */
		System.out.printf("The word \"%s\" appeared %d times in %s\n", 
							searchWord, numberOfAppearances, nameOfFile);
		
		fileScanner.close();													// It's good practice to close 
		keyboard.close(); 														// your Scanner objects
		
	}

}
