
import java.util.LinkedList;
import java.util.Scanner;

public class Pronunciation {
	private String word;
	private String phonemes;

	Pronunciation(String p) {
		int i = p.indexOf(' ');
		word = p.substring(0, i);
		phonemes = p.substring(i+1);
	}

	public String getWord() {
		return word;
	}

	public String getPhonemes() {
		return phonemes;
	}

	public String toString() {
		String s = word + " " + phonemes;
		return s;
	}
}
