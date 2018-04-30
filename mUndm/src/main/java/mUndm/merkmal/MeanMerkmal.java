package mUndm.merkmal;

import java.util.stream.DoubleStream;

public class MeanMerkmal extends Merkmal {

	@Override
	public double getValue(double[] input, int off, int len) {
		return DoubleStream.of(input).skip(off).limit(len).average().getAsDouble();
	}
	
	
}
