package kg.attractor.fexam.repository;

import kg.attractor.fexam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    User findUserByEmail(String email);
    User findUserById(Integer id);
}
