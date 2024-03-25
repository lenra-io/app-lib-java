package io.lenra.app.api;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.lenra.app.data.Data;

public class TypedCollection<D extends Data> extends AbstractCollection<D> {
	private static ObjectMapper MAPPER = new ObjectMapper();
	private static TypeReference<HashMap<String, Object>> MAP_TYPE_REF = new TypeReference<HashMap<String, Object>>() {
	};

	private final Class<D> collClass;

	TypedCollection(AbstractDataApi api, Class<D> collClass) {
		super(api, DataApi.collectionName(collClass));
		this.collClass = collClass;
	}

	@Override
	protected D mapTo(Map<String, Object> data) {
		return MAPPER.convertValue(data, collClass);
	}

	@Override
	protected Map<String, Object> mapFrom(D object) {
		return MAPPER.convertValue(object, MAP_TYPE_REF);
	}

	@Override
	protected String getId(D object) {
		return object.getId();
	}
}
