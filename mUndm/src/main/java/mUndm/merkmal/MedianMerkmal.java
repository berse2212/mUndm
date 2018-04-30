package mUndm.merkmal;

import java.util.Arrays;

public class MedianMerkmal extends Merkmal {

	@Override
	public double getValue(double[] input, int off, int len) {
		double[] range = Arrays.copyOfRange(input, off, off + len - 1);
		
		Arrays.sort(range);

		if(range.length % 2 != 0) {
			return range[range.length / 2];
		} else {
			double val = range[range.length / 2 - 1] + range[range.length / 2];
			val = val / 2;
			
			return val;
		}

	}
	
	
}
