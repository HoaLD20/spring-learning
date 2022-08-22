package hoald.co.crud;

import hoald.co.crud.user.User;
import hoald.co.crud.user.UsersRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UsersRepositoryTest {
    @Autowired
    private UsersRepository repo;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("olala@gmail.com");
        user.setPassword("123");
        user.setLastname("huhu");
        user.setFirstname("hoho");
        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAll() {
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void updateUser(){
        Integer userId = 1;
        User optionalUser = repo.findById(userId).get();
        optionalUser.setFirstname("hoaleduc");
        repo.save(optionalUser);
        User userUpdate = repo.findById(userId).get();
        Assertions.assertThat(userUpdate.getFirstname()).isEqualTo("hoaleduc");
    }
    @Test
    public void testGet(){
        Integer id = 3;
        Optional<User> userOptional = repo.findById(id);
        Assertions.assertThat(userOptional).isPresent();
        System.out.println(userOptional.get());
    }

    @Test
    public void testDelete(){
        Integer id = 3;
        repo.deleteById(id);
        Optional<User> userOptional = repo.findById(id);
        Assertions.assertThat(userOptional).isNotPresent();
    }

}
