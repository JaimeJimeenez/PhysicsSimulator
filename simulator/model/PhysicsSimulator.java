package simulator.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class PhysicsSimulator {
	
	public PhysicsSimulator(ForceLaws laws, double stepTime) {
		if (laws == null) throw
			new IllegalArgumentException("Fatal error: force laws are null");
		this.laws = laws;
		
		if (stepTime < 0) throw 
			new IllegalArgumentException("Fatal error: real time must be positive");
		this.stepTime = stepTime;
		
		actualTime = 0.0;
	}
	
	public void addBody(Body b) {
		
		for (Body elem : bodies) {
			if (elem.getId() == b.getId()) throw 
				new IllegalArgumentException("Error: The body already exists");
		}
		
		bodies.add(b);
	}
	
	public void advance() {
		for (Body b : bodies) 
			b.resetForce();
		
		laws.apply(bodies);
		
		for (Body b : bodies)
			b.move(stepTime);
		
		actualTime += stepTime;
	}
	
	public JSONObject getState() {
		JSONObject stateData = new JSONObject();
		
		stateData.put("time", actualTime);
		stateData.put("bodies", bodies);
		
		return stateData;
	}
	
	public String toString() { return getState().toString(); }
	
	private List<Body> bodies;
	private ForceLaws laws;
	private double stepTime; //dt
	private double actualTime;
	
	public static void main(String[] args) {
		ArrayList<Body> bodyBuilders = new ArrayList<>();
		Body b1 = new Body("b1", new Vector2D(), new Vector2D(), 4.0);
		System.out.println(b1);
		bodyBuilders.add(b1);
	}
}
