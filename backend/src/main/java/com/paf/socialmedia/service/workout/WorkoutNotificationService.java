package com.paf.socialmedia.service.workout;

import com.paf.socialmedia.document.workout.WorkoutNotification;
import com.paf.socialmedia.repository.workout.WorkoutNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutNotificationService {
    @Autowired
    private WorkoutNotificationRepository workoutNotificationRepository;

    public ResponseEntity<?> getWorkoutNotificationById(String id){
        Optional<WorkoutNotification> workoutNotification =  workoutNotificationRepository.findById(id);
        if(workoutNotification.isPresent()){
            return new ResponseEntity<>(workoutNotification.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Notification Found",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> getWorkoutNotifications(){
        List<WorkoutNotification> workoutNotification = workoutNotificationRepository.findAll();
        return new ResponseEntity<List<WorkoutNotification>>(workoutNotification, HttpStatus.OK);
    }
    public ResponseEntity<?> getUnreadWorkoutNotificationsByUserId(String userId) {
        List<WorkoutNotification> workoutNotification = workoutNotificationRepository.findByUserIdAndIsReadFalse(userId);
        return new ResponseEntity<List<WorkoutNotification>>(workoutNotification, HttpStatus.OK);
    }
    public ResponseEntity<?> saveWorkoutNotification(WorkoutNotification workoutNotification){
        try{
            workoutNotification.setCreatedAt(new Date(System.currentTimeMillis()));
            workoutNotification.setIsRead(false);
            workoutNotification.setUpdatedAt(new Date(System.currentTimeMillis()));
            workoutNotificationRepository.save(workoutNotification);
            return new ResponseEntity<WorkoutNotification>(workoutNotification, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> updateWorkoutNotificationById(String id,WorkoutNotification workoutNotification){

        Optional<WorkoutNotification> existingNotification =  workoutNotificationRepository.findById(id);
        if(existingNotification.isPresent()){
            WorkoutNotification updateNotification = existingNotification.get();
            if(!workoutNotification.getMessage().isEmpty()) {
                updateNotification.setMessage(workoutNotification.getMessage());
            }

            if(workoutNotification.getIsRead()) {
                updateNotification.setIsRead(workoutNotification.getIsRead());
            }

            updateNotification.setUpdatedAt(new Date(System.currentTimeMillis()));
            return new ResponseEntity<>(workoutNotificationRepository.save(updateNotification), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Comment Update Error",HttpStatus.NOT_FOUND);
        }

    }
    public ResponseEntity<?> deleteWorkoutNotificationById(String id){
        try{
            workoutNotificationRepository.deleteById(id);
            return new ResponseEntity<>("Success deleted with " + id,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}


