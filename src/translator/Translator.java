package translator;

import java.io.IOException;
import java.util.HashMap;
import java.util.SortedMap;

import common.ReadMaps;

public class Translator {

	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		
		SortedMap<String, HashMap<String, Integer>> hashresult = ReadMaps.coocHashReader("../TepacDocs/coocmaps/article3_en_tr_hashmap_RESULT.ser");
		
		
	}
}
