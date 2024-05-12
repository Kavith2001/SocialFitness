package com.paf.socialmedia.repository.workout;

import com.paf.socialmedia.document.workout.WorkoutNotification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutNotificationRepository extends MongoRepository<WorkoutNotification, String> {
    List<WorkoutNotification> findByUserIdAndIsReadFalse(String userId);
}
