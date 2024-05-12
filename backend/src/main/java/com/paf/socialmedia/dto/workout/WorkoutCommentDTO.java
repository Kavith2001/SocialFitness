package com.paf.socialmedia.dto.workout;

import lombok.Data;

import java.util.Date;

@Data
public class WorkoutCommentDTO {
    private String id;
    private String text;
    private String userId;
    private String username;
    private String profileImage;
    private String workoutId;
    private Date createdAt;
    private Date updatedAt;
}
