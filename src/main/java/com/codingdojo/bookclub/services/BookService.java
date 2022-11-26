package com.codingdojo.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.repos.BookRepo;

@Service
public class BookService {
	@Autowired
	private BookRepo bookRepo;
	
	// ========== Create / Update ===============

	public Book save(Book b) {
		return bookRepo.save(b);
	}

	// ========== Read ==========================
	
	public List<Book> getAll(){
		return bookRepo.findAll();
	}
	
	public Book getOne(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	// ========== Delete ========================
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}

}
