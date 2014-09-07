/**
 * Created by Ben Scholer on 9/4/14.
 */
public class Shared {

	public static final double[] UNCERTAINTIES = {.1, .1, .1, .01, 1};

	public static boolean isInRange(Double number, double maxDif, double reg) {
		//TODO the implementation of the 'in range condition'
		// here the example implementation
		return number <= reg + maxDif && number >= reg - maxDif;
	}

} //end of Shared class
