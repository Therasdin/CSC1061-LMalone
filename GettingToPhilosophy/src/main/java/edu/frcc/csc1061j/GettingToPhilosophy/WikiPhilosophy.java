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
        String source = "https://en.wikipedia.org/wiki/Java_(programming_language)";
        String linkFinder = "Href=\"";

        testConjecture(destination, source, linkFinder, 10);
    }

    /**
     * Starts from given URL and follows first link until it finds the destination or exceeds the limit.
     *
     * @param destination
     * @param source
     * @throws IOException
     */
    public static void testConjecture(String destination, String source, String linkFinder, int limit) throws IOException {
        Document doc = null;
        Connection conn = Jsoup.connect(source);
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
            		String str = node.toString();
            		int index = str.indexOf("(");
            		str.indexOf("(", index + 1);
            	}
                
                // TODO: FILL THIS IN!
            	// If this node is a text node make sure you are not within parentheses
            	System.out.println(linkFinder);
            	System.out.println(node.toString().substring(0, node.toString().length()/2));
            	// If this node has a link you can get it by accessing the href attribute in the node
            	
            	// If the link is not null and not an empty string and does not start with a # sign 
            	// and is not within parentheses, follow the link recursively by calling testConjecture() 
            	// until you reach your objective or run past the limit. 
            	
            	//Part 1: Takes a URL for a Wikipedia page, downloads it, and parses it
            	Elements text = wf.fetchWikipedia(source);
            	//Part 2: It should traverse the resulting DOM tree to find the first valid link. I’ll explain what “valid” means below.
            	
            	//Part 3 If the page has no links, or if the first link is a page we have already seen, the program should indicate failure and exit.
            	
            	//Part 4 If the link matches the URL of the Wikipedia page on philosophy, the program should indicate success and exit.
            	
            	
            	
            }

        }
    }
}
