package com.paf.socialmedia.dto;

import com.paf.socialmedia.document.Post;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
@Data
public class SharedPostDTO {
    private String id;
    private String caption;
    private String userId;
    private String username;
    private String profileImage;
    private PostDTO post;
    private Date createdAt;
    private Date updatedAt;
}
