package me.serol.spark_swagger;

import static spark.Spark.options;

public class OptionsController {
	private static final String AllowHeaders = "Access-Control-Allow-Headers";
	private static final String AllowMethods = "Access-Control-Allow-Methods";
	private static final String OK = "OK";
	private static final String RequestHeaders = "Access-Control-Request-Headers";
	private static final String RequestMethods = "Access-Control-Request-Method";

	public OptionsController() {
		options("/*", (request, response) -> {
			String accessControlRequestHeaders = request.headers(RequestHeaders);
			if (accessControlRequestHeaders != null) {
				response.header(AllowHeaders, accessControlRequestHeaders);
			}

			String accessControlRequestMethod = request.headers(RequestMethods);
			if (accessControlRequestMethod != null) {
				response.header(AllowMethods, accessControlRequestMethod);
			}
			return OK;
		});
	}
}
