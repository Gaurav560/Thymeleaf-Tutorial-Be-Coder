package com.ineuron.ai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ineuron.ai.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
	

}
