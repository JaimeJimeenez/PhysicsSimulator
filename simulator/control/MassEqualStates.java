package simulator.control;

import org.json.JSONObject;

public class MassEqualStates implements StateComparator{
	
	public MassEqualStates() {
		
	}

	@Override
	public boolean equal(JSONObject s1, JSONObject s2) {
		if (s1.getDouble("time") != s2.getDouble("time")) return false;
		
		for (int i = 0; i < s1.length(); i++)
			if (s1.getDouble("mass") != s2.getDouble("mass") || s1.getString("id") != s2.getString("id")) return false;
		
		return true;
	}
	
	
}
