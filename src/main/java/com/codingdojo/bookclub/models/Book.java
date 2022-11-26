package com.codingdojo.bookclub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "books")
public class Book {
	// ========== Primary Key ===================

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    // ========== Member Variables ==============
    
    @NotNull
    @Size(min = 1, max = 128, message="Field must not be blank")
    private String title;
    
    @NotNull
    @Size(min = 2, max = 128, message="Field must not be blank")
    private String author;
    
    @NotNull
    @Size(min = 2, max = 128, message="Field must not be blank")
    private String thought;
    
 // ========== Data Creation Trackers ========

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // ========== Relationships =================
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id") // convention is SingluarTableName_id
	private User user;
	
	// ========== Constructors ===================
	
	public Book() {};
	
	// ========== Data Creation Event ===========

    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	// ========== Getters and Setters ===========
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getThought() {
		return thought;
	}

	public void setThought(String thought) {
		this.thought = thought;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
	
}

    

