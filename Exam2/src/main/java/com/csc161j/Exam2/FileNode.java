package com.csc161j.Exam2;

import java.io.File;
import java.util.ArrayList;

public class FileNode {
	private String absolutePath = null;
	private File file = null;
	private long fileSize = 0;
	private ArrayList<FileNode> childNodes = new ArrayList<FileNode>();
	
	public FileNode(String absolutePath) {
		super();
		this.absolutePath = absolutePath;
		file = new File(absolutePath);
		fileSize = 0;
		if (!file.isDirectory()) {
			fileSize = file.length();
		}
	}

	public FileNode(File file) {
		super();
		this.absolutePath = file.getAbsolutePath();
		this.file = file;
		fileSize = 0;
		if (!file.isDirectory()) {
			fileSize = file.length();
		}
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public ArrayList<FileNode> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(ArrayList<FileNode> childNodes) {
		this.childNodes = childNodes;
	}
	@Override
	public String toString() {
		return String.format("%-80s %d\n", absolutePath, fileSize);
	}

}
