package com.paf.socialmedia.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.paf.socialmedia.document.Comment_workout;

import java.util.List;

@Repository
public interface Comment_workoutRepository extends MongoRepository<Comment_workout, String> {
    List<Comment_workout> findByPostId(String postId);

}