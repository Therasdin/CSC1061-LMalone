package edu.frcc.csc1061j.MyTreeMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyTreeMap<K,V> implements Map<K,V>,Iterable <V> {
	
	private Node root = null;
	private int size = 0;
	
	private class Node {
		private K key;
		private V value;
		private Node left = null;
		private Node right = null;
		
		public Node (K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public Iterator<V> iterator() {
		
		return new InOrderIterator();
	}
	private class InOrderIterator implements Iterator<V>{
		private ArrayList<V> list = new ArrayList<>();
		private int currentIndex = 0;
		
		public InOrderIterator() {
			InOrder(root);
		}
		private void InOrder(Node node) {
			if (node == null) {
				return;
			}
			InOrder(node.left);
			list.add(node.value);
			InOrder(node.right);
		}
		
		@Override
		public boolean hasNext() {
			return currentIndex < list.size();
		}

		@Override
		public V next() {
			V value = list.get(currentIndex);
			currentIndex++;
			return value;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		Comparable<K> k = (Comparable<K>) key;
		Node current = root;
		
		while (current != null) {
			if (k.compareTo(current.key) < 0) {
				current = current.left;
			} else if (k.compareTo(current.key) > 0) { 
				current = current.right;
			} else {
				return current.value;
			}
		}
		
		return null;
	}

	@Override
	public V put(K key, V value) {
		if (root == null) {
			Node newNode = new Node(key, value);
			root = newNode;
			size++;
			return value;
		}
		Node current = root;
		Node parent = null;
		Comparable<K> k = (Comparable<K>) key;
		
		while (current != null) {
			if (k.compareTo(current.key) < 0) {
				parent = current;
				current = current.left;
			} else if (k.compareTo(current.key) > 0) { 
				parent = current;
				current = current.right;
			} else {
				return null;
			}
		}
		Node newNode = new Node(key, value);
		if (k.compareTo(parent.key) > 0) {
			parent.right = newNode;
		}
		else {
			parent.left = newNode;
		}
		size++;
		return value;
	}

	@Override
	public V remove(Object key) {
		Node current = root;
		Node parent = null;
		Comparable<K> k = (Comparable<K>) key;
		
		while (current != null) {
			if (k.compareTo(current.key) < 0) {
				parent = current;
				current = current.left;
			} else if (k.compareTo(current.key) > 0) { 
				parent = current;
				current = current.right;
				} else { 
					break;
				}
			}
			if (current.right == null && current.left == null) {
				
			}
			
			// need to see which one to remove, then go to parent and cut off
			// If it has no children, just replace left and right pointers, if it has Children just replace key and value of the next lowest value.
			return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
}
