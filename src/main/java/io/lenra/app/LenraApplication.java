package io.lenra.app;

import java.util.Collections;
import java.util.Map;

import io.lenra.api.ManifestSchema;

public abstract class LenraApplication {
    private final Manifest manifest;
    private final Map<String, ViewHandler<?, ?>> views;
    private final Map<String, ListenerHandler<?>> listeners;

    public LenraApplication() {
        this.manifest = manifest();
        this.views = Collections.unmodifiableMap(views());
        this.listeners = Collections.unmodifiableMap(listeners());
    }

    public ManifestSchema getManifest() {
        return manifest;
    }

    public Map<String, ViewHandler<?, ?>> getViews() {
        return views;
    }

    public Map<String, ListenerHandler<?>> getListeners() {
        return listeners;
    }

    abstract ManifestSchema manifest();
    abstract Map<String, ViewHandler<?, ?>> views();
    abstract Map<String, ListenerHandler<?>> listeners();
}
