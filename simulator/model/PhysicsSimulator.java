package simulator.model;

import org.json.JSONObject;

public class PhysicsSimulator {

	public PhysicsSimulator (double time, B) {
		
	}
	
	public void advance() {
		resetForce();
		apply();
		move(time);
	}
	
	
	
	public void addBody(Body b) {
		
	}
	
	public JSONObject getState() {
		JSONObject returnJSON= new JSONObject();
		
		returnJSON.put("time", T);
		returnJSON.put("bodies", body);
		
		return returnJSON;
	}
	
	public String toString() { return getState().toString(); }
}
