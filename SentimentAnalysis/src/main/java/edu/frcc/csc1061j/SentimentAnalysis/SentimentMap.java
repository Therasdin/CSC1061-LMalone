package edu.frcc.csc1061j.SentimentAnalysis;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.frcc.csc1061j.SentimentAnalysis.MyHashMap.Entry;

public class SentimentMap {
	
	  public static void main(String[] args) throws IOException {
	    // create a HashMap mapping Strings to Integers
	    HashMap<String, Integer> sentimentMap = new HashMap<String, Integer>();

	    // load the data file into the hash table
	    Scanner input = new Scanner(new File("sentiments.txt"));
	    while (input.hasNextLine()) {
	      String line = input.nextLine();
	      String[] tokens = line.split(",");
	      sentimentMap.put(tokens[0], Integer.parseInt(tokens[1]));
	    }
	    input.close();
    
	    // get user input from the keyboard
	    Scanner scanner = new Scanner(System.in);
	    int totalSentiment = 0;
	    int wordCount = 0;
	    
	    StringBuilder inputStringBuilder = new StringBuilder();
		while (true) {
			System.out.println("Enter a word or phrase (type Q to quit): ");
			String inputString = scanner.nextLine();
			if(inputString.equalsIgnoreCase("Q")) { // changed to ignore case for "Q"
				break;
			}
			//makes text lower case with no special characters
			String[] words = inputString.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			for(String word : words) {
				String newWord = word.replaceAll("\\s", "");
				if(newWord.equals("Q")) {
					break;
				}
				wordCount++;
				if(sentimentMap.containsKey(newWord)) {
					totalSentiment += sentimentMap.get(newWord);
				}
			}
		}
		scanner.close();
		
		double avgSentiment = (double) totalSentiment / wordCount;
		
		//console output - fixed formatting and added newline character
		System.out.println("Word count: " + wordCount);
		System.out.printf("Total Sentiment: %d%n", totalSentiment); // added comma and newline
		System.out.printf("Average Sentiment: %.2f%n", avgSentiment); // added newline
	}
}