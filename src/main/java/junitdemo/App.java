package junitdemo;

import java.io.File;
import java.io.IOException;

public class App {
	public static void main(String[] args) throws IOException {

		int wordCounter = 0;
		String path = "src/resc/resource/AnagramList.txt";
		File file = new File(path);
		wordCounter = FileScanner.file_scan(file);
		System.out.println("Number of Anagrams: " + wordCounter);

	}
}