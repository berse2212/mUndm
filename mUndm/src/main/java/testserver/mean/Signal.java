package testserver.mean;

import java.util.List;

public class Signal {

	@Override
	public String toString() {
		return "Signal [id=" + id + ", values=" + values + "]";
	}

	private int id;
	
	private List<Double> values;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Double> getValues() {
		return values;
	}

	public void setValues(List<Double> values) {
		this.values = values;
	}
	
}
