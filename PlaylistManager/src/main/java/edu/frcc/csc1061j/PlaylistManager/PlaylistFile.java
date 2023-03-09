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
	 private BufferedReader buffer;    // KNM
	private Scanner read;           // KNM

	public PlaylistFile() throws IOException {
		// check for file and create new if it doesn't exist
		File myFile = new File(FILE);
		if (!myFile.exists()) {
			try {
				myFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("New file created: " + myFile.getName());

		}
		try {
			read = new Scanner(myFile);    // KNM
			// read = new BufferedReader(new FileReader(myFile.getName()));  //KNM
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			print = new PrintWriter(new FileOutputStream(myFile.getName(), false));
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
			// read.close();          // KNM
		} catch (Exception e) {         // KNM
			e.printStackTrace();
		}
		
		return playlist;
	}

	public void writeSong(Song s) {
		print.print(s.getTITLE() + ", ");
		print.print(s.getARTIST());
		print.println();
		print.flush();
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
