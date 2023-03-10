package edu.frcc.csc1061j.MyHashMap;

import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Map map = new MyHashMap<String, Integer>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put("Four", 4);
		
		if (map.containsKey("Two")) {
			System.out.println("Has 2");
		}
		System.out.println("Value of Three : " + map.get("Three"));
	}

}
