package com.csc161j.Exam2;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

public class FileTree implements Iterable<FileNode> {

    private FileNode root;

    public FileTree(String path) {
        root = new FileNode(path);
        buildTree(root);
    }

    /**
     * Return a depth first post-order traversal iterator
     */
    @Override
    public Iterator<FileNode> iterator() {

        return new DepthFirstIterator(root);
    }

    /**
     * Use recursion to build the tree from the directory structure.
     * For each of node starting from the root node use listFiles() from File to get
     * the list of files in that directory/folder.
     * Create a node for each of the files and add it to a list of child nodes for the node
     * Do this recursively for all the nodes.
     *
     * @param fileNode
     */
    private void buildTree(FileNode fileNode) {
        File[] files = fileNode.getFile().listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            FileNode childNode = new FileNode(file);
            fileNode.getChildNodes().add(childNode);
            buildTree(childNode);
        }
    }

    /**
     * Iterator that does a post order traversal of the tree.
     * For post-order traversal use the 2 stack approach outlined here:
     * https://www.geeksforgeeks.org/iterative-postorder-traversal/
     *
     * @return
     */
    private class DepthFirstIterator implements Iterator<FileNode> {

        Deque<FileNode> stack1 = new ArrayDeque<>();
        Deque<FileNode> stack2 = new ArrayDeque<>();

        public DepthFirstIterator(FileNode node) {
            stack1.push(node);
            while (!stack1.isEmpty()) {
                FileNode tempNode = stack1.pop();
                stack2.push(tempNode);
                for (FileNode childNode : tempNode.getChildNodes()) {
                    stack1.push(childNode);
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !stack2.isEmpty();
        }

        @Override
        public FileNode next() {
            return stack2.pop();
        }
    }

    /**
     * Returns an iterator that does a breadth first traversal of the tree using a queue.
     *
     * @return
     */
    public Iterator<FileNode> breadthFirstIterator() {
        return new BreadthFirstIterator(root);
    }

    /**
     * Iterator that does a breadth first traversal of the tree using a queue.
     */
    private class BreadthFirstIterator implements Iterator<FileNode> {

        Queue<FileNode> queue = new ArrayDeque<>();

        public BreadthFirstIterator(FileNode node) {
            queue.offer(node);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public FileNode next() {
            FileNode node = queue.poll();
            for (FileNode childNode : node.getChildNodes()) {
                queue.offer(childNode);
            }
            return node;
        }
    }
}