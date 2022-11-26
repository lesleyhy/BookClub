package com.codingdojo.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	// ========== Display =======================
	
	@GetMapping("/books")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		User user = userService.getOne((Long)session.getAttribute("uuid"));
		List<Book>allBook = bookService.getAll();
		
		model.addAttribute("loggedInUser",user);
		model.addAttribute("allBook",allBook);
		
		return "books.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String oneBook(HttpSession session, @PathVariable("id") Long id, Model model) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		User user = userService.getOne((Long)session.getAttribute("uuid"));
		model.addAttribute("loggedInUser",user);
		
		model.addAttribute("book",bookService.getOne(id));

		return "showBook.jsp";
	}
	
	@GetMapping("/books/new")
	public String addBook(HttpSession session, @ModelAttribute("book") Book book) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		return "addBook.jsp";
	}
	
	@GetMapping("/books/edit/{id}")
	public String editBook(HttpSession session, Model model,@PathVariable("id") Long id) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}

		model.addAttribute("book",bookService.getOne(id));
		
		return "editBook.jsp";
	}
	
	// ========== Action ========================
	
	@PostMapping("/book/create")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result,HttpSession session) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			return "addBook.jsp";
		}
		
		User user = userService.getOne((Long)session.getAttribute("uuid"));
		book.setUser(user);
		bookService.save(book);
		
		return "redirect:/books";
	}
	
	@PutMapping("/{id}/update")
	public String update(@Valid @ModelAttribute("book") Book book,BindingResult result, @PathVariable("id") Long id,HttpSession session) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			return "editBook.jsp";
		}
		User user = userService.getOne((Long)session.getAttribute("uuid"));
		Book bookFromDB = bookService.getOne(id);
		if(bookFromDB.getUser().getId() != user.getId()) {
			return "redirect:/books/"+id;
		}
		
		book.setUser(user);
		
		bookService.save(book);
		
		return "redirect:/books/"+id;
	}
	
	
	
	@DeleteMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id,HttpSession session) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		User user = userService.getOne((Long)session.getAttribute("uuid"));
		Book book = bookService.getOne(id);
		if(book.getUser().getId() != user.getId()) {
			return "redirect:/books/"+id;
		}
		bookService.delete(id);
		
		return "redirect:/books";
	}
	
	
}
