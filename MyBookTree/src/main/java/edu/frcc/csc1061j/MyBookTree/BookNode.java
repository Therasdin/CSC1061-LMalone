package edu.frcc.csc1061j.MyBookTree;

import java.util.ArrayList;
import java.util.List;

public class BookNode {

	private String title;
	private int chapterNum;
	private int sectionNum;
	private int subSectionNum;
	private List<BookNode> childNodes;
	
	public BookNode(String title, int chapterNum, int sectionNum, int subSectionNum) {
		this.title = title;
		chapterNum = chapterNum;
		sectionNum = sectionNum;
		subSectionNum = subSectionNum;
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
			return ("\t\t" + sectionNum + " " + chapterNum + " " + title);
		}
		return ("\t\t\t" + subSectionNum + " " + sectionNum + " " + chapterNum + " " + title);
	}
	
}