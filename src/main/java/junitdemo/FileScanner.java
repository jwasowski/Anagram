package junitdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class FileScanner {
	public static int file_scan(File file) throws IOException {
		long startTime = System.currentTimeMillis();
		int wordCounter = 0;
		HashMap<String, ArrayList<String>> anagramCollection = new HashMap<>();

		try {

			FileReader fr = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fr);
			FileReader fr2 = new FileReader(file);
			BufferedReader buffer2 = new BufferedReader(fr2);
			String entryWord = "whatever";
			/*
			 * for(int i=0;i<338000;i++){ test = buffer.readLine();} Petla do startowania z wybranego miejsca w slowniku
			 */

			long n = 0;

			while (entryWord != null) {

				entryWord = buffer.readLine();
				String baseWord = entryWord;
				String comparedWord = buffer2.readLine();
				comparedWord = buffer2.readLine();
				ArrayList<String> list = new ArrayList<>();
				if (comparedWord == null) {
					fr2 = new FileReader(file);
					buffer2 = new BufferedReader(fr2);
					comparedWord = buffer2.readLine();
					
				}
				if (entryWord == null) {
					break;
				}
				

				while (comparedWord != null) {
					n++;
					if (Anagram.check_is_anagram(baseWord, comparedWord, anagramCollection, list)) {
						wordCounter++;
						
					}
					comparedWord = buffer2.readLine();

				}

				if (n >= 1600000000) {	//Warunek do kontrolowania ile slow ma porownac ( n/slowni~=ilosc slow )
					//System.out.print(n + "\n"); // Zakomentowac aby sprawdzil caly slownik
					break;
				}

			}
			buffer.close();
			buffer2.close();
		}

		catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Searching anagrams took " + (endTime - startTime) / 1000 + " seconds");
		

		Entry<String, ArrayList<String>> maxEntryKey = longest_anagram(anagramCollection);

		Entry<String, ArrayList<String>> maxEntryValue = most_anagram(anagramCollection);
		System.out.println("Longest anagram: " + maxEntryKey);
		System.out.println("Most anagrams: " + maxEntryValue);

		return wordCounter;
	}
	//Ponizej metoda do szukania najwiekszej liczby anagramow
	private static Entry<String, ArrayList<String>> most_anagram(HashMap<String, ArrayList<String>> anagramCollection) {
		Entry<String, ArrayList<String>> maxEntryValue = null;

		for (Entry<String, ArrayList<String>> entryValue : anagramCollection.entrySet()) {
			if (maxEntryValue == null
					|| Anagram.check_is_most_anagram(entryValue.getValue().size(), maxEntryValue.getValue().size())) {

				maxEntryValue = entryValue;
			}
		}
		return maxEntryValue;
	}
	//Ponizej metoda do szukania slowa majacego anagram i bedacego najdluzszym
	private static Entry<String, ArrayList<String>> longest_anagram(
			HashMap<String, ArrayList<String>> anagramCollection) {
		Entry<String, ArrayList<String>> maxEntryKey = null;

		for (Entry<String, ArrayList<String>> entryKey : anagramCollection.entrySet()) {
			if (maxEntryKey == null || Anagram.check_is_longest(entryKey.getKey(), maxEntryKey.getKey())) {
				if (Anagram.check_is_anagram_present(entryKey))
					maxEntryKey = entryKey;
			}
		}
		return maxEntryKey;
	}
}