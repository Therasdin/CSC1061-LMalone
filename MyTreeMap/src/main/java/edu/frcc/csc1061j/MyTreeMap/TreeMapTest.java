package edu.frcc.csc1061j.MyTreeMap;

public class TreeMapTest {
	  public static void main(String[] args) {
		  MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
		  map.put(8, 8);
		  map.put(7, 7);
		  map.put(12, 12);
		  map.put(14, 14);
		  map.put(6, 6);
		  map.put(8, 8);
		  map.put(1, 1);
		  map.put(20, 20);
		  
		  print(map);
		  
		  int removedKey = map.remove(6);
				  
		  System.out.println(removedKey);
		  
		  print(map);
		  
	  }
	  private static void print(MyTreeMap<Integer, Integer> map) {
		  for (Integer val: map) {
			  System.out.println(val + " ");
		  }
	  }
}
