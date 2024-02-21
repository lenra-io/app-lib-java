package io.lenra.app.api;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import io.lenra.api.internal.ApiException;
import io.lenra.api.internal.client.model.DataDocument;
import io.lenra.api.internal.client.model.FindDocumentsRequest;
import io.lenra.api.internal.client.model.UpdateManyDocumentsRequest;
import jakarta.inject.Inject;

public class Collection {
    @Inject
    private ObjectMapper mapper;
    private final AbstractDataApi api;
    private final String name;

    public Collection(AbstractDataApi api, String name) {
        this.api = api;
        this.name = name;
    }

    public DataDocument getDoc(String id) throws ApiException {
        return api.getApi().getDocumentById(this.name, id);
    }

    public DataDocument createDoc(Object doc) throws ApiException {
        return api.getApi().createDocument(this.name, doc);
    }

    public DataDocument updateDoc(Object doc) throws ApiException {
        String json;
        try {
            json = mapper.writeValueAsString(doc);
        } catch (JsonProcessingException e) {
            throw new ApiException(e);
        }

        DataDocument dataDoc = null;
        try {
            dataDoc = DataDocument.fromJson(json);
        } catch (IOException e) {
            throw new ApiException(e);
        }

        return api.getApi().updateDocumentById(this.name, dataDoc.getId(), dataDoc);
    }

    public DataDocument deleteDoc(String id) throws ApiException {
        return api.getApi().deleteDocumentById(this.name, id);
    }

    public List<Map<String, Object>> find(Map<String, Object> query, Map<String, Object> projection)
            throws ApiException {
        FindDocumentsRequest req = new FindDocumentsRequest();
        req.setQuery(query);
        req.setProjection(projection);

        return api.getApi().findDocuments(this.name, req);
    }

    public Object updateMany(Object filter, Object update) throws ApiException {
        UpdateManyDocumentsRequest req = new UpdateManyDocumentsRequest();
        req.setFilter((Map<String, Object>) filter);
        req.setUpdate((Map<String, Object>) update);

        return api.getApi().updateManyDocuments(this.name, req);
    }
}