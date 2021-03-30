package simulator.model;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class Body {
	
	public Body(String id, Vector2D velocity, Vector2D position, double mass) {
		this.id = id;
		this.velocity = velocity;
		this.force = new Vector2D();
		this.position = position;
		this.mass = mass;
	}
	
	public String getId() { return id; }
	
	public Vector2D getVelocity() { return velocity; }
	
	public Vector2D getForce() { return force; }
	
	public Vector2D getPosition() { return position; }
	
	public double getMass() { return mass; }
	
	void addForce(Vector2D newForce) { force.plus(newForce); }
	
	void resetForce() { force = new Vector2D(); }
	
	void move(double time) {
		Vector2D acceleration = force.scale(1/mass);
		
		position =  position.plus(velocity.scale(time).plus(acceleration.scale(0.5 * time * time)));
		velocity = velocity.plus(acceleration.scale(time));
	}
	
	public boolean equals(Object other) { return this.equals(other); /*Must check*/ }
	
	public JSONObject getState() {
		JSONObject returnJSON = new JSONObject();
		
		returnJSON.put("id", id);
		returnJSON.put("m", mass);
		returnJSON.put("p", position);
		returnJSON.put("v", velocity);
		returnJSON.put("f", force);
		
		return returnJSON;
	}
	
	public String toString() { return getState().toString(); }
	
	protected String id;
	protected Vector2D velocity;
	protected Vector2D force;
	protected Vector2D position;
	protected double mass;
}
