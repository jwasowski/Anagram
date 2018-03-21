package junitdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Anagram {

	public static boolean check_length(String a, String b) {
		if (a.length() == b.length())
			return true;
		else
			return false;
	}

	public static boolean check_is_anagram(String a, String b, HashMap<String, ArrayList<String>> c,
			ArrayList<String> d) {
		if (a.equals(b)|| check_length(a, b) != true) {
			return false;
		}
		/*if (check_length(a, b) != true) {
			return false;}*/
		 else {

			char[] aArray = a.toCharArray();
			char[] bArray = b.toCharArray();

			Arrays.sort(aArray);
			Arrays.sort(bArray);
			if (Arrays.equals(aArray, bArray)) {

				d.add(b);
				c.put(a, d);
				return true;
			}

			return false;
		}

	}

	public static boolean check_is_longest(String a, String b) {
		if (a.equals(b)) {
			return false;
		}
		if (a.length() > b.length()) {
			return true;
		}

		return false;
	}

	public static boolean check_is_anagram_present(Entry<String, ArrayList<String>> e) {
		if (e.getValue() != null) {
			return true;
		}

		return false;
	}

	public static boolean check_is_most_anagram(int f, int g) {
		if (f >= g) {
			return true;
		}

		return false;
	}
}