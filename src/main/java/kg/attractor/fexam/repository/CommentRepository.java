package kg.attractor.fexam.repository;

import kg.attractor.fexam.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByPlaceId(Integer placeId);
}
