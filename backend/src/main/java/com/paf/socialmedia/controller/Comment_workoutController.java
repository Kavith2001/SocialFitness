package com.paf.socialmedia.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.paf.socialmedia.document.Comment_workout;
import com.paf.socialmedia.service.Comment_workoutService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/comments_workouts")
public class Comment_workoutController {
    @Autowired
    private Comment_workoutService commentService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentById(@PathVariable String id){
        return commentService.getCommentById(id);
    }
    @GetMapping
    public ResponseEntity<?> getComments(){
        return commentService.getComments();
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<?> getCommentsByPost(@PathVariable String id){
        return commentService.getCommentsByPost(id);
    }
    @PostMapping
    public ResponseEntity<?> saveComment(@RequestBody Comment_workout comment){
        return commentService.saveComment(comment);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCommentById(@PathVariable String id, @RequestBody Comment_workout comment){
        return  commentService.updateCommentById(id,comment);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCommentById(@PathVariable String id){
        return commentService.deleteCommentById(id);
    }
}

