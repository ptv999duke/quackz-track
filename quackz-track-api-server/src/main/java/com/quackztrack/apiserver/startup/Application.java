package com.quackztrack.apiserver.startup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quackztrack.apiserver.controllers.ItemsController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		File configFile = null;
		if (args.length > 1) {
			configFile = new File(args[1]);
		}
		
		else if (configFile == null) {
			String currentDirectory = System.getProperty("user.dir");
			configFile = Paths.get(currentDirectory, "config.json").toFile();
		}
		
		Config config = null;
		try {
			config = mapper.readValue(configFile, Config.class);
		}
		catch (JsonParseException jsonParseException) {
			throw new IOException("The JSON config file is incorrect.", jsonParseException);
		}
		catch (JsonMappingException jsonMappingException) {
			throw new IOException("The JSON config file is incorrect.", jsonMappingException);
		}
		catch (IOException ioException) {
			throw new IOException("Error reading config file", ioException);
		}
		
		SpringApplication application = new SpringApplication(Application.class, 
				MongoServiceConfig.class, 
				PostgresServiceConfig.class,
				ItemsController.class);
		if (config.databaseType == Config.DatabaseType.Mongo) {
			application.setAdditionalProfiles("Mongo");
		}
		else {
			application.setAdditionalProfiles("Postgres");
		}
		
		application.run(args);
	}
}
