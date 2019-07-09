package com.bookrecomendation.control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.bookrecomendation.model.Book;

@ManagedBean(name = "bookController")
@SessionScoped
public class BookController {

	private Book book;
	private DataModel<Book> bookList;
	private String msg;

	private List<Book> myBooks = new ArrayList<>();

	@PostConstruct
	public void init() {
		book = new Book();

		// TODO: move this data to db
		Book b = new Book();
		b.setAuthor("JK Rowling");
		b.setTitle("HP and deathly hallows");
		b.setType("fiction");
		b.setRating(5);
		myBooks.add(b);
	}

	public String addBook() {

		// TODO: add db
//		BookDAO dao = new BookDAOImpl();
//		dao.addBook(book);

		myBooks.add(book);

		setMsg("Inserted successfully!");
		return "add_book_form";
	}

	public String addForm() {
		book = new Book();

		return "add_book_form";
	}

	public String deleteBook() {

		Book b = getBookList().getRowData();
		// TODO: add db
//		BookDAO dao = new BookDAOImpl();
//		dao.deleteBook(b);

		myBooks.remove(b);

		setMsg("Book deleted!");
		return "book_list";
	}

	public String listForm() {
		return "book_list";
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public DataModel<Book> getBookList() {
		bookList = new ListDataModel<Book>(myBooks);
		return bookList;
	}

	public void setBookList(DataModel<Book> bookList) {
		this.bookList = bookList;
	}

	public List<Book> getMyBooks() {
		return myBooks;
	}

}
