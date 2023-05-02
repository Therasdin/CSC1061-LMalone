package edu.frcc.csc1061j.MyAVLTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.frcc.csc1061j.MyTreeMap.MyTreeMap.Node;

public class MyAVLTree<K, V> implements Map<K, V>, Iterable<edu.frcc.csc1061j.MyAVLTree.MyAVLTree.Node> {


	private Node root = null;
	private int size = 0;
	private List<Node> path;

	public class Node {
		private K key;
		private V value;
		private int height;
		private Node left = null;
		private Node right = null;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.height = 0;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public int getHeight() {
			return height;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

	}

	private void updateHeight(Node node) {
		if (node.left == null && node.right == null) {
			node.height = 0;
		} else if (node.left == null) {
			node.height = node.right.height + 1;
		} else if (node.right == null) {
			node.height = node.left.height + 1;
		} else {
			node.height = Math.max(node.left.height, node.right.height) + 1;
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
	public Iterator iterator() {

		return new InOrderIterator();
	}

	private class InOrderIterator implements Iterator<Node> {
		private ArrayList<Node> list = new ArrayList<>();
		private int currentIndex = 0;

		public InOrderIterator() {
			InOrder(root);
		}

		private void InOrder(Node node) {
			if (node == null) {
				return;
			}
			InOrder(node.left);
			list.add(node);
			InOrder(node.right);
		}

		@Override
		public boolean hasNext() {
			return currentIndex < list.size();
		}

		@Override
		public MyAVLTree<K, V>.Node next() {
			return list.get(currentIndex++);
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

	private int balanceFactor(MyAVLTree<K, V>.Node current) {
		int balanceFactor = 0;
		int rightHeight = -1;
		int leftHeight = -1;
		if (current.left != null) {
			leftHeight = current.left.height;
		}
		if (current.right != null) {
			rightHeight = current.right.height;
		}
		balanceFactor = rightHeight - leftHeight;
		return balanceFactor;
	}

	private void balanceLL(Node node, Node parent) {
		Node leftNode = node.left;
		if (node == root) {
			root = leftNode;
		} else {
			if (parent.left == node) {
				parent.left = leftNode;
			} else {
				parent.right = leftNode;
			}
		}
		node.left = leftNode.right;
		leftNode.right = node;
		updateHeight(node);
		updateHeight(leftNode);
	}

	private void balanceLR(Node node, Node parent) {
		Node leftNode = node.left;
		Node child = leftNode.right;
		if (node == root) {
			root = child;
		} else {
			if (parent.left == node){
				parent.left = child;
			}	
			else {
				parent.right = child;
			}
		}
		//Handles child's children
		node.left = child.right;
		leftNode.right = child.left;
		
		child.left = leftNode;
		child.right = node;
		
		updateHeight(node);
		updateHeight(leftNode);
		updateHeight(child);
	}


	private void balanceRR(Node node, Node parent) {
		Node rightNode = node.right;
		if (node == root) {
			root = rightNode;
		} else {
			if (parent.right == node) {
				parent.right = rightNode;
			} else {
				parent.left = rightNode;
			}
		}
		node.right = rightNode.left;
		rightNode.left = node;
		updateHeight(node);
		updateHeight(rightNode);
	}

	private void balanceRL(Node node, Node parent) {
		Node rightNode = node.right;
		Node child = rightNode.left;
		if (node == root) {
			root = child;
		} else {
			if (parent.right == node){
				parent.right = child;
			}	
			else {
				parent.left = child;
			}
		}
		//Handles child's children
		node.right = child.left;
		rightNode.left = child.right;
		
		child.right = rightNode;
		child.left = node;
		
		updateHeight(node);
		updateHeight(rightNode);
		updateHeight(child);
	}

	private void balancePath() {
		for (int i = path.size() - 1; i >= 0; i--) {
			Node current = path.get(i);
			updateHeight(current);
			Node parent = null;
			if (i > 0) {
				parent = path.get(i - 1);
			}
			int bFactor = balanceFactor(current);
			switch (bFactor) {
			case -2:
				if (balanceFactor(current.left) <= 0) {
					balanceLL(current, parent);
				} else {
					balanceLR(current, parent);
				}
				break;

			case 2:
				if (balanceFactor(current.right) >= 0) {
					balanceRR(current, parent);
				} else {
					balanceRL(current, parent);
				}
				break;

			}
		}
	}
	@Override
	public V put(K key, V value) {
		if (root == null) {
			Node newNode = new Node(key, value);
			root = newNode;
			size++;
			path = new ArrayList<Node>();
			updateHeight(root);
			return value;
		}
		Node current = root;
		Node parent = null;
		Comparable<K> k = (Comparable<K>) key;

		path.clear();

		while (current != null) {
			path.add(current);
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
		} else {
			parent.left = newNode;
		}
		size++;
		
		updateHeight(newNode);
		balancePath();
		
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

	    if (current == null) { // key not found
	        return null;
	    }

	    if (current.right != null && current.left != null) { // 2 children
	        Node pred = current.left;
	        Node predParent = current;
	        while (pred.right != null) {
	            predParent = pred;
	            pred = pred.right;
	        }
	        current.key = pred.key;
	        current.value = pred.value;
	        current = pred;
	        parent = predParent;
	    }

	    if (current.right != null || current.left != null) { // 1 child
	        Node child = current.right != null ? current.right : current.left;
	        if (parent == null) { // current is root
	            root = child;
	        } else if (parent.left == current) {
	            parent.left = child;
	        } else {
	            parent.right = child;
	        }
	    } else { // 0 children
	        if (parent == null) { // current is root
	            root = null;
	        } else if (parent.left == current) {
	            parent.left = null;
	        } else {
	            parent.right = null;
	        }
	    }
	    
	    return current.value;
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