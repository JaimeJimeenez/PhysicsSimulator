package simulator.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.Factory;
import simulator.model.Body;
import simulator.model.PhysicsSimulator;

public class Controller {

	public Controller() {
		
	}
	
	public void loadBodies(InputStream in) {
		JSONObject jsonInput = new JSONObject(new JSONTokener(in));
		JSONArray bodies = jsonInput.getJSONArray("bodies");
		
		for (int i = 0; i < bodies.length(); i++) 
			simulator.addBody(bodiesFactory.createInstance(bodies.getJSONObject(i)));
		
	}
	
	public void run(int steps, OutputStream out, InputStream expOut, StateComparator cmp) {
		JSONObject expOutJO = null;
		
		if (expOut != null) 
			expOutJO = new JSONObject(new JSONTokener(expOut));
		
		if (out == null) {
			out = new OutputStream() {
				@Override
				public void write(int b) throws IOException{ }
			};
		}
		
		PrintStream p = new PrintStream(out);
		p.println("{");
		p.println("\"states\": [");
		
		JSONObject currState = null;
		JSONObject expState = null;
		
		//compare initial states
		currState = simulator.getState();
		p.println(currState);
		if (expOutJO != null) {
			expState = expOutJO.getJSONArray("states").getJSONObject(0);
			//if (!cmp.equal(expState, currState))
				//throw new NotEqualStatesException(expState, currState, 0);
		}
		
		//Compare the rest of cases with for,
		//throw an exception in case the compare needed and
		//the states are not equal
	}
	
	PhysicsSimulator simulator;
	Factory<Body> bodiesFactory;
}
