package hashcreator;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

public class PrintMap {

	public static void printMap(SortedMap<String, Set<String>> hash, String outputfile, String outputhash) 
			throws IOException {

		FileOutputStream fos = new FileOutputStream(outputhash);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(hash);
		oos.close();
		fos.close();

		FileWriter fw = new FileWriter(outputfile);
		
		for (Entry<String, Set<String>> entry : hash.entrySet()) {

			String key = entry.getKey().toString();
			Set<String> value = entry.getValue();

			fw.write(key + " : " + value + "\n");
		}

		fw.close();
	}
}