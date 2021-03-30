package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;

public class BasicBodyBuilder extends Builder<Body> {
	
	public BasicBodyBuilder() {
		typeTag = "basic";
		description = "Basic model body";
	}
	
	@Override
	protected Body createTheInstance(JSONObject data) {
		return new Body(data.getString("id"), (Vector2D) data.get("v"), (Vector2D) data.get("p"), data.getDouble("m"));
	}

	@Override
	protected JSONObject createData() {
		JSONObject data = new JSONObject();
		
		data.put("id", "bl");
		data.put("p", new Vector2D(0.0E00, 0.0E00));
		data.put("v", new Vector2D(0.05E04, 0.0E00));
		data.put("m", 5.97E24);
		
		return data;
	}
	
}
