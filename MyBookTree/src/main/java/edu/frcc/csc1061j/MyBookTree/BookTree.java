package edu.frcc.csc1061j.MyBookTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BookTree implements Iterable<BookNode>{

	private BookNode root;

	public BookTree(String title) {
		root = new BookNode(title, 0, 0, 0);
	}

	public BookNode getBook() {
		return root;

	}

	public boolean addBookNode(String title, int chapNum, int secNum, int subSecNum) {
		BookNode node = new BookNode(title, chapNum, secNum, subSecNum);

		if (secNum == 0) {
			root.getChildNodes().add(node);// same as below
			Collections.sort(root.getChildNodes());
			return true;
//			List<BookNode> list = root.getChildNodes();
//			list.add(node);
		}

		if (subSecNum == 0) {
			for (BookNode aNode : root.getChildNodes()) {
				if (chapNum == aNode.getChapterNum()) {
					aNode.getChildNodes().add(node);
					Collections.sort(aNode.getChildNodes());
					return true;
				}
			}
				return false;
			}
			BookNode chapterNode = null;
			for (BookNode cNode : root.getChildNodes()) {
				if (chapNum == cNode.getChapterNum()) {
					chapterNode = cNode;
				}
			}
			if (chapterNode == null) {
				return false;
			}
			for (BookNode sNode : chapterNode.getChildNodes()) {
				if (secNum == sNode.getSectionNum()) {
					sNode.getChildNodes().add(node);
					Collections.sort(sNode.getChildNodes());
					return true;
				}
			}
		return false;
	}

	@Override
	public Iterator<BookNode> iterator() {//preorder traversal
		return new BookNodeIterator(root);
	}
	
	private class BookNodeIterator implements Iterator<BookNode> {
		Deque<BookNode> stack;
		
		public BookNodeIterator (BookNode node) {
			stack = new ArrayDeque<BookNode>();
			stack.push(node);
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public BookNode next() {
			BookNode node = stack.pop();
			List<BookNode> nodes = new ArrayList<>(node.getChildNodes());
			Collections.reverse(nodes);
			
			for (BookNode child : nodes) {
				stack.push(child);
			}
			return node;
		}
	}
	
}