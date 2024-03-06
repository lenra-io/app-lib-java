package io.lenra.app;

import io.lenra.api.ViewRequest;

public abstract class RequestHandler {
	public abstract Object handleView(ViewRequest request);
	
}
