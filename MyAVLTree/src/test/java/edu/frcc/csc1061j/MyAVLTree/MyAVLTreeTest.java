package edu.frcc.csc1061j.MyAVLTree;

import edu.frcc.csc1061j.MyAVLTree.MyAVLTree;
import edu.frcc.csc1061j.MyAVLTree.MyAVLTree.Node;

public class MyAVLTreeTest {

	public static void main(String[] args) {
		MyAVLTree<Integer, Integer> map = new MyAVLTree<>();
		
		map.put(25, 25);
		printInOrder(map);
		
		map.put(20, 20);
		printInOrder(map);
		
		map.put(5, 5);		// Needs LL rotation at node 25
		printInOrder(map);
		
		System.out.println("After LL rotation at node 25");
		printBalanceFactor(map);
		
		map.put(34, 34);
		printInOrder(map);
		
		map.put(50, 50);     // Needs RR rotation at node 25 
		printInOrder(map);
		
		System.out.println("After RR rotation at node 25");
		printBalanceFactor(map);
		
		map.put(30, 30);	// Needs RL rotation at node 20
		printInOrder(map);
		
		System.out.println("After RL rotation at node 25");
		printBalanceFactor(map);
		
		map.put(10, 10);     // Needs LR rotation at node 20.
		printInOrder(map);

		System.out.println("After LR rotation at node 25");
		printBalanceFactor(map);
	}

	private static void printInOrder(MyAVLTree<Integer, Integer> map) {
		for(Node node: map) {
			System.out.print(node.getKey().toString() + " ");
		}
		System.out.println();
	}
	
	private static void printBalanceFactor(MyAVLTree<Integer, Integer> map) {
		int minHeight = 1;
		for(Node node: map) {
			if (node.getHeight() == 0) {
				minHeight = 0;
				break;
			}
		}
		
		System.out.println("\nNode\tHeight\tBalance Factor\tLeftChild\tRightChild");
		for(Node node: map) {
			if (minHeight == 1) {
				System.out.println(node.getKey().toString() + "\t" + node.getHeight() + "\t"
					+ ((node.getRight() != null ? node.getRight().getHeight() : 0) 
							- (node.getLeft() != null ? node.getLeft().getHeight() : 0)) 
								+ "\t\t" + (node.getLeft() != null ? node.getLeft().getKey().toString() : "null") 
										+ "\t\t" + (node.getRight() != null ? node.getRight().getKey().toString() : "null"));
			}
			else {
				System.out.println(node.getKey().toString() + "\t" + node.getHeight() + "\t"
						+ ((node.getRight() != null ? node.getRight().getHeight() + 1 : 0) 
								- (node.getLeft() != null ? node.getLeft().getHeight() + 1 : 0))
								+ "\t\t" + (node.getLeft() != null ? node.getLeft().getKey().toString() : "null") 
								+ "\t\t" + (node.getRight() != null ? node.getRight().getKey().toString() : "null"));
			}
		}
		System.out.println();
	}
}
