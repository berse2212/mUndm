package mUndm.merkmal;

import java.util.List;

public abstract class Merkmal {
	
	public abstract double getValue(double[] input, int off, int len);
	
	public double getValue(double... input) {
		return getValue(input, 0, input.length);
	}
	
	public double getValue(List<Double> input) {
		return getValue(input.parallelStream().mapToDouble(Double::valueOf).toArray(), 0, input.size());
	}
	
}
