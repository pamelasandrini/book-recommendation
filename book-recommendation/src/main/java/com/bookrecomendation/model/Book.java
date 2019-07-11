package com.bookrecomendation.model;

import org.bson.types.ObjectId;

public class Book {

	private ObjectId id;

	private String title;

	private int rating;

	// TODO: add table
	private String author;

	private String category;

	public Book() {
	}

	public Book(ObjectId id, String title, int rating, String author, String category) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.author = author;
		this.category = category;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", rating=" + rating + ", author=" + author + ", type="
				+ category + "]";
	}

}
