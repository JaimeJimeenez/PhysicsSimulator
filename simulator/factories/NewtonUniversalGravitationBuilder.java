package simulator.factories;

import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuilder extends Builder<ForceLaws> {

	public NewtonUniversalGravitationBuilder() {
		typeTag = "nlug";
		description = "Newton's law of universal gravitation";
	}

	@Override
	protected ForceLaws createTheInstance(JSONObject data) {
		double gravitational = data.has("G") ? data.getDouble("G") : 6.67E10-11;
		return new NewtonUniversalGravitation(gravitational);
	}
	
	@Override
	protected JSONObject createData() {
		JSONObject data = new JSONObject();
		data.put("G", 6.67E10-11);
		return data;
	}
}
