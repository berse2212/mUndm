package testserver.mean;

import java.util.stream.Collectors;

import mUndm.merkmal.MeanMerkmal;

public class MeanExercise {
	
	public static MeanResultRequest responseToMeanRequest(GetDataResponse response) {
		MeanResultRequest result = new MeanResultRequest();
		result.setSession(response.getSession());
		result.setResults(response.getSignals().parallelStream()
			.map((s) -> {
				
				MeanResult r = new MeanResult();
				
				r.setId(s.getId());
				r.setMean(new MeanMerkmal().getValue(s.getValues()));

				return r;
			}).collect(Collectors.toList()));
		
		return result;
	}

	
}
