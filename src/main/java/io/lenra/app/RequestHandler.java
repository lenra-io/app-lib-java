package io.lenra.app;

import java.io.IOException;

import io.lenra.api.AppRequest;
import io.lenra.api.ListenerRequest;
import io.lenra.api.Manifest;
import io.lenra.api.ResourceRequest;
import io.lenra.api.ViewRequest;
import io.lenra.app.exception.NotFoundException;
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

	public abstract Object handleView(ViewRequest request);

	public abstract void handleListener(ListenerRequest request);

	public Resource handleResource(ResourceRequest request) {
		String resource = request.getResource();
		var url = getClass().getResource("/assets/" + resource);
		if (url == null) {
			throw new NotFoundException("Resource not found: " + resource);
		}

		try (var stream = url.openStream()) {
			String contentType = url.openConnection().getContentType();
			return new Resource(stream.readAllBytes(), contentType);
		} catch (IOException e) {
			throw new RuntimeException("Failed to read resource: " + resource, e);
		}
	}

	public abstract Manifest handleManifest();

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
