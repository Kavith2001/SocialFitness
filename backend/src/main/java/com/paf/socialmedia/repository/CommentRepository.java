package com.paf.socialmedia.repository;

import com.paf.socialmedia.document.Comment;
import com.paf.socialmedia.document.Comment_workout;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByPostId(String postId);

    Object save(Comment_workout updateComment);

}