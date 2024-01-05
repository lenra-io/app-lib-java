package io.lenra.applibjava.classes;

import io.lenra.api.internal.ApiException;
import io.lenra.api.internal.client.DataApi;

public class Transaction extends AbstractDataApi {
    public Transaction(DataApi api) {
        super(api);
    }

    public void commit() throws ApiException {
        this.getApi().commitTransaction();
    }

    public void abort() throws ApiException {
        this.getApi().abortTransaction();
    }
}
