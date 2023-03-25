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

	    while (true) {
	      System.out.print("Enter a sentence (or END to quit): ");
	      String inputString = scanner.nextLine();

	      // exit loop if user enters "END"
	      if (inputString.equals("END")) {
	        break;
	      }

	      // remove punctuation and convert to lower-case
	      String[] words = inputString.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

	      // calculate sentiment of the input
	      for (String word : words) {
	        // remove spaces from the word
	        String modifiedWord = word.replaceAll("\\s+", "");
	        wordCount++;
	        // check if modified word is in the hash map
	        if (sentimentMap.containsKey(modifiedWord)) {
	          totalSentiment += sentimentMap.get(modifiedWord);
	        }
	      }
	    }
	    scanner.close();

	    // calculate average sentiment
	    double avgSentiment = (double) totalSentiment / wordCount;

	    // print out results
	    System.out.println("Number of words: " + wordCount);
	    System.out.printf("Total sentiment: %d%n", totalSentiment);
	    System.out.printf("Average sentiment: %.2f%n", avgSentiment);
	  }
	}