package simulator.factories;

import org.json.JSONObject;

abstract public class Builder <T> {
	
	public Builder() {
		
	}
	
	public T createInstance(JSONObject info) {
		
		if (typeTag != null && typeTag.equals(info.getString("type")))
			return createTheInstance(info.getJSONObject("data"));
		
		throw new IllegalArgumentException("Something went wrong");
	}
	
	public JSONObject getBuilderInfo() {
		JSONObject dataBuilder = new JSONObject();
		
		dataBuilder.put("type", typeTag);
		dataBuilder.put("data", createData());
		dataBuilder.put("desc", description);
		
		return dataBuilder;
	}
	
	protected JSONObject createData() { return new JSONObject(); }
	
	abstract protected T createTheInstance(JSONObject data);
	
	protected String typeTag;
	protected String description;
}
