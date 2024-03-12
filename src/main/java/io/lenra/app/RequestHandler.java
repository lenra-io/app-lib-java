package io.lenra.app;

import java.io.IOException;

import io.lenra.api.AppRequest;
import io.lenra.api.ListenerRequest;
import io.lenra.api.Manifest;
import io.lenra.api.ResourceRequest;
import io.lenra.api.ViewRequest;
import lombok.Getter;

public abstract class RequestHandler {
	public Object handle(AppRequest request) {
		if (request instanceof ViewRequest) {
			return handleView((ViewRequest) request);
		} else if (request instanceof ListenerRequest) {
			handleListener((ListenerRequest) request);
			return null;
		} else if (request instanceof ResourceRequest) {
			return handleResource((ResourceRequest) request);
		} else {
			return handleManifest();
		}
	}

	protected abstract Object handleView(ViewRequest request);

	protected abstract void handleListener(ListenerRequest request);

	protected Resource handleResource(ResourceRequest request) {
		String resource = request.getResource();
		var url = getClass().getResource("/assets/" + resource);
		if (url == null) {
			throw new IllegalArgumentException("Resource not found: " + resource);
		}

		try (var stream = url.openStream()) {
			String contentType = url.openConnection().getContentType();
			return new Resource(stream.readAllBytes(), contentType);
		} catch (IOException e) {
			throw new RuntimeException("Failed to read resource: " + resource, e);
		}
	}

	protected abstract Manifest handleManifest();

	@Getter
	public static class Resource {
		private final byte[] data;
		private final String mimetype;

		Resource(byte[] data, String mimetype) {
			this.data = data;
			this.mimetype = mimetype;
		}
	}
}
