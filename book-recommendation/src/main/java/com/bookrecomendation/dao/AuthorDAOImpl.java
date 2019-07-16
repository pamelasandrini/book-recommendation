package com.bookrecomendation.dao;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import com.bookrecomendation.model.Author;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

public class AuthorDAOImpl implements AuthorDAO {

	private MongoDatabase con = MongoDBConnection.getConnection();

	CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
			fromProviders(PojoCodecProvider.builder().automatic(true).build()));

	@Override
	public void saveAuthor(Author author) {

		MongoCollection<Author> collection = con.getCollection("author", Author.class)
				.withCodecRegistry(pojoCodecRegistry);

		collection.insertOne(author);

		System.out.println("author added : " + author.getId());

	}

	@Override
	public void updateAuthor(Author author) {

		MongoCollection<Author> collection = con.getCollection("author", Author.class)
				.withCodecRegistry(pojoCodecRegistry);

		Document query = new Document().append("_id", author.getId());

		Document setData = new Document();
		setData.append("authorName", author.getAuthorName());
		Document update = new Document();
		update.append("$set", setData);

		collection.updateOne(query, update);

		System.out.println("author updated : " + author.getId());

	}

	@Override
	public List<Author> getAllAuthors() {
		List<Author> authorList = new ArrayList<>();

		MongoCollection<Author> collection = con.getCollection("author", Author.class)
				.withCodecRegistry(pojoCodecRegistry);

		FindIterable<Author> find = collection.find(new Document());

		for (Author author : find) {

			authorList.add(author);
		}

		return authorList;

	}

	@Override
	public void deleteAuthor(Author author) {

		MongoCollection<Author> collection = con.getCollection("author", Author.class)
				.withCodecRegistry(pojoCodecRegistry);

		Bson filter = Filters.eq("_id", author.getId());
		DeleteResult deleteResult = collection.deleteOne(filter);

		long deletedCount = deleteResult.getDeletedCount();
		if (deletedCount > 0) {
			System.out.println("author deleted : " + author.getId());
		}
	}

}
