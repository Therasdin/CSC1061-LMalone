package edu.frcc.csc1061j.PlaylistManager;

import java.util.List;

public class Song {

	private String title;
	private String artist;
	
	public Song()
	{
		title = "Song title";
		artist = "Song artist";
	}
	public Song(String title, String artist)
	{
		this.title = title;
		this.artist = artist;	
	}
	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
	}
	public String getartist() {
		return artist;
	}
	public void setartist(String artist) {
		this.artist = artist;
	}
	@Override
	public String toString() {
		return "Song [title=" + title + ", artist=" + artist + "]";
	}

	
}
