package simulator.model;

import simulator.misc.Vector2D;

public class MassLossingBody extends Body{
	
	public MassLossingBody(String id, Vector2D velocity, Vector2D position, double mass, double lossFactor, double lossFrequency) {
		super(id, velocity, position, mass);
		
		this.lossFactor = lossFactor;
		this.lossFrequency = lossFrequency;
	}
	
	public void move(double time) {
		super.move(time);
		
		for (double i = 0.0; i < time; i++) {
			if (i >= lossFrequency) {
				mass *= (1 - lossFactor);
				i = 0.0;
			}
		}
	}
	
	private double lossFactor;
	private double lossFrequency;
}
