package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.MassLossingBody;

public class MassLossingBodyBuilder extends Builder<Body> {
	
	public MassLossingBodyBuilder() {
		typeTag = "mlb";
		description = "Mass lossing body model";
	}
	
	//Remain Vector2D position and Vector2D velocity
	@Override
	protected Body createTheInstance(JSONObject data) {
		return new MassLossingBody(data.getString("id"), (Vector2D) data.get("p"), (Vector2D) data.get("v"), data.getDouble("m"), data.getDouble("freq"), data.getDouble("factor"));
	}
	
	protected JSONObject createData() {
		JSONObject data = new JSONObject();
		
		data.put("id", "bl");
		data.put("p", new Vector2D(-3.5E10, 0.0E00));
		data.put("v", new Vector2D(0.0E00, 1.4E03));
		data.put("m", 3.0E28);
		data.put("freq", 1.E3);
		data.put("factor", 1.E-3);
		
		return data;
	}
}
 