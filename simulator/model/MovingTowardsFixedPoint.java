package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class MovingTowardsFixedPoint implements ForceLaws {
	
	public MovingTowardsFixedPoint(Vector2D fixedPoint, double gravity) {
		this.fixedPoint = fixedPoint;
		this.gravity = gravity;
	}
	
	@Override
	public void apply(List<Body> bs) {
		
		for (Body b : bs) 
			b.addForce(fixedPoint.minus(b.getPosition().direction().scale(gravity * b.getMass())));
		
	}
	
	public String toString() { return ""; } //TODO
	
	private Vector2D fixedPoint; //c
	private double gravity; //g
	
}
