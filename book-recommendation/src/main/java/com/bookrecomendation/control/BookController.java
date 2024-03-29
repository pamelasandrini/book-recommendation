package com.bookrecomendation.control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.bookrecomendation.dao.BookDAO;
import com.bookrecomendation.dao.BookDAOImpl;
import com.bookrecomendation.model.Book;

@ManagedBean(name = "bookController")
@SessionScoped
public class BookController {

	private Book book;
	private DataModel<Book> bookList;
	private String msg;
	private String buttonAction = "Add";
	private BookDAO bookDao = new BookDAOImpl();

	@PostConstruct
	public void init() {
		book = new Book();

		bookList = getBookList();
	}

	public String addBook() {
		bookDao.saveBook(book);

		setMsg("Inserted successfully!");
		return "add_book_form";
	}

	public String updateBook() {

		bookDao.updateBook(book);

		setMsg("Updated successfully!");
		return "add_book_form";
	}

	public String addForm() {
		book = new Book();
		setButtonAction("Add");

		return "add_book_form";
	}

	public String updateForm() {

		book = bookList.getRowData();

		setButtonAction("Update");

		return "add_book_form";
	}

	public String deleteBook() {

		Book selectedBook = bookList.getRowData();

		bookDao.deleteBook(selectedBook);

		setMsg("Book deleted!");
		return "book_list";
	}

	public String listForm() {
		return "book_list";
	}

	public Book getBook() {
		return book;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getButtonAction() {
		return buttonAction;
	}

	public void setButtonAction(String buttonAction) {
		this.buttonAction = buttonAction;
	}

	public DataModel<Book> getBookList() {
		List<Book> allBooks = bookDao.getAllBooks();

		bookList = new ListDataModel<Book>(allBooks);
		return bookList;
	}

}
