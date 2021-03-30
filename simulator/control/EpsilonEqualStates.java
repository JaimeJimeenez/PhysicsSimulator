package simulator.control;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class EpsilonEqualStates implements StateComparator {
	
	public EpsilonEqualStates(double eps) {
		this.eps = eps;
	}
	
	@Override
	public boolean equal(JSONObject s1, JSONObject s2) {
		if (s1.getDouble("time") != s2.getDouble("time")) return false;
		
		for (int i = 0; i < s1.length(); i++) {
			if (s1.getString("id") != s2.getString("id")) return false;
			
			double m = Math.abs(s1.getDouble("mass") - s2.getDouble("mass"));
			if (m > eps) return false;
			
			double p = ((Vector2D) s1.get("p")).distanceTo((Vector2D) s2.get("p"));
			if (p > eps) return false;
			
			double v = ((Vector2D) s1.get("v")).distanceTo((Vector2D) s2.get("v"));
			if (v > eps) return false;
			
			double f = ((Vector2D) s1.get("f")).distanceTo((Vector2D) s2.get("f"));
			if (f > eps) return false;
		}
		
		return true;
	}
	
	private double eps;
}
