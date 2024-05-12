package com.paf.socialmedia.dto;


import lombok.Data;


import java.util.Date;
import java.util.List;

@Data
public class Post_workoutDTO {
    private String id;
    private String userId;
    private String username;
    private String profileImage;
    private List<String> imgLink;
    private String caption;
    private Date createdAt;
    private Date updatedAt;
    private List<String> likedby;
    private List<CommentDTO> comments;
    public void setComment(List<Comment_workoutDTO> commentDTOList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setComment'");
    }
}
