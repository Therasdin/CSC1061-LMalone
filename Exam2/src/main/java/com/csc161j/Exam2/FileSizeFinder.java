package com.csc161j.Exam2;

import java.io.File;
import java.util.Iterator;

public class FileSizeFinder {

	public static void main(String[] args) {

		String filePath = "D:\\FileSizeTest";
		
		File file = new File(filePath);
		
		if (!file.exists()) {
			System.out.println("The file " + filePath + " does not exist.\nExiting ...");
			System.exit(-1);
		}
		
		FileTree tree = new FileTree(filePath);
		
		System.out.println("File size listing");
		for (FileNode fileNode: tree) {
			if (fileNode.getFile().isDirectory()) {
				long size = 0;
				for (FileNode child : fileNode.getChildNodes()) {
					size += child.getFileSize();
				}
				fileNode.setFileSize(size);
				System.out.println(fileNode);
			}
		}
		
		System.out.println("===============================================================================================");
		System.out.println("Breadth first listing of files");
		Iterator<FileNode> iterator = tree.breadthFirstIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
