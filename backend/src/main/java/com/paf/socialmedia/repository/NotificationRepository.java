package com.paf.socialmedia.repository;

import com.paf.socialmedia.document.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
    List<Notification> findByUserIdAndIsReadFalse(String userId);
}
