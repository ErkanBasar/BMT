package cooccurrence;

import io.PrintMaps;
import io.ReadMaps;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Cooccurrence {

	public static void findCooc(String inputfile1, String inputfile2,
			String outputfile, String outputhash)
			throws ClassNotFoundException, IOException {

		SortedMap<String, Set<String>> hashmap_en = ReadMaps.readerOccur(inputfile1);

		SortedMap<String, Set<String>> hashmap_tr = ReadMaps.readerOccur(inputfile2);

		SortedMap<String, HashMap<String, Integer>> hashresult = new TreeMap<String, HashMap<String, Integer>>();

		HashMap<String, Integer> values = new HashMap<String, Integer>();
		 

		for (Entry<String, Set<String>> entry_en : hashmap_en.entrySet()) {

			String key_en = entry_en.getKey();
			Set<String> value_en = entry_en.getValue();

			for (Entry<String, Set<String>> entry2 : hashmap_tr.entrySet()) {

				String key_tr = entry2.getKey();
				Set<String> value_tr = entry2.getValue();

				int inter = 0;

				for (String s1 : value_en) {
					for (String s2 : value_tr) {
						if (s1.equals(s2)) {
							inter++;
						}
					}
				}

				if (inter != 0) {
					values.put(key_tr, inter);
					hashresult.put(key_en, values);
				}

			}

		}

		PrintMaps.printCoocMap(hashresult, outputfile, outputhash);

	}

	public static String findMax(String input) throws ClassNotFoundException,
			IOException {

		SortedMap<String, HashMap<String, Integer>> totalhash = ReadMaps.readerCooc("../BMTDocs/total/maps/totalhash_cooc.ser");

		if (totalhash.containsKey(input)) {

			HashMap<String, Integer> valuehash = totalhash.get(input);

			String maxKey = null;
			Integer maxValue = 0;

			for (Entry<String, Integer> entry : valuehash.entrySet()) {
				if (entry.getValue() > maxValue) {
					maxValue = entry.getValue();
					maxKey = entry.getKey();
				}
			}

			return maxKey;

		} else {
			return null;
		}

	}

}
