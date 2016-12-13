package knazanga.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String isbn;
	private String title;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private User owner;
	
	private Book(){
		
	}
	
	public Book(String isbn, String title){
		this.isbn=isbn;
		this.title=title;
	}
	
	public Book(String isbn, String title, User owner){
		this.isbn=isbn;
		this.title=title;
		this.owner=owner;
	}
	
	public Long getId() {
		return id;
	}
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
