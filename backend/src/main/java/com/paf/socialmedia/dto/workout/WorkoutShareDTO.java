package com.paf.socialmedia.dto.workout;

import lombok.Data;

import java.util.Date;
@Data
public class WorkoutShareDTO {
    private String id;
    private String caption;
    private String userId;
    private String username;
    private String profileImage;
    private WorkoutDTO workout;
    private Date createdAt;
    private Date updatedAt;
}
