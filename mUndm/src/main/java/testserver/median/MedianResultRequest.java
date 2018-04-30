package testserver.median;

import java.util.List;

import testserver.base.RequestBase;

public class MedianResultRequest extends RequestBase {
	

	private List<MedianResult> results;

	public List<MedianResult> getResults() {
		return results;
	}

	public void setResults(List<MedianResult> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "ResultRequest [session=" + getSession() + ", results=" + results + "]";
	}
	
}
