package me.serol.spark_swagger;

import static spark.Spark.before;
import static spark.Spark.get;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@SwaggerDefinition(host = "localhost:4567", //
info = @Info(description = "DonateAPP API", //
version = "V1.0", //
title = "Some random api for testing", //
contact = @Contact(name = "Serol", url = "https://srlk.github.io") ) , //
schemes = { SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS }, //
consumes = { "application/json" }, //
produces = { "application/json" }, //
tags = { @Tag(name = "swagger") })
public class App {

	public static final String APP_PACKAGE = "me.serol.spark_swagger";

	public static void main(String[] args) {

		try {
			// Quite unsafe!
			before(new CorsFilter());
			new OptionsController();

			// Scan classes with @Api annotation and add as routes
			RouteBuilder.setupRoutes(APP_PACKAGE);

			// Build swagger json description
			final String swaggerJson = SwaggerParser.getSwaggerJson(APP_PACKAGE);
			get("/swagger", (req, res) -> {
				return swaggerJson;
			});

		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

}
