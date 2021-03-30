package simulator.factories;

import org.json.JSONObject;

import simulator.control.EpsilonEqualStates;
import simulator.control.StateComparator;

public class EpsilonEqualStateBuilder extends Builder <StateComparator> {
	
	public EpsilonEqualStateBuilder() {
		typeTag = "epseq";
		description = "Epsilon - equal states comparator";
	}
	
	@Override
	protected StateComparator createTheInstance(JSONObject info) {
		double eps = info.has("eps") ? info.getDouble("eps") : 0.0;
		return new EpsilonEqualStates(eps);
	}
	
	@Override
	protected JSONObject createData() {
		JSONObject data = new JSONObject();
		data.put("eps", "the allowed error");
		return data;
	}
}
