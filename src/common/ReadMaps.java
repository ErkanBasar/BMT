package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Set;
import java.util.SortedMap;

public class ReadMaps {
	
	public static SortedMap<String, HashMap<String, Integer>> coocHashReader(String filename) throws IOException, ClassNotFoundException{
		
		FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        @SuppressWarnings("unchecked")
		SortedMap<String, HashMap<String, Integer>> hashmap = (SortedMap<String, HashMap<String, Integer>>) ois.readObject();
        ois.close();
		
        return hashmap;
		
	}

	public static SortedMap<String, Set<String>> parsedHashReader(String filename) throws IOException, ClassNotFoundException{
		
		FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        @SuppressWarnings("unchecked")
		SortedMap<String, Set<String>> hashmap = (SortedMap<String, Set<String>>) ois.readObject();
        ois.close();
		
        return hashmap;
		
	}
	
}
