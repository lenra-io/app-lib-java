package io.lenra.app.api;

import lombok.Data;

@Data
public class Api {
	String url;
	String token;
	private DataApi data;

	public DataApi data() {
		if (data == null)
			data = new DataApi(this);

		return data;
	}
}
