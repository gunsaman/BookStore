package fi.haagahelia.bookStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fi.haagahelia.bookStore.domain.Book;
import fi.haagahelia.bookStore.domain.BookRepository;
import fi.haagahelia.bookStore.domain.Category;
import fi.haagahelia.bookStore.domain.CategoryRepository;
import fi.haagahelia.bookStore.domain.User;
import fi.haagahelia.bookStore.domain.UserRepository;
import fi.haagahelia.bookStore.web.UserDetailServiceImpl;



@SpringBootApplication
public class BookStoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Autowired private UserDetailServiceImpl userDetailsService;
	@Autowired public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder(10));}

	@Bean
	public CommandLineRunner Book(BookRepository brepository, CategoryRepository repository2, UserRepository urepository) {
		return (args) -> {
			
			log.info("save categories  of books");
			repository2.save(new Category("Classics"));
			repository2.save(new Category("Science fiction"));
			repository2.save(new Category("History"));
			
			brepository.save(new Book("hills","john", 2020,"ISBN1", 29, repository2.findByName("Classics").get(0)));
			brepository.save(new Book("rivers","aman", 2020,"ISBN3", 15, repository2.findByName("Science fiction").get(0)));
			
			// Create users: admin/admin user/user
						User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","user1@email.com", "USER");
						User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","user2@email.com", "ADMIN");
						urepository.save(user1);
						urepository.save(user2);
			
			
						
			log.info("fetch all categories");
			for (Category abc : repository2.findAll()) {
				log.info(abc.toString());
			}
		};
		}
		
	
	
}
