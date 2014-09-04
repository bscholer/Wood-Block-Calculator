/**
 * Created by Ben Scholer on 9/4/14.
 */
public class Block {

	private String blockType;
	private int blockIteration;
//	public double length;
//	public double width;
//	public double height;
//	public double mass1;
//	public double mass2;
	private double[] values = new double[5];

	public Block(String[] record) {
		String fullName = record[0];
		fullName.trim();
		if (fullName.contains("A")) {
			blockType = "A";
			fullName.replace("A", "");
			blockIteration = Integer.parseInt(fullName);
		} else if (fullName.contains("B")) {
			blockType = "B";
			fullName.replace("B", "");
			blockIteration = Integer.parseInt(fullName);
		} else {
			blockType = "C";
			fullName.replace("C", "");
			blockIteration = Integer.parseInt(fullName);
		}
		values[0] = Double.parseDouble(record[1]);
		values[1] = Double.parseDouble(record[2]);
		values[2] = Double.parseDouble(record[3]);
		values[3] = Double.parseDouble(record[4]);
		values[4] = Double.parseDouble(record[5]);

		double length = values[0];
		double width = values[1];
		double height = values[2];
		double mass1 = values[3];
		double mass2 = values[4];

		//TODO add outlier finding
	}
} //end of Block class
