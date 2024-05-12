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
@Document(collection = "workout_notifications")
public class WorkoutNotification {
    @Id
    private String id;
    private String message;
    private Boolean isRead;
    private String userId;
    private Date createdAt;
    private Date updatedAt;
}
