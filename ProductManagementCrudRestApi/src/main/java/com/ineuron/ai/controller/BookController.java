package com.ineuron.ai.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

import com.ineuron.ai.model.Book;
import com.ineuron.ai.repo.BookRepo;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookRepo bookRepo;

	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		try {
			List<Book> list = new ArrayList<>();
			bookRepo.findAll().forEach(list::add);
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);

			} else {
				return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("getBookById/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		try {
			Optional<Book> book = bookRepo.findById(id);
			if (book.isPresent()) {

				return new ResponseEntity<Book>(book.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/updateBookDetailsById/{id}")
	public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book newBook) {

		try {
			Optional<Book> bOptional = bookRepo.findById(id);
			if (bOptional.isPresent()) {

				Book oldBook = bOptional.get();
				oldBook.setAuthor(newBook.getAuthor());
				oldBook.setTitle(newBook.getTitle());
				Book updatedBook = bookRepo.save(oldBook);
				return new ResponseEntity<Book>(updatedBook, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		try {
			Book book2 = bookRepo.save(book);
			return new ResponseEntity<Book>(book2, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteBookById/{id}")
	public String deleteBookById(@PathVariable Long id) {
		try {

			if (bookRepo.existsById(id)) {
				bookRepo.deleteById(id);
				return "book deleted";

			} else {
				return "book not found.";
			}

		} catch (Exception e) {
			return "Internal Server Error";
		}
	}

}
