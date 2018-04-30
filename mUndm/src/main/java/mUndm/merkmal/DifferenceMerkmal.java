package mUndm.merkmal;

public class DifferenceMerkmal extends Merkmal {

	@Override
	public double getValue(double[] input, int off, int len) {
		return input[off] - input[len - 1];
	}
	
}
