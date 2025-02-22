package lt.ca.javau11.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.ca.javau11.entities.Comment;
import lt.ca.javau11.entities.Country;
import lt.ca.javau11.entities.User;
import lt.ca.javau11.repositories.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentsByCountry(Long countryId) {
        Country country = new Country();
        country.setId(countryId); // Or fetch from repository
        return commentRepository.findByCountry(country);
    }

    public Comment addComment(Long userId, Long countryId, String content) {
        Comment comment = new Comment();
        comment.setUser(new User(userId, content, content, null, null)); // Fetch user from repository
        //comment.setCountry(new Country(countryId, content, content, content, countryId, null, null, null)); // Fetch country from repository
        comment.setContent(content);
        comment.setTimestamp(LocalDateTime.now());
        return commentRepository.save(comment);
    }
}
