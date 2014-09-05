import java.util.ArrayList;
import java.util.Arrays;
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

		for (int i = 1; i <= lengths.size(); i++) {
			if (lengths.get(i - 1) == 0) {
				lengths.remove(i - 1);
				i--;
			}
		}
		for (int i = 1; i <= widths.size(); i++) {
			if (widths.get(i - 1) == 0) {
				widths.remove(i - 1);
				i--;
			}
		}
		for (int i = 1; i <= heights.size(); i++) {
			if (heights.get(i - 1) == 0) {
				heights.remove(i - 1);
				i--;
			}
		}
		for (int i = 1; i <= mass1s.size(); i++) {
			if (mass1s.get(i - 1) == 0) {
				mass1s.remove(i - 1);
				i--;
			}
		}
		for (int i = 1; i <= mass2s.size(); i++) {
			if (mass2s.get(i - 1) == 0) {
				mass2s.remove(i - 1);
				i--;
			}
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

		if (mass1s.size() == 0) {
			mass1s.add(0.0);
		}
		if (mass2s.size() == 0) {
			mass2s.add(0.0);
		}

		double[] averages = {avgLengths, avgWidths, avgHeights, avgMass1s, avgMass2s};
		double[] uncertainty = {(Collections.max(lengths) - Collections.min(lengths)) / 2,
				(Collections.max(widths) - Collections.min(widths)) / 2,
				(Collections.max(heights) - Collections.min(heights)) / 2,
				(Collections.max(mass1s) - Collections.min(mass1s)) / 2,
				(Collections.max(mass2s) - Collections.min(mass2s)) / 2};
		double[] percentUncertainty = {(uncertainty[0] / averages[0]) * 100,
				(uncertainty[1] / averages[1]) * 100,
				(uncertainty[2] / averages[2]) * 100,
				(uncertainty[3] / averages[3]) * 100,
				(uncertainty[4] / averages[4]) * 100};
		double volume = averages[0] * averages[1] * averages[2];
		double volumeUncertainty = (percentUncertainty[0] / 100) + (percentUncertainty[1] / 100) +
				(percentUncertainty[2] / 100);
		volumeUncertainty *= volume;

		return new Data(averages, uncertainty, percentUncertainty, volume, volumeUncertainty);
	}

	@Override
	public String toString() {
		return "Data{" +
				"averages=" + Arrays.toString(averages) +
				"\nuncertainty=" + Arrays.toString(uncertainty) +
				"\npercentUncertainty=" + Arrays.toString(percentUncertainty) +
				"\nvolume=" + volume +
				", volumeUncertainty=" + volumeUncertainty +
				'}';
	}
} //end of Data class
