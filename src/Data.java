import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ben Scholer on 9/4/14.
 */
public class Data {

	private double[] averages = new double[5];
	private double[] uncertainty = new double[5];
	private double[] percentUncertainty = new double[5];
	private double volume;
	private double volumeUncertainty;

	public Data(double[] averages, double[] uncertainty, double[] percentUncertainty, double volume, double volumeUncertainty) {
		this.averages = averages;
		this.uncertainty = uncertainty;
		this.percentUncertainty = percentUncertainty;
		this.volume = volume;
		this.volumeUncertainty = volumeUncertainty;
	}

	public Data() {
	}

	public double[] getAverages() {
		return averages;
	}

	public double[] getUncertainty() {
		return uncertainty;
	}

	public double[] getPercentUncertainty() {
		return percentUncertainty;
	}

	public double getVolume() {
		return volume;
	}

	public double getVolumeUncertainty() {
		return volumeUncertainty;
	}

	public static Data math(ArrayList<Block> blocks) {
		List<Double> lengths = new ArrayList<Double>();
		List<Double> widths = new ArrayList<Double>();
		List<Double> heights = new ArrayList<Double>();
		List<Double> mass1s = new ArrayList<Double>();
		List<Double> mass2s = new ArrayList<Double>();

		//Adding data to the Lists above
		for (Block block : blocks) {
			lengths.add(block.getLength());
			widths.add(block.getWidth());
			heights.add(block.getHeight());
			mass1s.add(block.getMass1());
			mass2s.add(block.getMass2());
		}

		double totLengths = 0;
		double totWidths = 0;
		double totHeights = 0;
		double totMass1s = 0;
		double totMass2s = 0;

		for (Double num : lengths) totLengths += num;
		for (Double num : widths) totWidths += num;
		for (Double num : heights) totHeights += num;
		for (Double num : mass1s) totMass1s += num;
		for (Double num : mass2s) totMass2s += num;

		double avgLengths = totLengths / lengths.size();
		double avgWidths = totWidths / widths.size();
		double avgHeights = totHeights / heights.size();
		double avgMass1s = totMass1s / mass1s.size();
		double avgMass2s = totMass2s / mass2s.size();

		double[] averages = {avgLengths, avgWidths, avgHeights, avgMass1s, avgMass2s};
		double[] uncertainty = {(Collections.max(lengths) - Collections.min(lengths)) / 2,
				(Collections.max(widths) - Collections.min(widths)) / 2,
				(Collections.max(heights) - Collections.min(heights)) / 2,
				(Collections.max(mass1s) - Collections.min(mass1s)) / 2,
				(Collections.max(mass2s) - Collections.min(mass2s)) / 2};
		double[] percentUncertainty = {};
		double volume;
		double volumeUncertainty;

		return null;
	}
} //end of Data class
