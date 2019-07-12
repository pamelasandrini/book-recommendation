package com.bookrecomendation.dao;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import com.bookrecomendation.model.Book;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

public class BookDAOImpl implements BookDAO {

	private MongoDatabase con = MongoDBConnection.getConnection();

	CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
			fromProviders(PojoCodecProvider.builder().automatic(true).build()));

	@Override
	public void saveBook(Book book) {

		MongoCollection<Book> collection = con.getCollection("book", Book.class).withCodecRegistry(pojoCodecRegistry);

		collection.insertOne(book);

		System.out.println("book added : " + book.getId());

	}

	@Override
	public void updateBook(Book book) {

		MongoCollection<Book> collection = con.getCollection("book", Book.class).withCodecRegistry(pojoCodecRegistry);

		Document query = new Document().append("_id", book.getId());

		Document setData = new Document();
		setData.append("title", book.getTitle()).append("author", book.getAuthor()).append("rating", book.getRating())
				.append("category", book.getCategory());
		Document update = new Document();
		update.append("$set", setData);

		collection.updateOne(query, update);

		System.out.println("book updated : " + book.getId());

	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<>();

		MongoCollection<Book> collection = con.getCollection("book", Book.class).withCodecRegistry(pojoCodecRegistry);

		FindIterable<Book> find = collection.find(new Document());

		for (Book book : find) {

			bookList.add(book);
		}

		return bookList;

	}

	@Override
	public void deleteBook(Book book) {

		MongoCollection<Book> collection = con.getCollection("book", Book.class).withCodecRegistry(pojoCodecRegistry);

		Bson filter = Filters.eq("_id", book.getId());
		DeleteResult deleteResult = collection.deleteOne(filter);

		long deletedCount = deleteResult.getDeletedCount();
		if (deletedCount > 0) {
			System.out.println("book deleted : " + book.getId());
		}
	}

}
