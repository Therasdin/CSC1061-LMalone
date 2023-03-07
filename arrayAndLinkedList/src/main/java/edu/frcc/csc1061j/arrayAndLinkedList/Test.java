package edu.frcc.csc1061j.arrayAndLinkedList;

import java.util.Arrays;
import java.util.List;

import org.w3c.dom.html.HTMLLabelElement;

public class Test {

	public static void main(String[] args) {
		List<Integer> ml = new MyLinkedList<Integer>();
		ml.add(1);
		ml.add(2);
		ml.add(3);
		ml.add(4);
		ml.add(5);
		ml.add(6);
		
		System.out.println(Arrays.toString(ml.toArray()) + "Size = " + ml.size());
		
		ml.remove(3);
		
		System.out.println(Arrays.toString(ml.toArray()) + "Size = " + ml.size());
		
		ml.remove(1);
		
		System.out.println(Arrays.toString(ml.toArray()) + "Size = " + ml.size());
	}
}
