package cooccurence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import common.PrintMaps;
import common.ReadMaps;

public class Cooccurence {

	public static void findCooc(String inputfile1, String inputfile2, String outputfile, String outputhash)
			throws ClassNotFoundException, IOException {

		SortedMap<String, Set<String>> hashmap1 = ReadMaps.parsedHashReader(inputfile1);

		SortedMap<String, Set<String>> hashmap2 = ReadMaps.parsedHashReader(inputfile2);

		SortedMap<String, HashMap<String, Integer>> hashresult = new TreeMap<String, HashMap<String, Integer>>();

		HashMap<String, Integer> values = new HashMap<String, Integer>();

		List<String> intersections = new ArrayList<String>();

		// Intersections (mostly names)
		for (Entry<String, Set<String>> entry : hashmap1.entrySet()) {
			String key = entry.getKey();
			if (hashmap2.containsKey(key)) {
				intersections.add(key);
			}
		}
		// Delete intersections
		for (String key : intersections) {
			hashmap1.remove(key);
			hashmap2.remove(key);
		}

		for (Entry<String, Set<String>> entry1 : hashmap1.entrySet()) {

			String key1 = entry1.getKey();
			Set<String> value1 = entry1.getValue();

			for (Entry<String, Set<String>> entry2 : hashmap2.entrySet()) {

				String key2 = entry2.getKey();
				Set<String> value2 = entry2.getValue();

				int i = 0;

				for (String s1 : value1) {
					for (String s2 : value2) {
						if (s1.equals(s2)) {
							i++;
						}
					}
				}

				if (i != 0) {
					values.put(key2, i);
					hashresult.put(key1, values);
				}

			}
		}

		PrintMaps.printCoocMap(hashresult, outputfile, outputhash);

	}

}
