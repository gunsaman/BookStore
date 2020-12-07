package fi.haagahelia.bookStore;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import fi.haagahelia.bookStore.domain.User;
import fi.haagahelia.bookStore.domain.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserRepoTest {

	@Autowired
	private UserRepository uRepository;
	
	@Test
	public void createUser() {
		User user = new User("user1", "test123", "test@email.com", "USER");
		uRepository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	
	@Test
	public void deleteUser() {
		User user = uRepository.findByUsername("user");
		
		assertThat(user).isNotNull();
		
		uRepository.delete(user);
		
		assertThat(uRepository.findByUsername("user")).isNull();
	}

}
