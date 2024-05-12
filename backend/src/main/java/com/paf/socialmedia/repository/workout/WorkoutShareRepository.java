package com.paf.socialmedia.repository.workout;

import com.paf.socialmedia.document.workout.WorkoutShare;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WorkoutShareRepository extends MongoRepository<WorkoutShare, String> {
    List<WorkoutShare> findByUserId(String userId);
}
