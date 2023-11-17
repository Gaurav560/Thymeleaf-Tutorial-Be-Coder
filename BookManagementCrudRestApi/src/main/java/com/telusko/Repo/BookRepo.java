package com.telusko.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.Model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
	

}
