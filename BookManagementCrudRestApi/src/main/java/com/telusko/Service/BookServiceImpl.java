package com.telusko.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.Exception.BookNotFoundException;
import com.telusko.Model.Book;
import com.telusko.Repo.BookRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;

	@Override
	public Book getBookById(int id) throws BookNotFoundException {
		Optional<Book> bookOptional = bookRepo.findById(id);
		if (bookOptional.isPresent()) {
			return bookOptional.get();

		} else {
			throw new BookNotFoundException("oops! book not found with given id::" + id );
		}
	}

	@Override
	public List<Book> getallBooks() {
		List<Book> allBooks = new ArrayList<>();
		bookRepo.findAll().forEach(allBooks::add);
		return allBooks;
	}

	@Override
	public String deleteBookById(int id) throws BookNotFoundException {
		if (bookRepo.existsById(id)) {
			bookRepo.deleteById(id);
			return "book deleted with given id:: " + id;
		}

		else

		{
			throw new BookNotFoundException("oops! book not found with given id::" + id);
		}

	}

	@Override
	public String delteAllBooks() {

		bookRepo.deleteAll();

		return "all book records deleted";
	}

	@Override
	public Book updateBookDetail(int id, Book newBook) throws BookNotFoundException {
		Optional<Book> bookOptional = bookRepo.findById(id);
		if (bookOptional.isPresent()) {
			Book existingBook = bookOptional.get();
			existingBook.setBookName(newBook.getBookName());
			existingBook.setBookPrice(newBook.getBookPrice());
			existingBook.setBookGenre(newBook.getBookGenre());
			bookRepo.save(existingBook);
			return existingBook;

		} else {
			throw new BookNotFoundException("book not found by id:: " + id);
		}
	}

	@Override
	public Book storeBook(Book book) {
		return bookRepo.save(book);

	}

}
