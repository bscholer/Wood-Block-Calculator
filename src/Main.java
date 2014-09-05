import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben Scholer on 9/4/14.
 */
public class Main {

	public static void main(String args[]) throws IOException{
		parseCSVFileLineByLine();
	}

	private static List<Block> parseCSVFileLineByLine() throws IOException {
		//create CSVReader object
		CSVReader reader = new CSVReader(new FileReader("res/Data.csv"), ',');

		List<Block> blocks = new ArrayList<Block>();
		//read line by line
		String[] record = null;

		while ((record = reader.readNext()) != null) {
			Block block = new Block(record);
			blocks.add(block);
		}

		reader.close();

		for (int i = 0; i < 5; i++) {
			System.out.println(blocks.get(i));
		}

		return blocks;
	}

} //end of Main class
