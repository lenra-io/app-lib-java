package io.lenra.applibjava.request;

import io.lenra.api.ManifestSchema;
import io.lenra.applibjava.LenraApplication;

public class ManifestRequest extends AppRequest<ManifestSchema> {

    @Override
    public ManifestSchema handle(LenraApplication application) {
        return application.getManifest();
    }

}
