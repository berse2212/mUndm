package testserver.mean;

import java.util.List;

import testserver.base.RequestBase;

public class MeanResultRequest extends RequestBase {
	

	private List<MeanResult> results;

	public List<MeanResult> getResults() {
		return results;
	}

	public void setResults(List<MeanResult> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "ResultRequest [session=" + getSession() + ", results=" + results + "]";
	}
	
}
