import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;

public class Anagrams {

	final Integer[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
			89, 97, 101 };
	Map<Character, Integer> letterTable;
	Map<Long, ArrayList<String>> anagramTable;

	// constructor //
	public Anagrams() {
		letterTable = new HashMap<Character, Integer>();
		anagramTable = new HashMap<Long, ArrayList<String>>();
		buildLetterTable();

	}

	public Map<Character, Integer> getLetterTable() {
		return this.letterTable;
	}

	public Map<Long, ArrayList<String>> getAnagramTable() {
		return this.anagramTable;
	}

	// builds the letter table by assigning letters (keys) to their respective
	// primes (values) //
	public void buildLetterTable() {
		char c = 'a';
		for (int i = 0; i < primes.length; i++) {
			letterTable.put(c, primes[i]);
			c++;
		}
	}

	public void processFile(String s) throws IOException {
		FileInputStream fstream = new FileInputStream(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while ((strLine = br.readLine()) != null) {
			this.addWord(strLine);
		}
		br.close();
	}

	// finds the hash code of the given parameter string s. set to public for
	// testing purposes. //
	public Long myHashCode(String s) {
		Long h=1L;
		for (int i = 0; i < s.length(); i++) {
			h*=letterTable.get(s.charAt(i));
		}
		return h;
	}

	// adds word to value and hash code to anagram table for first anagram with that
	// code being added; //
	// for anagrams not being added first, only the anagram itself is added to the
	// values of anagram table. //
	public void addWord(String s) {
		if(anagramTable.get(myHashCode(s)) == null){
			anagramTable.put(myHashCode(s), new ArrayList<String>(Arrays.asList(s)));
			return;
		}
		ArrayList<String> a = anagramTable.get(myHashCode(s));
		a.add(s);
		anagramTable.put(myHashCode(s), a);
	}

	// finds set of max entries + the key it belongs to. set to public for testing
	// purposes //
	public ArrayList<Map.Entry<Long, ArrayList<String>>> getMaxEntries() {
		//get largest size'
		List<Integer> a = anagramTable.values().stream().map(arr -> arr.size()).collect(Collectors.toList());
		int maxsize=Collections.max(a);
		ArrayList<Map.Entry<Long, ArrayList<String>>> n = new ArrayList<Map.Entry<Long, ArrayList<String>>>();
		for (Map.Entry<Long, ArrayList<String>> entry : anagramTable.entrySet()) {
			if(entry.getValue().size() == maxsize)
				n.add(entry);
		}
		return n;
	}

	public static void main(String[] args) {
		/* Anagrams a = new Anagrams();
		System.out.println(
			a.myHashCode("alerts") + " " + a.myHashCode("alters")
		);
		a.addWord("alerts");
		a.addWord("alters");
		System.out.println(a.anagramTable);
		a.getMaxEntries();
		 */
		Anagrams a = new Anagrams();
		final long startTime = System.nanoTime();
		try {
			a.processFile("words_alpha.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = a.getMaxEntries();
		final long estimatedTime = System.nanoTime() - startTime;
		final double seconds = ((double) estimatedTime / 1000000000);
		System.out.println("Elapsed Time: " + seconds);
		System.out.println("Key of max anagrams: " + maxEntries.get(0).getKey());
		System.out.println("List of max anagrams: " + maxEntries.get(0).getValue());
		System.out.println("Length of list of max anagrams: " + maxEntries.get(0).getValue().size());
	}
}