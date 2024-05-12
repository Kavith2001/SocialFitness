package com.paf.socialmedia.repository.workout;

import com.paf.socialmedia.document.workout.Workout;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends MongoRepository<Workout,String> {
    List<Workout> findByUserId(String userId);
}
