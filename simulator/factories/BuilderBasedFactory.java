package simulator.factories;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class BuilderBasedFactory<T extends Builder<T>> implements Factory<T> {
	
	public BuilderBasedFactory(List<Builder<T>> builders) {
		this.builders = new ArrayList<>(builders);
		
		for (Builder<T> b : builders) 
			factoryElements.add(b.getBuilderInfo());
		
	}
	
	
	@Override
	public T createInstance(JSONObject info) {
		if (info == null) throw
			new IllegalArgumentException("Something went wrong");
		
		for (Builder<T> b : builders) 
			if (b.createInstance(info) != null) return (T) b;
		
		return null;
	}


	@Override
	public List<JSONObject> getInfo() { return factoryElements; }
	
	private List<Builder<T>> builders;
	private List<JSONObject> factoryElements;
}
