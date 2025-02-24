package lt.ca.javau11.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lt.ca.javau11.entities.Comment;
import lt.ca.javau11.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/country/{countryId}")
    public List<Comment> getCommentsByCountry(@PathVariable Long countryId) {
        return commentService.getCommentsByCountry(countryId);
    }
}