package io.lenra.app.api;

import java.util.Map;

public class Collection extends AbstractCollection<Map<String, Object>> {

	public Collection(AbstractDataApi api, String name) {
		super(api, name);
	}

	@Override
	protected Map<String, Object> mapTo(Map<String, Object> data) {
		return data;
	}

	@Override
	protected Map<String, Object> mapFrom(Map<String, Object> object) {
		return object;
	}

	@Override
	protected String getId(Map<String, Object> object) {
		return (String) object.get("_id");
	}
}