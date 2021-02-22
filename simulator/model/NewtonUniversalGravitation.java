package simulator.model;

import simulator.model.Body;

import java.util.List;

import simulator.misc.*;

public class NewtonUniversalGravitation implements ForceLaws {

	private static final double GRAVITATIONAL_CONSTANT = 6.67E-11;
	
	public NewtonUniversalGravitation(Body body1, Body body2) {
		this.body1 = body1;
		this.body2 = body2;
	}
	
	@Override
	public void apply(List<Body> bs) {
		
		for (int i = 0; i < bs.size(); i++) {
			Vector2D acceleration = forceDirection().scale(1/bs.get(i).getMass());
			
			
		}
	};
	
	public Vector2D forceDirection() {
		Vector2D direction = body1.getPosition().direction().minus(body2.getPosition().direction());
		return direction.scale(getForce());
	}
	
	public double getForce() { 
		return GRAVITATIONAL_CONSTANT * (body1.getMass() * body2.getMass()) / 
				Math.pow(body1.getPosition().distanceTo(body2.getPosition()), 2); 
	}
	
	private Body body1;
	private Body body2;
	
}
