package io.lenra.app.request;

import io.lenra.app.LenraApplication;
import io.lenra.api.Manifest;

public class ManifestRequest extends AppRequest<Manifest> {

    @Override
    public Manifest handle(LenraApplication application) {
        return application.getManifest();
    }

}
