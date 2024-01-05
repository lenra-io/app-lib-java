package io.lenra.app.classes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import io.lenra.api.internal.ApiException;
import io.lenra.api.internal.client.model.DataDocument;
import io.lenra.api.internal.client.model.FindDocumentsRequest;
import io.lenra.api.internal.client.model.UpdateManyDocumentsRequest;

public class Collection {
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
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(doc, LinkedTreeMap.class);

        DataDocument dataDoc = null;
        try {
            dataDoc = DataDocument.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return api.getApi().updateDocumentById(this.name, dataDoc.getId(), dataDoc);
    }

    public DataDocument deleteDoc(String id) throws ApiException {
        return api.getApi().deleteDocumentById(this.name, id);
    }

    public List<Map<String, Object>> find(Map<String, Object> query, Map<String, Object> projection) throws ApiException {
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