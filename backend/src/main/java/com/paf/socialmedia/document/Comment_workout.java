package com.paf.socialmedia.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "comments_workout")
public class Comment_workout {
    @Id
    private String id;
    private String text;
    private String userId;
    private String postId;
    private Date createdAt;
    private Date updatedAt;
}
