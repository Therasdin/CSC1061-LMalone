package edu.frcc.csc1061j.arrayAndLinkedList;

public class Driver {
	public static void main(String[] args) {
		MyIterableList myList = new MyIterableList();
		for (int num : myList) {
			System.out.println(num);
		}
		
	}
}
