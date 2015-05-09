package cooccurence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;
import java.util.SortedMap;

public class ReadMap {

	public static SortedMap<String, Set<String>> hashReader(String filename) throws IOException, ClassNotFoundException{
		
		FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        @SuppressWarnings("unchecked")
		SortedMap<String, Set<String>> hashmap = (SortedMap<String, Set<String>>) ois.readObject();
        ois.close();
		
        return hashmap;
		
	}
	
}
