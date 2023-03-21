package edu.frcc.csc1061j.PlaylistManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.Scanner;

public class PlaylistFile {
	Scanner input = new Scanner(System.in);
	private final String FILE = "Playlist.txt";
	private PrintWriter print;
	private BufferedReader buffer;
	private Scanner read;

	public PlaylistFile() throws IOException {
		File file = new File(FILE);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("New file created: " + file.getName());

		}
		try {
			read = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			print = new PrintWriter(new FileOutputStream(file.getName(), true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public MyDoubleLinkedList<Song> readSong(MyDoubleLinkedList<Song> playlist) {
		String artist;
		String title;
		try {
			buffer = new BufferedReader(new FileReader(FILE));
			while (read.hasNextLine()) {
				String lines = read.nextLine();
				String[] readScan = lines.split(", ");
				while ((lines = buffer.readLine()) != null) {
					System.out.println(lines);
				}
				try {
					title = readScan[0];
					artist = readScan[1];
					playlist.add(new Song(artist, title));
				} catch (ArrayIndexOutOfBoundsException e) {

				}

			}
			// read.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return playlist;
	}

	public void writeSong(MyDoubleLinkedList<Song> playlist) {
		for (Song s : playlist) {
			print.print(s.gettitle() + ", ");
			print.print(s.getartist());
			print.println();
			print.flush();
		}

	}

	public PrintWriter getPrint() {
		return print;
	}

	public void setPrint(PrintWriter print) {
		this.print = print;
	}

	public Scanner getRead() {
		return read;
	}

	public void setRead(Scanner read) {
		this.read = read;
	}

	public String getFILE() {
		return FILE;
	}

}
