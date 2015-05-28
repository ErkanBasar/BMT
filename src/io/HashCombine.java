package io;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class HashCombine {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		
		combineOccur(1,3);
		
		combineCooc(1,3);
		
	}
	
	public static void combineOccur(int first, int last) throws IOException, ClassNotFoundException{
		
		SortedMap<String, Set<String>> totalhash_en = new TreeMap<String, Set<String>>();
		
		SortedMap<String, Set<String>> totalhash_tr = new TreeMap<String, Set<String>>();
		
		
		for (int i = first; i <= last; i++) {
				
			SortedMap<String, Set<String>> ar_en = ReadMaps.readerOccur("../BMTDocs/occurrence/maps/article" + i + "_en_hashmap.ser");			
				
			totalhash_en.putAll(ar_en);
			
			SortedMap<String, Set<String>> ar_tr = ReadMaps.readerOccur("../BMTDocs/occurrence/maps/article" + i + "_tr_hashmap.ser");			
			
			totalhash_tr.putAll(ar_tr);
				
		}
		
		
		String outputfile_en = "../BMTDocs/total/texts/totalhash_en.txt";
		String outputhash_en = "../BMTDocs/total/maps/totalhash_en.ser";
		
		PrintMaps.printOccurMap(totalhash_en, outputfile_en, outputhash_en);
		
		String outputfile_tr = "../BMTDocs/total/texts/totalhash_tr.txt";
		String outputhash_tr = "../BMTDocs/total/maps/totalhash_tr.ser";
		
		PrintMaps.printOccurMap(totalhash_tr, outputfile_tr, outputhash_tr);
		
		
		System.out.println("All occurence hashmaps are combined in totalhash_en.ser & totalhash_tr.ser");
	}
	
	
	public static void combineCooc(int first, int last) throws IOException, ClassNotFoundException{
	
		
		SortedMap<String, HashMap<String, Integer>> totalhash = new TreeMap<String, HashMap<String, Integer>>();
		
		for (int i = first; i <= last; i++) {
			
			SortedMap<String, HashMap<String, Integer>> ar_en_tr = ReadMaps.readerCooc("../BMTDocs/coocurence/maps/article" + i + "_en_tr_hashmap_RESULT.ser");

			SortedMap<String, HashMap<String, Integer>> ar_tr_en = ReadMaps.readerCooc("../BMTDocs/coocurence/maps/article" + i + "_tr_en_hashmap_RESULT.ser");

			totalhash.putAll(ar_en_tr);
			totalhash.putAll(ar_tr_en);
			
		}
		
		String outputfile = "../BMTDocs/total/text/totalhash_cooc.txt";
		String outputhash = "../BMTDocs/total/maps/totalhash_cooc.ser";
		
		PrintMaps.printCoocMap(totalhash, outputfile, outputhash);
		
		
		System.out.println("All co-occurrence hashmaps are combined in totalhash.ser");
	}

}
