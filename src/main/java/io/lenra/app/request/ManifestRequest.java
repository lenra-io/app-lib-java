package io.lenra.app.request;

import io.lenra.api.ManifestSchema;
import io.lenra.app.LenraApplication;

public class ManifestRequest extends AppRequest<ManifestSchema> {

    @Override
    public ManifestSchema handle(LenraApplication application) {
        return application.getManifest();
    }

}
