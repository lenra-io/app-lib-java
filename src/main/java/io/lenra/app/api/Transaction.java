package io.lenra.app.api;

import io.lenra.api.internal.ApiException;
import io.lenra.api.internal.client.DataApi;

public class Transaction extends AbstractDataApi {
    Transaction(DataApi api) {
        super(api);
    }

    public void commit() throws ApiException {
        this.getApi().commitTransaction();
    }

    public void abort() throws ApiException {
        this.getApi().abortTransaction();
    }
}
