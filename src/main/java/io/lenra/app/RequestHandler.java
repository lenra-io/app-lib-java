package io.lenra.app;

import io.lenra.api.AppRequest;
import io.lenra.api.ListenerRequest;
import io.lenra.api.Manifest;
import io.lenra.api.ManifestRequest;
import io.lenra.api.ResourceRequest;
import io.lenra.api.ViewRequest;
import io.lenra.api.ViewResponse;

public abstract class RequestHandler {
	public Object handle(AppRequest request) {
		if (request instanceof ViewRequest) {
			return handleView((ViewRequest) request);
		} else if (request instanceof ListenerRequest) {
			handleListener((ListenerRequest) request);
			return null;
		} else if (request instanceof ResourceRequest) {
			return handleResource((ResourceRequest) request);
		} else if (request instanceof ManifestRequest) {
			return handleManifest((ManifestRequest) request);
		} else {
			throw new IllegalArgumentException("Unknown request type: " + request.getClass());
		}
	}

	protected abstract ViewResponse handleView(ViewRequest request);

	protected abstract void handleListener(ListenerRequest request);

	protected abstract byte[] handleResource(ResourceRequest request);

	protected abstract Manifest handleManifest(ManifestRequest request);
}
