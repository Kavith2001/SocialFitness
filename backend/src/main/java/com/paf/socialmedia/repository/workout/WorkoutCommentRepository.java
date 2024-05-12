package com.paf.socialmedia.repository.workout;

import com.paf.socialmedia.document.workout.WorkoutComment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutCommentRepository extends MongoRepository<WorkoutComment, String> {
    List<WorkoutComment> findByWorkoutId(String workoutId);

}