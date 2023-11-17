package com.telusko.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.Exception.BookNotFoundException;
import com.telusko.Model.Book;
import com.telusko.Service.BookServiceImpl;

@RestController
@RequestMapping("/api")
public class HomeController {

	@Autowired
	private BookServiceImpl bookServiceImpl;

	@GetMapping("/getBookById/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id) throws BookNotFoundException {
		return new ResponseEntity<Book>(bookServiceImpl.getBookById(id), HttpStatus.OK);
	}

	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		return new ResponseEntity<List<Book>>(bookServiceImpl.getallBooks(), HttpStatus.OK);

	}

	@PutMapping("/updateBookById/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) throws BookNotFoundException {
		return new ResponseEntity<Book>(bookServiceImpl.updateBookDetail(id, book), HttpStatus.OK);

	}

	@DeleteMapping("/deleteBookById/{id}")
	public String deleteBookById(@PathVariable int id) throws BookNotFoundException {
		return bookServiceImpl.deleteBookById(id);

	}

	@DeleteMapping("/deleteAllBooks")
	public String deleteAllBooks() {
		return bookServiceImpl.delteAllBooks();
	}

	@PostMapping("/createBook")
	public ResponseEntity<Book> bookCreated(@RequestBody Book book) {
		return new ResponseEntity<Book>(bookServiceImpl.storeBook(book), HttpStatus.CREATED);
	}

}
