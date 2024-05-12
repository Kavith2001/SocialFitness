package com.paf.socialmedia.document.workout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "workout_comments")
public class WorkoutComment {
    @Id
    private String id;
    private String text;
    private String userId;
    private String workoutId;
    private Date createdAt;
    private Date updatedAt;
}
