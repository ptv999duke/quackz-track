package com.quackztrack.apiserver.startup;


public class Config {

	public enum DatabaseType {
		Mongo, Postgres
	};
	
	public DatabaseType databaseType;
}
