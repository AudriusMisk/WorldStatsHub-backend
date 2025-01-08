package lt.ca.javau11.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.ca.javau11.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{

}
