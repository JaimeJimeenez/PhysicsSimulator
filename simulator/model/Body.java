package simulator.model;

import org.json.JSONObject;

import simulator.misc.*;

//Basic body
public class Body {
	
	public Body(String id, Vector2D velocity, Vector2D force, Vector2D position, double mass) {
		this.id = id;
		this.velocity = velocity;
		this.force = force;
		this.position = position;
		this.mass = mass;
	}
	
	public String getId() { return id; }
	
	public Vector2D getVelocity() { return velocity; }
	
	public Vector2D getForce() { return force; }
	
	public Vector2D getPosition() { return position; }
	
	public double getMass() { return mass; }
	
	public void addForce(Vector2D newforce) { force.plus(newforce); }
	
	public void resetForce() { this.force = new Vector2D(); } //Provisional
	
	public void move(double time) {
		
		if (mass != 0) acceleration = force.scale(1/mass);
		position = position.plus(velocity.scale(time).plus(acceleration.scale(Math.pow(time, 2) / 2)));
		velocity = velocity.plus(acceleration.scale(time));
	}
	
	public JSONObject getState() {
		JSONObject returnJSON = new JSONObject();
		
		returnJSON.put("id", id);
		returnJSON.put("m", mass);
		returnJSON.put("p", position);
		returnJSON.put("v", velocity);
		returnJSON.put("f", force);
		
		return returnJSON;
		
	}
	
	public String toString() { return getState().toString();	}
	
	
	protected String id;
	protected Vector2D velocity;
	protected Vector2D force;
	protected Vector2D position;
	private Vector2D acceleration; //Or in move() put a local variable;
	protected double mass;

}
