package junitdemo;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Test;

public class AnagramTest {

	@Test
	public void test_Routines_in_Anagram_Class() throws IOException {
		String baseWord = "cAa2a";				//Konfigurowanie zmiennych do testow
		String comparedWord = "c2aAa";
		String path = "src/resc/resource/TestCase.txt";
		File file = new File(path);
		HashMap<String, ArrayList<String>> testHashMap = new HashMap<>();
		ArrayList<String> listTest = new ArrayList<>();
		int f=5;
		int g=5;
		listTest.add(comparedWord);
		testHashMap.put(baseWord, listTest);
		Entry<String, ArrayList<String>> maxEntryKey = null;

		for (Entry<String, ArrayList<String>> entryKey : testHashMap.entrySet()) {
			if (maxEntryKey == null || Anagram.check_is_longest(entryKey.getKey(), maxEntryKey.getKey())) {
				if (Anagram.check_is_anagram_present(entryKey))
					maxEntryKey = entryKey;
			}
		} // Koniec Konfiguracji
		//Deklaracja zmiennych do testow algorytmow
		boolean equalLength = Anagram.check_length(baseWord, comparedWord);
		boolean isAnagram = Anagram.check_is_anagram(baseWord, comparedWord, testHashMap, listTest);
		boolean isLonger = Anagram.check_is_longest(baseWord, comparedWord);
		boolean isBigger = Anagram.check_is_most_anagram(f, g);
		boolean isThereAnagram = Anagram.check_is_anagram_present(maxEntryKey);
		int isWorking = FileScanner.file_scan(file);

		assertEquals("Should properly check length of strings", true, equalLength);
		assertEquals("Should properly check if two strings are anagrams", true, isAnagram);
		assertEquals("Should be longer", false, isLonger);
		assertEquals("Should be bigger or equal",true,isBigger);
		assertEquals("There should be anagram present",true,isThereAnagram);
		assertEquals("Number of anagrams should be 1",12,isWorking);

	}

}
