package com.bookrecomendation.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

	public static MongoDatabase getConnection() {
		MongoClient mongo = new MongoClient("localhost", 27017);

		MongoDatabase db = mongo.getDatabase("bookrecommendation");

		return db;
	}

}
