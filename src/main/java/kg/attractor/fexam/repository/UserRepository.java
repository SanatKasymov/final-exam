package kg.attractor.fexam.repository;

import kg.attractor.fexam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    User findUserById(Integer id);
    User findUserByEmail(String email);
}
