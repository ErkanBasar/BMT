package nlp;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LineReader {
	
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static List<String> readLines(String inputfile) throws IOException {
		Path path = Paths.get(inputfile);
		List<String> lines = Files.readAllLines(path, ENCODING);
		return lines;
	}

}
