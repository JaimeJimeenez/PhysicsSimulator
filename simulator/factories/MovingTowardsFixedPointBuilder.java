package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.ForceLaws;
import simulator.model.MovingTowardsFixedPoint;

public class MovingTowardsFixedPointBuilder extends Builder<ForceLaws> {
	
	public MovingTowardsFixedPointBuilder() {
		typeTag = "mtcp";
		description = "Moving towards fixed point law";
	}

	@Override
	protected ForceLaws createTheInstance(JSONObject data) {
		Vector2D fixedPoint = (Vector2D) (data.has("c") ? data.getJSONArray("c") : 0.0);
		double gravity = data.has("g") ? data.getDouble("g") : 9.81;
		return new MovingTowardsFixedPoint(fixedPoint, gravity);
	}
	
	@Override
	protected JSONObject createData() {
		JSONObject data = new JSONObject();
		
		data.put("c", new Vector2D(0.0, 0.0));
		data.put("g", 9.81);
		
		return data;
	}
}
