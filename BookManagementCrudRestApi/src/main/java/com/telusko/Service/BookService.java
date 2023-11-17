package com.telusko.Service;

import java.util.List;

import com.telusko.Exception.BookNotFoundException;
import com.telusko.Model.Book;

public interface BookService {

	
	public Book getBookById(int id) throws BookNotFoundException;
	public List<Book> getallBooks();
	public String deleteBookById(int id) throws BookNotFoundException;
	public String delteAllBooks();
	Book updateBookDetail(int id, Book newBook) throws BookNotFoundException;
	Book storeBook(Book book);
	
}
