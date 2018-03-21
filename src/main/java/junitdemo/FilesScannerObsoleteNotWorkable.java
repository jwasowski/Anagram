package junitdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class FilesScannerObsoleteNotWorkable {

	public static HashMap<String, ArrayList<String>> file_scan(File file) throws IOException {

		HashMap<String, ArrayList<String>> rawCollection = new HashMap<>();
		FileReader fr = new FileReader(file);
		BufferedReader buffer = new BufferedReader(fr);
		String word = "whatever";

		while (word != null) {
			word = buffer.readLine();
			if (word == null) {
				break;
			}
			rawCollection.put(word, null);

		}
		buffer.close();

		return rawCollection;
	}

	public static int map_anagrams(HashMap<String, ArrayList<String>> collection) {
		long startTime = System.currentTimeMillis();

		int wordCounter = 0;
		int n = 0;
		for (String baseWord : collection.keySet()) {
			ArrayList<String> list = new ArrayList<>();

			for (String comparedToWord : collection.keySet()) {
				n++;

				if (Anagram.check_is_anagram(baseWord, comparedToWord, collection, list)) {
					wordCounter++;
				}

			}
			if (n >= 150000000) {
				System.out.print(n + "\n");
				break;
			}
		}

		long endTime = System.currentTimeMillis();

		System.out.println("The highest Quantity of Anagrams PRESORT: " + collection.values());
		System.out.println("That took " + (endTime - startTime) / 1000 + " seconds");
		return wordCounter;
	}

	@SuppressWarnings("unused")
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

	@SuppressWarnings("unused")
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
