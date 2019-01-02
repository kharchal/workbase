package ua.com.hav.workbase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.workbase.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByLoginAndPassword(String login, String password);
}
