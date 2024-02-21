package io.lenra.app.api;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDataApi<D extends Data> {
    public io.lenra.api.internal.client.DataApi api;

    public AbstractDataApi(io.lenra.api.internal.client.DataApi api) {
        this.api = api;
    }

    public io.lenra.api.internal.client.DataApi getApi() {
        return api;
    }

    private final Map<String, Collection> collections = new HashMap<>();
    private final Map<String, TypedCollection<D, Class<D>>> typedCollections = new HashMap<>();

    public Collection coll(String name) {
        if (!collections.containsKey(name)) {
            collections.put(name, new Collection(this, name));
        }
        return collections.get(name);
    }

    public TypedCollection<D, Class<D>> coll(Class<D> collClass) {
        String name = DataApi.collectionName(collClass);
        if (!typedCollections.containsKey(name)) {
            typedCollections.put(name, new TypedCollection<>(this, collClass));
        }
        return typedCollections.get(name);
    }

    public static <T extends Data> T fromJson(Class<T> dataClass, Object data) {
        T result;
        try {
            result = dataClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance of " + dataClass.getName(), e);
        }

        if (data instanceof Map) {
            Map<?, ?> dataMap = (Map<?, ?>) data;
            for (Map.Entry<?, ?> entry : dataMap.entrySet()) {
                String index = entry.getKey().toString();
                if (result instanceof Map && ((Map<?, ?>) result).containsKey(index)) {
                    ((Map<String, Object>) result).put(index, entry.getValue());
                }
            }
        }

        return result;
    }
}
