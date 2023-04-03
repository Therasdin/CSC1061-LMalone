package edu.frcc.csc1061j.MyBookTree;

import java.util.ArrayList;
import java.util.List;

public class BookNode implements Comparable<BookNode>{

	private String title;
	private int chapterNum;
	private int sectionNum;
	private int subSectionNum;
	private List<BookNode> childNodes;
	
	public BookNode(String title, int chapterNum, int sectionNum, int subSectionNum) {
		this.title = title;
		this.chapterNum = chapterNum;
		this.sectionNum = sectionNum;
		this.subSectionNum = subSectionNum;
		childNodes = new ArrayList<BookNode>();
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getChapterNum() {
		return chapterNum;
	}

	public void setChapterNum(int chapterNum) {
		this.chapterNum = chapterNum;
	}

	public int getSectionNum() {
		return sectionNum;
	}

	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}

	public int getSubSectionNum() {
		return subSectionNum;
	}

	public void setSubSectionNum(int subSectionNum) {
		this.subSectionNum = subSectionNum;
	}

	public List<BookNode> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(List<BookNode> childNodes) {
		this.childNodes = childNodes;
	}

	@Override
	public String toString() {
		if (chapterNum == 0) {
			return title;
		}
		if (sectionNum == 0) {
			return ("\t" + chapterNum + " " + title);
		}
		if (subSectionNum == 0) {
			return ("\t\t" + chapterNum + " " + sectionNum + " " + title);
		}
		return ("\t\t\t" + chapterNum + " " + sectionNum + " " + subSectionNum + " " + title);
	}

	@Override
	public int compareTo(BookNode o) {
		if (chapterNum > o.chapterNum) {
			return 1;
		}
		else if (chapterNum < o.chapterNum) {
			return -1;
		}
		if (sectionNum > o.sectionNum) {
			return 1;
		}
		else if (sectionNum < o.sectionNum) {
			return -1;
		}
		if (subSectionNum > o.subSectionNum) {
			return 1;
		}
		else if (subSectionNum < o.subSectionNum) {
			return -1;
		}
		return 0;
	}
}