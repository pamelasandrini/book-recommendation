package com.bookrecomendation.dao;

import java.util.List;

import com.bookrecomendation.model.Author;

public interface AuthorDAO {

	public void saveAuthor(Author author);

	public void updateAuthor(Author author);

	public List<Author> getAllAuthors();

	public void deleteAuthor(Author author);

}
