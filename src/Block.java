/**
 * Created by Ben Scholer on 9/4/14.
 */
public class Block {

	private String blockType;
	private int blockIteration;
	private String fullName;

	//	public double length;
//	public double width;
//	public double height;
//	public double mass1;
//	public double mass2;
	private double[] values = new double[5];

	public Block(String[] record) {
		String fullName = record[0];
		fullName = fullName.trim();
		this.fullName = fullName;
		if (fullName.contains("A")) {
			blockType = "A";
			fullName = fullName.replace("A", "");
			blockIteration = Integer.parseInt(fullName);
		} else if (fullName.contains("B")) {
			blockType = "B";
			fullName = fullName.replace("B", "");
			blockIteration = Integer.parseInt(fullName);
		} else {
			blockType = "C";
			fullName = fullName.replace("C", "");
			blockIteration = Integer.parseInt(fullName);
		}
		for (int i = 0; i < record.length; i++) {
			if (record[i] == "" || record[i] == null) record[i] = "0";
		}
		try {
			values[0] = Double.parseDouble(record[1]);
			values[1] = Double.parseDouble(record[2]);
			values[2] = Double.parseDouble(record[3]);
			values[3] = Double.parseDouble(record[4]);
			values[4] = Double.parseDouble(record[5]);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Block " + blockType + blockIteration + " broke me.");
		}

		double length = values[0];
		double width = values[1];
		double height = values[2];
		double mass1 = values[3];
		double mass2 = values[4];

		if (blockType.equals("A")) {
			//finding proper length
			if (length <= 10.5 && length >= 9.5) {
			} else {
				if (width <= 10.5 && width >= 9.5) values[0] = width;
				else if (height <= 10.5 && height >= 9.5) values[0] = height;
			}

			//finding proper width
			if (width <= 9.2 && width >= 8.2) {
			} else {
				if (length <= 9.2 && length >= 8.2) values[1] = length;
				else if (height <= 9.2 && height >= 8.2) values[1] = height;
			}

			//finding proper height
			if (height <= 4.2 && height >= 3.2) {
			} else {
				if (length <= 4.2 && length >= 3.2) values[2] = length;
				else if (width <= 4.2 && width >= 3.2) values[2] = width;
			}
		} else if (blockType.equals("B")) {
			//finding proper length
			if (length <= 15.3 && length >= 14.3) {
			} else {
				if (width <= 15.3 && width >= 14.3) values[0] = width;
				else if (height <= 15.3 && height >= 14.3) values[0] = height;
			}

			//finding proper width
			if (width <= 9.2 && width >= 8.2) {
			} else {
				if (length <= 9.2 && length >= 8.2) values[1] = length;
				else if (height <= 9.2 && height >= 8.2) values[1] = height;
			}

			//finding proper height
			if (height <= 4.2 && height >= 3.2) {
			} else {
				if (length <= 4.2 && length >= 3.2) values[2] = length;
				else if (width <= 4.2 && width >= 3.2) values[2] = width;
			}
		} else if (blockType.equals("C")) {
			//finding proper length
			if (length <= 20.5 && length >= 19.5) {
			} else {
				if (width <= 20.5 && width >= 19.5) values[0] = width;
				else if (height <= 20.5 && height >= 19.5) values[0] = height;
			}

			//finding proper width
			if (width <= 9.2 && width >= 8.2) {
			} else {
				if (length <= 9.2 && length >= 8.2) values[1] = length;
				else if (height <= 9.2 && height >= 8.2) values[1] = height;
			}

			//finding proper height
			if (height <= 4.2 && height >= 3.2) {
			} else {
				if (length <= 4.2 && length >= 3.2) values[2] = length;
				else if (width <= 4.2 && width >= 3.2) values[2] = width;
			}
		}

//		if (blockType.equals("A")) {
//			if (Shared.isInRange(values[0], .5, 10)) values[0] = 0;
//			if (Shared.isInRange(values[1], .5, 8.7)) values[1] = 0;
//			if (Shared.isInRange(values[2], .5, 3.7)) values[2] = 0;
//			if (Shared.isInRange(values[3], 1, 10)) values[3] = 0;
//			if (Shared.isInRange(values[4], 1, 10)) values[4] = 0;
//		}
	}

	public double getLength() {
		return values[0];
	}

	public double getWidth() {
		return values[1];
	}

	public double getHeight() {
		return values[2];
	}

	public double getMass1() {
		return values[3];
	}

	public double getMass2() {
		return values[4];
	}

	public String getBlockType() {
		return blockType;
	}

	public int getBlockIteration() {
		return blockIteration;
	}

	public String getFullName() {
		return fullName;
	}

	@Override
	public String toString() {
		return "Block{" +
				"length=" + values[0] +
				"\twidth=" + values[1] +
				"\theight=" + values[2] +
				"\tmass1=" + values[3] +
				"\tmass2=" + values[4] +
				'}';
	}
} //end of Block class