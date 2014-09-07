import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ben Scholer on 9/4/14.
 */
public class Main {

	public static void main(String args[]) throws IOException {
		Map<String, ArrayList<Block>> blockMap = new TreeMap<String, ArrayList<Block>>();
		Map<String, Data> dataMap = new TreeMap<String, Data>();
		List<Block> blocks = parseCSVFileLineByLine();

		for (Block block : blocks) {
			if (blockMap.containsKey(block.getFullName())) {
				ArrayList<Block> blockArrayList = blockMap.get(block.getFullName());
				blockArrayList.add(block);
				blockMap.replace(block.getFullName(), blockArrayList);
			} else {
				ArrayList<Block> blockArrayList = new ArrayList<Block>();
				blockArrayList.add(block);
				blockMap.put(block.getFullName(), blockArrayList);
			}
		}

		for (Map.Entry<String, ArrayList<Block>> entry : blockMap.entrySet()) {
			dataMap.put(entry.getKey(), Data.math(entry.getValue()));
		}

		for (Map.Entry<String, ArrayList<Block>> entry : blockMap.entrySet()) {
			System.out.println("\t\t\t" + entry.getKey());
			for (Block block : entry.getValue()) {
//				System.out.println(block);
			}
			System.out.println(dataMap.get(entry.getKey()));
			System.out.println();
		}
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

		return blocks;
	}

} //end of Main class
