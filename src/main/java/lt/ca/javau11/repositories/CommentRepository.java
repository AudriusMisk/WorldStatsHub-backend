package lt.ca.javau11.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.ca.javau11.entities.Comment;
import lt.ca.javau11.entities.Country;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{

	List<Comment> findByCountry(Country country);
	
}
