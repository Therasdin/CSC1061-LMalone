package edu.frcc.csc1061j.PlaylistManager;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import edu.frcc.csc1061j.arrayAndLinkedList.MyLinkedList;

public class PlaylistManagerDriver {

	static Scanner input;

	public static void main(String[] args) throws IOException {
		input = new Scanner(System.in);
		int userIn = 0;
		int numSong;
		PlaylistFile writer = new PlaylistFile();
		
		MyDoubleLinkedList<Song> playlist = new MyDoubleLinkedList<Song>();
		do {
			printText();
			userIn = input.nextInt();
			System.out.println("");
			System.out.println("");
			System.out.println("");

			while (userIn < 1 || userIn > 9) {
				System.out.println("Invalid input");
				userIn = input.nextInt();
			}
			if (userIn == 1) {
				add(playlist);
			} else if (userIn == 2) {
				remove(playlist);
			} else if (userIn == 3) {
				numSong = print(playlist);
				System.out.println("There are " + numSong + " song(s) in the playlist.");
				System.out.println("");
			}

			else if (userIn == 4) {
				play(playlist);
			} else if (userIn == 5) {
				shuffle(playlist);
			} else if (userIn == 6) {
				reverse(playlist);
			} else if (userIn == 7) {
				playlist = writer.readSong(playlist);
			} else if (userIn == 8) {
				
			}
			System.out.println("");
			System.out.println("");
			System.out.println("");
		} while (userIn != 9);
		System.out.println(writer.getFILE());
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

	public static int print(MyDoubleLinkedList<Song> playlist) {
		int val;
		val = playlist.size();
		return val;
	}

	public static void play(MyDoubleLinkedList<Song> playlist) {
		for (Song Song : playlist) {
			System.out.println(Song);
		}
		System.out.println("");
	}

	public static void shuffle(MyDoubleLinkedList<Song> playlist) {
		Random rand = new Random();
		int index;
		Song hold;
		for (int i = 0; i <= playlist.size() - 1; i++) {
			index = rand.nextInt(playlist.size() - 1);
			hold = playlist.get(i);
			playlist.set(i, playlist.get(index));
			playlist.set(index, hold);
		}

	}

	public static <Song> void reverse(MyDoubleLinkedList<Song> playlist) {
		Song value;
		if (playlist.size() <= 1 || playlist == null) {
			return; // returns once all elements are isolated
		}
		value = playlist.remove(0);
		reverse(playlist);
		playlist.add(value);
	}

	public static void save(MyDoubleLinkedList<Song> playlist) {
		
		for (int i = 0; i < playlist.size() - 1; i++) {
			
		}
	}

	public static void load(MyDoubleLinkedList<Song> playlist) {

	}

	public static void printText() {
		System.out.println("Choose a number (1-9)");
		System.out.println("1. Add Song");
		System.out.println("2. Remove Song");
		System.out.println("3. Print");
		System.out.println("4. Play Playlist");
		System.out.println("5. Shuffle Playlist");
		System.out.println("6. Reverse Playlist");
		System.out.println("7. Save Plalist");
		System.out.println("8. Load Playlist");
		System.out.println("9. Quit");

	}
}
