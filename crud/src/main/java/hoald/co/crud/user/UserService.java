package hoald.co.crud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired private UsersRepository repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }
}
