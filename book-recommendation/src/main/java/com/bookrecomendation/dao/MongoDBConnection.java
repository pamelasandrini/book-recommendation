package com.bookrecomendation.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Implement Singleton pattern
 * 
 * @author pborsoni
 *
 */
public class MongoDBConnection {

	private static MongoDatabase db;

	private MongoDBConnection() {

	}

	public static MongoDatabase getConnection() {

		if (db == null) {

			MongoClient mongo = new MongoClient("localhost", 27017);

			db = mongo.getDatabase("bookrecommendation");
		}

		return db;
	}

}
