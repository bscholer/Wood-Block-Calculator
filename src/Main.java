import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
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
		List<String[]> toWrite = new ArrayList<String[]>();
		List<String[]> toWriteMore = new ArrayList<String[]>();
		String[] headerMore = {"Description", "Block #", "Length", "Width", "Height", "Mass(scale 1)", "Mass(scale 2)"};
		String[] header = {"Block #", "Volume", "Volume Uncertainty", "Volume ± Uncertainty"};
		toWriteMore.add(headerMore);
		toWrite.add(header);

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
			Data data = dataMap.get(entry.getKey());
			String[] strings = {data.getBlockName(), "" + data.getVolume(), "" + data.getVolumeUncertainty(),
					data.getVolume() + " ± " + data.getVolumeUncertainty()};
			toWrite.add(strings);

			String[] stringsAvg = {"Averages", data.getBlockName(), "" + data.getAverages()[0],
					"" + data.getAverages()[1], "" + data.getAverages()[2], "" + data.getAverages()[3],
					"" + data.getAverages()[4]};
			String[] stringsUnc = {"Uncertainties", data.getBlockName(), "" + data.getUncertainty()[0],
					"" + data.getUncertainty()[1], "" + data.getUncertainty()[2], "" + data.getUncertainty()[3],
					"" + data.getUncertainty()[4]};
			String[] stringsUncPer = {"Percent Uncertainties", data.getBlockName(),
					data.getPercentUncertainty()[0] + "%",
					data.getPercentUncertainty()[1] + "%",
					data.getPercentUncertainty()[2] + "%",
					data.getPercentUncertainty()[3] + "%",
					data.getPercentUncertainty()[4] + "%"};
			toWriteMore.add(stringsAvg);
			toWriteMore.add(stringsUnc);
			toWriteMore.add(stringsUncPer);
		}
		CSVWriter writer = new CSVWriter(new FileWriter("res/Calculated Data.csv"));
		writer.writeAll(toWrite);
		writer.close();

		CSVWriter writerMore = new CSVWriter(new FileWriter("res/More Calculated Data.csv"));
		writerMore.writeAll(toWriteMore);
		writerMore.close();
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
