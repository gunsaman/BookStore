package fi.haagahelia.bookStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookStore.domain.Book;
import fi.haagahelia.bookStore.domain.BookRepository;
import fi.haagahelia.bookStore.domain.Category;
import fi.haagahelia.bookStore.domain.CategoryRepository;



@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner Book(BookRepository brepository, CategoryRepository repository2) {
		return (args) -> {
			
			log.info("save categories  of books");
			repository2.save(new Category("Classics"));
			repository2.save(new Category("Science fiction"));
			repository2.save(new Category("History"));
			
			brepository.save(new Book("hills","john", 2020,"ISBN1", 29, repository2.findByName("Classics").get(0)));
			brepository.save(new Book("rivers","aman", 2020,"ISBN3", 15, repository2.findByName("Science fiction").get(0)));
			
				
			
			log.info("fetch all categories");
			for (Category abc : repository2.findAll()) {
				log.info(abc.toString());
			}
		};
		}
		
	
	
}
