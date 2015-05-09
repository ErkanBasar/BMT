package cooccurence;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.SortedMap;

public class PrintCoocMap {

	public static void printMap(SortedMap<String, HashMap<String, Integer>> hashresult, String outputfile, String outputhash) 
			throws IOException {

		FileOutputStream fos = new FileOutputStream(outputhash);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(hashresult);
		oos.close();
		fos.close();

		FileWriter fw = new FileWriter(outputfile);
		
		for (Entry<String, HashMap<String, Integer>> entry : hashresult.entrySet()) {

			String key = entry.getKey().toString();
			HashMap<String, Integer> value = entry.getValue();

			fw.write(key + " : " + value + "\n");
		}

		fw.close();
	}
}