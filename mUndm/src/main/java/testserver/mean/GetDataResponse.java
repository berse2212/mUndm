package testserver.mean;

import java.util.List;

import testserver.base.ResponseBase;

public class GetDataResponse extends ResponseBase {

	private List<Signal> signals;
	
	public List<Signal> getSignals() {
		return signals;
	}

	public void setSignals(List<Signal> signals) {
		this.signals = signals;
	}

	@Override
	public String toString() {
		return "GetDataResponse [session=" + session + ", signals=" + signals + ", id=" + id + ", exercise=" + exercise
				+ ", token=" + token + "]";
	}
	
}
