package edu.frcc.csc1061j.PlaylistManager;

import java.util.List;
import java.util.Scanner;

import edu.frcc.csc1061j.arrayAndLinkedList.MyLinkedList;

public class PlaylistManagerDriver {

	static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		MyDoubleLinkedList<Song> playlist = new MyDoubleLinkedList<Song>();

	}

	public static void add(MyDoubleLinkedList<Song> playlist) {
		String name;
		String artist;
		System.out.println("Add a song, Enter the song name");
		name = input.next();
		System.out.println("Enter the Song's artist name");
		artist = input.next();
		playlist.add(new Song(name, artist));
	}

	public static boolean remove(MyDoubleLinkedList<Song> playlist) {
		String name;
		String artist;
		System.out.println("Remove a song, Enter the song name");
		name = input.next();
		System.out.println("Enter the Song's artist name");
		artist = input.next();
		for (int i = 0; i < playlist.size() - 1; i++) {
			if (name.equals(playlist.get(i).getTITLE()) && (artist.equals(playlist.get(i).getARTIST()))) {
				playlist.remove(i);
				return true;
			}

		}
		System.out.println("No Matches");
		return false;
	}

}
