package io.lenra.app.api;

import java.util.List;
import java.util.Map;

import io.lenra.api.internal.ApiException;
import io.lenra.api.internal.client.model.DataOptions;
import io.lenra.api.internal.client.model.FindDocumentsRequest;
import io.lenra.api.internal.client.model.UpdateManyDocumentsRequest;

abstract class AbstractCollection<T> {
	private final AbstractDataApi api;
	private final String name;

	AbstractCollection(AbstractDataApi api, String name) {
		this.api = api;
		this.name = name;
	}

	protected abstract T mapTo(Map<String, Object> data);

	protected abstract Map<String, Object> mapFrom(T object);

	protected abstract String getId(T object);

	public T getDoc(String id) throws ApiException {
		return mapTo(api.getApi().getDocumentById(this.name, id));
	}

	public T createDoc(T doc) throws ApiException {
		return mapTo(api.getApi().createDocument(this.name, mapFrom(doc)));
	}

	public T updateDoc(T doc) throws ApiException {
		return mapTo(api.getApi().updateDocumentById(this.name, getId(doc), mapFrom(doc)));
	}

	public T deleteDoc(T doc) throws ApiException {
		return mapTo(api.getApi().deleteDocumentById(this.name, getId(doc)));
	}

	public List<T> find(Map<String, Object> query) throws ApiException {
		return find(query, null, null);
	}

	public List<T> find(Map<String, Object> query, Map<String, Object> projection) throws ApiException {
		return find(query, projection, null);
	}

	public List<T> find(Map<String, Object> query, DataOptions options) throws ApiException {
		return find(query, null, options);
	}

	public List<T> find(Map<String, Object> query, Map<String, Object> projection, DataOptions options)
			throws ApiException {
		FindDocumentsRequest req = new FindDocumentsRequest();
		req.setQuery(query);
		if (projection != null)
			req.setProjection(projection);
		if (options != null)
			req.setOptions(options);

		return api.getApi().findDocuments(this.name, req).stream().map(data -> mapTo(data)).toList();
	}

	public Object updateMany(Map<String, Object> filter, Map<String, Object> update) throws ApiException {
		UpdateManyDocumentsRequest req = new UpdateManyDocumentsRequest();
		req.setFilter((Map<String, Object>) filter);
		req.setUpdate((Map<String, Object>) update);

		return api.getApi().updateManyDocuments(this.name, req);
	}
}
