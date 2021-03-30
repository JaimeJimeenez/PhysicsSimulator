package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class NewtonUniversalGravitation implements ForceLaws {
	
	public NewtonUniversalGravitation(double gravitational) {
		this.gravitational = gravitational;
	}
	
	public void apply(List<Body> bodies) {
		
		for (int i = 0; i < bodies.size(); i++) {
			if (bodies.get(i).getMass() != 0) {
				for (int j = 0; j < bodies.size(); j++) {
					if (!bodies.get(i).equals(bodies.get(j))) 
						bodies.get(i).addForce(force(bodies.get(i), bodies.get(j)));
				}
			}
			else
				bodies.get(i).addForce(new Vector2D());
		}
	}
	
	private Vector2D force(Body a, Body b) {
		Vector2D delta = b.getPosition().minus(a.getPosition());
		double distance = delta.magnitude();
		double magnitude = distance > 0 ? (gravitational * a.getMass()) / (distance * distance) : 0.0;
		
		return delta.direction().scale(magnitude);
	}
	
	public String toString() { return ""; } //TODO
	
	private double gravitational;
}
