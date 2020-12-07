package fi.haagahelia.bookStore;


import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.bookStore.domain.Book;
import fi.haagahelia.bookStore.domain.BookRepository;
import fi.haagahelia.bookStore.domain.Category;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookRepoTest {

	@Autowired
	private BookRepository bRepo;
	
	@Test
	public void createNewBook() {
		Book book = new Book("I-Earth", "Anil Lama", 2030, "123456789", 0, new Category("reality"));
		bRepo.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void findBook() {
		List<Book> book = bRepo.findByTitle("Stephen Hawking");
		
		assertThat(book).hasSize(1);
		assertThat(book.get(0).getTitle()).isEqualTo("I-Earth");
	}
	
	@Test
	public void deleteBook() {
		List<Book> book = bRepo.findByTitle("Man");
		
		assertThat(book).hasSize(1);
		
		bRepo.delete(book.get(0));
		
		assertThat(bRepo.findByTitle("Man")).isNullOrEmpty();
	}

}
