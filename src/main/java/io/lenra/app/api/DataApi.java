package io.lenra.app.api;

import io.lenra.api.internal.ApiClient;
import io.lenra.api.internal.ApiException;

public class DataApi extends AbstractDataApi {
    private final Api api;

    DataApi(Api api) {
        super(new io.lenra.api.internal.client.DataApi());

        this.api = api;
        this.getApi().setCustomBaseUrl(api.getUrl());
        this.getApi().getApiClient().addDefaultHeader("Authorization", "Bearer " + api.getToken());

    }

    public Transaction startTransaction() throws ApiException {
        String token = this.getApi().createTransaction();
        io.lenra.api.internal.client.DataApi customClient = new io.lenra.api.internal.client.DataApi(new ApiClient());
        customClient.setCustomBaseUrl(api.getUrl());
        customClient.getApiClient().addDefaultHeader("Authorization", "Bearer " + token);

        return new Transaction(customClient);

    }

    public static String dataCollection(Data data) {
        return collectionName(data.getClass());
    }

    public static String collectionName(Class<? extends Data> dataClass) {
        return dataClass.getSimpleName().toLowerCase();
    }
}
