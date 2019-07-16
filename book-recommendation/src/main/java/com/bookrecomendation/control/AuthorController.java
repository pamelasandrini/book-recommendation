package com.bookrecomendation.control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.bookrecomendation.dao.AuthorDAO;
import com.bookrecomendation.dao.AuthorDAOImpl;
import com.bookrecomendation.model.Author;

@ManagedBean(name = "authorController")
@SessionScoped
public class AuthorController {

	private Author author;
	private DataModel<Author> authorList;
	private String msg;
	private AuthorDAO dao = new AuthorDAOImpl();

	@PostConstruct
	public void init() {
		author = new Author();
		authorList = getAuthorList();
	}

	public DataModel<Author> getAuthorList() {

		List<Author> allAuthors = dao.getAllAuthors();

		authorList = new ListDataModel<Author>(allAuthors);
		return authorList;
	}

	public String listForm() {
		return "author_list";
	}

	public String addForm() {
		author = new Author();
		return "add_author_form";
	}

	public String addAuthor() {
		dao.saveAuthor(author);
		setMsg("Inserted successfully!");

		return addForm();

	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
