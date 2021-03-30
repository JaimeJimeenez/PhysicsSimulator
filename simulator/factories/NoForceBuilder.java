package simulator.factories;

import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NoForce;

public class NoForceBuilder extends Builder<ForceLaws> {
	
	public NoForceBuilder() {
		typeTag = "nf";
		description = "No force application to a body";
	}
	
	@Override
	protected ForceLaws createTheInstance(JSONObject data) {
		return new NoForce();
	}

}
