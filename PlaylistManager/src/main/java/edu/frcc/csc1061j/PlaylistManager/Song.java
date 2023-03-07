package edu.frcc.csc1061j.PlaylistManager;

import java.util.List;

public class Song {

	private String TITLE;
	private String ARTIST;
	
	public Song()
	{
		TITLE = "Song TITLE";
		ARTIST = "Song ARTIST";
	}
	public Song(String TITLE, String ARTIST)
	{
		this.TITLE = TITLE;
		this.ARTIST = ARTIST;	
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String TITLE) {
		this.TITLE = TITLE;
	}
	public String getARTIST() {
		return ARTIST;
	}
	public void setARTIST(String ARTIST) {
		this.ARTIST = ARTIST;
	}
	@Override
	public String toString() {
		return "Song [TITLE=" + TITLE + ", ARTIST=" + ARTIST + "]";
	}
	
}
