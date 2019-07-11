package com.bookrecomendation.dao;

import java.util.List;

import com.bookrecomendation.model.Book;

public interface BookDAO {

	public void saveBook(Book book);

	public void updateBook(Book book);

	public List<Book> getAllBooks();

	public void deleteBook(Book book);

}
