package edu.frcc.csc1061j.MyBookTree;

public class BookCreator {
	
	public static void main(String[] args) {
		
		BookTree book = new BookTree("Trees for dummies");
		
		book.addBookNode("Chapter 2", 2, 0, 0);
		book.addBookNode("Chapter 3", 3, 0, 0);
		book.addBookNode("Chapter 4", 4, 0, 0);
		book.addBookNode("Chapter 5", 5, 0, 0);
		book.addBookNode("Chapter 1", 1, 0, 0);
		
		book.addBookNode("Section 1.1", 1, 1, 0);
		book.addBookNode("Section 2.2", 2, 2, 0);
		book.addBookNode("Section 3.3", 3, 3, 0);
		book.addBookNode("Section 4.4", 4, 4, 0);
		book.addBookNode("Section 5.5", 5, 5, 0);

		book.addBookNode("Section 5.3", 5, 3, 0);
		book.addBookNode("Section 4.2", 4, 2, 0);
		book.addBookNode("Section 2.1", 2, 1, 0);
		book.addBookNode("Section 1.4", 1, 4, 0);
		book.addBookNode("Section 3.5", 3, 5, 0);
		
		book.addBookNode("Section 5.3.5", 5, 3, 5);
		book.addBookNode("Section 4.2.4", 4, 2, 4);
		book.addBookNode("Section 2.1.3", 2, 1, 3);
		book.addBookNode("Section 1.4.2", 1, 4, 2);
		book.addBookNode("Section 3.5.1", 3, 5, 1);
		
		
		for (BookNode node: book)
		{
			System.out.println(node);
			
		}
		
		
	}
}
