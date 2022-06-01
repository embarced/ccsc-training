package ccsc.solid.srp.filecrawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author mhilleke
 * 
 * 		   1. Erstellt ein Projekt FileCrawler1 mit einer gleichnamigen
 *         Main-Klasse
 * 
 *         2. Implementiert eine rekursive Dateisuche ab "." und gebt die
 *         Ergebnisse auf der Konsole aus
 * 
 *         Vorgabe: Die Klasse File benutzen
 */

public class FileCrawlerTooBig {

	static File folder = new File(".");
	static List<File> foundFiles = new ArrayList<>();
	static double[] fileSizeBorders = new double[2];
	static boolean keepGoing = true;

	public static void main(String[] args) throws IOException {
		FileCrawlerTooBig crawler = new FileCrawlerTooBig();

		while (keepGoing) {
			crawler.askForAction();
		}
	}

	int countWords(String word, File file) throws IOException {
		FileInputStream input = new FileInputStream(file);
		Scanner scanner = new Scanner(input);
		int wordCounter = 0;
		while (scanner.hasNext()) {
			if (scanner.next().equals(word)) {
				wordCounter++;
			}
		}
		scanner.close();
		return wordCounter;
	}

	void filterSize(File folder) throws IOException {
		double[] sizeRange = getFileSizeBorders();
		searchFolder(folder, sizeRange);
		boolean results = false;
		results = showResults();
		if (results == false) {
			System.out.println("Suchparameter liefern keine Suchergebnisse");
		} else {
			askForWordSearch();
		}
	}

	void filter(File folder) throws IOException {
		String fileType = getFileType();
		searchFolder(folder, fileType);
		boolean results = false;
		showResults();
		results = showResults();
		if (results == false) {
			System.out.println("Suchparameter liefern keine Suchergebnisse");
		} else {
			askForWordSearch();
		}
	}

	void filterCombined(File folder) throws IOException {
		String fileType = getFileType();
		double[] sizeRange = getFileSizeBorders();
		searchFolder(folder, sizeRange, fileType);
		boolean results = false;
		showResults();
		results = showResults();
		if (results == false) {
			System.out.println("Suchparameter liefern keine Suchergebnisse");
		} else {
			askForWordSearch();
		}
	}

	void search(File folder) throws IOException {
		File search = new File(getSearchedFile());
		searchFolder(folder, search.getName());
		boolean results = false;
		showResults();
		results = showResults();
		if (results == false) {
			System.out.println("Suchparameter liefern keine Suchergebnisse");
		} else {
			askForWordSearch();
		}
	}

	void searchFolder(File folder, String search) {
		File[] files = folder.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				searchFolder(new File(f.getAbsolutePath()), search);
			} else if (f.getName().endsWith(search)) {
				foundFiles.add(f);
			}
		}
	}

	// Overload for fileSizeFiltering
	void searchFolder(File folder, double[] sizeRange) {
		File[] files = folder.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				searchFolder(new File(f.getAbsolutePath()), sizeRange);
			} else if (f.length() < sizeRange[0] && f.length() > sizeRange[1]) {
				foundFiles.add(f);
			}
		}
	}

	// Overload for combined Filter
	void searchFolder(File folder, double[] sizeRange, String search) {
		File[] files = folder.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				searchFolder(new File(f.getAbsolutePath()), sizeRange);
			} else if (f.length() < sizeRange[0] && f.length() > sizeRange[1] && f.getName().contains(search)) {
				foundFiles.add(f);
			}
		}
	}

	boolean showResults() {
		
		boolean filesFound = false;
		
		if (foundFiles.size() > 0) {
			foundFiles.forEach(file -> System.out.println(file.getName() + " in "
					+ file.getAbsolutePath() + " mit " + file.length() + "Byte"));
			filesFound = true;
		}
		return filesFound;
	}

	String getSearchedFile() throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Dateinamen f�r Suche eingeben: ");
		String searchedFile = reader.readLine();
		return searchedFile;
	}

	String getFileType() throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Dateiendung eingeben: ");
		String fileType = reader.readLine();
		
		
		
		return fileType;
	}
	void searchFilesForWord(List<File> foundFiles) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Suchwort eingeben: ");
		String searchWord = reader.readLine();
		
		int fileCounter = 0;
		FileInputStream input = null;
		Scanner scanner = null;
		for (File f : foundFiles) {
			input = new FileInputStream(f);
			scanner = new Scanner(input);
			int wordCounter = 0;
			while (scanner.hasNext()) {
				if (scanner.next().equals(searchWord)) {
					wordCounter++;
				}
			}

			if (wordCounter > 0) {
				System.out.println(f.getName() + " enth�lt das Suchwort " + searchWord + " " + wordCounter + " mal.");
				fileCounter++;
			}
		}
		
		if (fileCounter == 0) {
			System.out.println("Das Wort kommt in den Dateien nicht vor");
		}
	}

	double[] getFileSizeBorders() throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Obere Grenze f�r Dateigr��e [Byte]: ");
		try {
			fileSizeBorders[0] = Double.parseDouble(reader.readLine());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("NUMBERS!!! DUMBASS");
			getFileSizeBorders();
		}
		
		System.out.println("Untere Grenze f�r Dateigr��e [Byte]: ");
		try {
			fileSizeBorders[1] = Double.parseDouble(reader.readLine());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("NUMBERS!!! DUMBASS");
			getFileSizeBorders();
		}

		return fileSizeBorders;
	}

	void askForAction() throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(
				"Optionen\n[1] nach Dateiendung filtern\n[2] nach Dateigr��e filtern\n[3] nach Dateigr��e und Dateityp filtern\n[4] Suchen\n[5] Abbruch");
		String action = reader.readLine();
		switch (action) {
		case "1":
			filter(folder);
			break;
		case "2":
			filterSize(folder);
			break;
		case "3":
			filterCombined(folder);
			break;
		case "4":
			search(folder);
			break;
		case "5":
			System.out.println("Bye, bye");
			keepGoing = false;
			break;
		default:
			System.out.println("Das war eine merkw�ridge Eingabe, gib 1, 2, 3, 4 oder 5 ein und dr�cke Enter");
			askForAction();
		}
	}

	void askForWordSearch() throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("---------------\nWortsuche in gefundenen Dateien? Y/N");
		String answer = reader.readLine();
		switch (answer) {
		case "Y":
			searchFilesForWord(foundFiles);
			break;
		case "y":
			searchFilesForWord(foundFiles);
			break;
		case "N":
			break;
		case "n":
			break;
		default:
			System.out.println("Das war eine merkw�ridge Eingabe, fangen wir nochmal von vorne an...");
			askForWordSearch();
		}
	}
}
