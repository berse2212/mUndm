package testserver.median;

import java.util.stream.Collectors;

import mUndm.merkmal.MedianMerkmal;
import testserver.mean.GetDataResponse;

public class MedianExercise {

	public static MedianResultRequest responseToMedianRequest(GetDataResponse response) {
		MedianResultRequest result = new MedianResultRequest();
		result.setSession(response.getSession());
		result.setResults(response.getSignals().parallelStream()
			.map((s) -> {
				
				MedianResult r = new MedianResult();
				
				r.setId(s.getId());
				r.setMedian(new MedianMerkmal().getValue(s.getValues()));

				return r;
			}).collect(Collectors.toList()));
		
		return result;
	}	
}
