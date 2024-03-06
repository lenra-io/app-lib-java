package io.lenra.app.api;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDataApi {
	public io.lenra.api.internal.client.DataApi api;

	public AbstractDataApi(io.lenra.api.internal.client.DataApi api) {
		this.api = api;
	}

	public io.lenra.api.internal.client.DataApi getApi() {
		return api;
	}

	private final Map<String, Collection> collections = new HashMap<>();
	private final Map<String, TypedCollection<?>> typedCollections = new HashMap<>();

	public Collection coll(String name) {
		if (!collections.containsKey(name)) {
			collections.put(name, new Collection(this, name));
		}
		return collections.get(name);
	}

	@SuppressWarnings("unchecked")
	public <D extends Data> TypedCollection<D> coll(Class<D> collClass) {
		String name = DataApi.collectionName(collClass);
		if (!typedCollections.containsKey(name)) {
			typedCollections.put(name, new TypedCollection<D>(this, collClass));
		}
		return (TypedCollection<D>) typedCollections.get(name);
	}
}
