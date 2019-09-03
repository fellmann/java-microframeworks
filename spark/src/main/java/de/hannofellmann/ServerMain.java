package de.hannofellmann;

import de.hannofellmann.personalizedzip.ZipService;

import static spark.Spark.post;
import static spark.Spark.notFound;
import static spark.Spark.staticFiles;

import java.io.IOException;

public class ServerMain {
	private static ZipService zipService = new ZipService();

	public static void main(String... args) {
		staticFiles.location("/public");

		post("/generate", (req, res) -> {
			String name = req.queryParams("name");

			res.header("connection", "close");
			res.type("application/zip");
			zipService.writePersonalizedZip(name, res.raw().getOutputStream());
			return "";
		});

		notFound((req, res) -> {
			res.redirect("/index.html");
			return "";
		});
	}
}
