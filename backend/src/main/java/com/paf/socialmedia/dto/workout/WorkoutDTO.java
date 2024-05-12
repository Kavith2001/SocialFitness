package com.paf.socialmedia.dto.workout;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
// Create workoutdto
public class WorkoutDTO {
    private String id;
    private String userId;
    private String username;
    private String profileImage;
    private List<String> imgLink;
    private String caption;
    private Date createdAt;
    private Date updatedAt;
    private List<String> likedby;
    private List<WorkoutCommentDTO> workoutComments;
}
