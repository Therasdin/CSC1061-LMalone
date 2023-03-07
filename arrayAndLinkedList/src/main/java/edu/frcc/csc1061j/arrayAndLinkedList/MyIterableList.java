package edu.frcc.csc1061j.arrayAndLinkedList;

import java.util.Iterator;

public class MyIterableList implements Iterable<Integer>{
	private int[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	@Override
	public Iterator<Integer> iterator() {
		return new myIterator();
	}
	
	private class myIterator implements Iterator<Integer>{
		
		private int index = 0;
		
		@Override
		public boolean hasNext() {
			if (index < intArray.length)
			{
				return true;
			}
			return false;
		}

		@Override
		public Integer next() {
			int elem = intArray[index];
			index++;
			return elem;
		}
		
	}
}
