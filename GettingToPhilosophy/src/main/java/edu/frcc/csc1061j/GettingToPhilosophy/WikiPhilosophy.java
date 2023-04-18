package edu.frcc.csc1061j.GettingToPhilosophy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class WikiPhilosophy {

    final static List<String> visited = new ArrayList<String>();
    final static WikiFetcher wf = new WikiFetcher();

    /**
     * Tests a conjecture about Wikipedia and Philosophy.
     *
     * https://en.wikipedia.org/wiki/Wikipedia:Getting_to_Philosophy
     *
     * 1. Clicking on the first non-parenthesized, non-italicized link
     * 2. Ignoring external links, links to the current page, or red links
     * 3. Stopping when reaching "Philosophy", a page with no links or a page
     *    that does not exist, or when a loop occurs
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String destination = "https://en.wikipedia.org/wiki/Philosophy";
        String source = "https://en.wikipedia.org/wiki/Walmart";
        String linkFinder = "href";
        int num = 1;

        testConjecture(destination, source, linkFinder, 25, num);
    }

    /**
     * Starts from given URL and follows first link until it finds the destination or exceeds the limit.
     *
     * @param destination
     * @param source
     * @throws IOException
     */
    public static void testConjecture(String destination, String source, String linkFinder, int limit, int num) throws IOException {
        System.out.println(num + " " + source);
    	if (destination.equals(source)) {
        	System.out.println("I Found It!!"); // If it finds it, it returns 
        	return;
        }
    	
    	if (visited.contains(source)) {
    		System.out.println("Duplicate, Infinite loop given"); // prevents infinite loops 
    		return;
    	}
        visited.add(source);
        if (limit == 1) {
        	System.out.println("Limit reached"); // Once limit is reached, return
        	return;
        }
        limit--;
        
    	Document doc = null;
        int pCount = 0;
        String str;
        Connection conn = Jsoup.connect(source);
        wf.fetchWikipedia(source); // ToS
        try
        {
            doc = conn.get();
        }
        catch (Exception e)
        {
            System.out.println("Could not open page. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        }

        // select the content text and pull out the paragraphs.
        Element content = doc.getElementById("mw-content-text");
        Elements paragraphs = content.select("p");

        for (Element para : paragraphs) {
            Iterable<Node> iter = new WikiNodeIterable(para);
            for (Node node : iter) {
            
            
            	if (node instanceof TextNode) {
            		str = node.toString();
            		for (int i = 0; i < str.length(); i++) { // traverses tree and keeps track of parenthesis, if pCount is 1, you are inside a parenthesis 
            			if (str.charAt(i) =='(') {
            				pCount++;
            			}
            			else if (str.charAt(i) ==')') {
            				pCount--;
            			}
            		}
            		//int index = str.indexOf("(");
            		//str.indexOf("(", index + 1);
            	}
            	if (node.hasAttr("href") && pCount == 0) { // checks if it is a link, and not in parenthesis 
            		int start = node.toString().indexOf('"') +1; // gets index of beginning of link
            		int stop = node.toString().indexOf( '"', start);// gets index of end of link
            		str = node.toString().substring(start, stop); // creates the link
            		if (str.charAt(0)== '/') {
            			source = "https://en.wikipedia.org" + str;
            			num++;
            			testConjecture(destination, source, linkFinder, limit, num); // recursion
            			return;
            		}
            	}
                
                // TODO: FILL THIS IN!
            	// If this node is a text node make sure you are not within parentheses
            	//System.out.println(linkFinder);
            	//System.out.println(node.toString().substring(0, node.toString().length()/2));
            	// If this node has a link you can get it by accessing the href attribute in the node
            	
            	// If the link is not null and not an empty string and does not start with a # sign 
            	// and is not within parentheses, follow the link recursively by calling testConjecture() 
            	// until you reach your objective or run past the limit. 
            	
            	//Part 1: Takes a URL for a Wikipedia page, downloads it, and parses it
            	
            	//Part 2: It should traverse the resulting DOM tree to find the first valid link.
            	
            	//Part 3 If the page has no links, or if the first link is a page we have already seen, the program should indicate failure and exit.
            	
            	//Part 4 If the link matches the URL of the Wikipedia page on philosophy, the program should indicate success and exit.
            	
            	
            	
            }

        }
    }
}
