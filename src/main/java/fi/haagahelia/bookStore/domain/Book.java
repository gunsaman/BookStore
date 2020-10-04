package fi.haagahelia.bookStore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class Book {
	@Id
<<<<<<< HEAD
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
=======
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
>>>>>>> 7999b6d6e15348618aaeddb1cd754bc9c423723e
	private String title;
	private String author;
	private int year;
	private String isbn;
<<<<<<< HEAD
	private int price;
	
	@ManyToOne
	@JoinColumn(name ="categoryid")
	private Category category;	
=======
	private double price;
	
>>>>>>> 7999b6d6e15348618aaeddb1cd754bc9c423723e
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	@JsonIgnore
	private Category category;
	public Book() {
		
	}
<<<<<<< HEAD
		
	public Book(String title, String author, int year, String isbn, int price, Category category) {
=======

	

	public Book(String title, String author, int year, String isbn, double price, Category category) {
>>>>>>> 7999b6d6e15348618aaeddb1cd754bc9c423723e
		super();
		
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}

<<<<<<< HEAD
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
=======


	public long getId() {
		return id;
	}

	public void setId(long id) {
>>>>>>> 7999b6d6e15348618aaeddb1cd754bc9c423723e
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	@Override
	public String toString() {
		if(this.category != null) {
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
					+ ", price=" + price + ", category=" + category + "]";
		}
		return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price
		+ "]";
		
	}
	


	
	
	
	
}
