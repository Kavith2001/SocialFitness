package com.paf.socialmedia.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Comment_workoutDTO {
    private String id;
    private String text;
    private String userId;
    private String username;
    private String profileImage;
    private String postId;
    private Date createdAt;
    private Date updatedAt;
}
