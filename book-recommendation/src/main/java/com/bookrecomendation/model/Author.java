package com.bookrecomendation.model;

import org.bson.types.ObjectId;

public class Author {

	private ObjectId id;

	private String authorName;

	public Author() {
	}

	public Author(ObjectId id, String authorName) {
		super();
		this.id = id;
		this.authorName = authorName;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
