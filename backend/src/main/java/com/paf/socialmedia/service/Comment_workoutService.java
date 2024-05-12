package com.paf.socialmedia.service;


import com.paf.socialmedia.document.Comment_workout;
import com.paf.socialmedia.repository.Comment_workoutRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Comment_workoutService {
    @Autowired
    private Comment_workoutRepository commentRepository;

    public ResponseEntity<?> getCommentById(String id){
        Optional<Comment_workout> comment =  commentRepository.findById(id);
        if(comment.isPresent()){
            return new ResponseEntity<>(comment.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Comment Found",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> getComments(){
        List<Comment_workout> comments = commentRepository.findAll();
        if(comments.size() > 0){
            return new ResponseEntity<List<Comment_workout>>(comments, HttpStatus.OK);
        }else {
            return new ResponseEntity<List<Comment_workout>>(new ArrayList<>(),HttpStatus.OK);
        }
    }

    public ResponseEntity<?> getCommentsByPost(String postId){
        List<Comment_workout> comments = commentRepository.findByPostId(postId);
        if(comments.size() > 0){
            return new ResponseEntity<List<Comment_workout>>(comments, HttpStatus.OK);
        }else {
            return new ResponseEntity<List<Comment_workout>>(new ArrayList<>(),HttpStatus.OK);
        }
    }

    public ResponseEntity<?> saveComment(Comment_workout comment){
        try{
            comment.setCreatedAt(new Date(System.currentTimeMillis()));
            comment.setUpdatedAt(new Date(System.currentTimeMillis()));
            commentRepository.save(comment);
            return new ResponseEntity<Comment_workout>(comment, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> updateCommentById(String id,Comment_workout comment){
        Optional<Comment_workout> existingComment =  commentRepository.findById(id);
        if(existingComment.isPresent()){
            Comment_workout updateComment = existingComment.get();
            updateComment.setText(comment.getText());
            updateComment.setUpdatedAt(new Date(System.currentTimeMillis()));
            return new ResponseEntity<>(commentRepository.save(updateComment), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Comment Update Error",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> deleteCommentById(String id){
        try{
            commentRepository.deleteById(id);
            return new ResponseEntity<>("Success deleted with " + id,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}

