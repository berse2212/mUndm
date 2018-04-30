package mUndm.merkmal;

import java.util.stream.DoubleStream;

public class VarianzMerkmal extends Merkmal {

	@Override
	public double getValue(double[] input, int off, int len) {
		double average = DoubleStream.of(input).skip(off).limit(len).average().getAsDouble();
		
		double var = 0;
        for(int i = off; i < off + len; i++) {
        	var += (input[i]-average)*(input[i]-average);
        }
        
        var = var/input.length;
        
        return var;
	}

	
}
