package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class PrintMap {
    
    public static void printMap(HashMap<String, Set<String>> hash, String outputfilename) throws IOException{
    	
    	FileWriter fw = new FileWriter(outputfilename);

        for (Entry<String, Set<String>> entry : hash.entrySet()) {
        	
            String key = entry.getKey().toString();
            Set<String> value = entry.getValue();
            
            fw.write(key + " : " + value + "\n");
        }
        
        fw.close();
    }
}