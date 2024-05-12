package com.paf.socialmedia.service.workout;

import com.paf.socialmedia.document.workout.WorkoutComment;
import com.paf.socialmedia.repository.workout.WorkoutCommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutCommentService {
    @Autowired
    private WorkoutCommentRepository workoutCommentRepository;

    public ResponseEntity<?> getWorkoutCommentById(String id){
        Optional<WorkoutComment> workoutComment =  workoutCommentRepository.findById(id);
        if(workoutComment.isPresent()){
            return new ResponseEntity<>(workoutComment.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Comment Found",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> getWorkoutComments(){
        List<WorkoutComment> workoutComment = workoutCommentRepository.findAll();
        if(workoutComment.size() > 0){
            return new ResponseEntity<List<WorkoutComment>>(workoutComment, HttpStatus.OK);
        }else {
            return new ResponseEntity<List<WorkoutComment>>(new ArrayList<>(),HttpStatus.OK);
        }
    }

    public ResponseEntity<?> getWorkoutCommentsByWorkout(String postId){
        List<WorkoutComment> workoutComment = workoutCommentRepository.findByWorkoutId(postId);
        if(workoutComment.size() > 0){
            return new ResponseEntity<List<WorkoutComment>>(workoutComment, HttpStatus.OK);
        }else {
            return new ResponseEntity<List<WorkoutComment>>(new ArrayList<>(),HttpStatus.OK);
        }
    }

    public ResponseEntity<?> saveWorkoutComment(WorkoutComment workoutComment){
        try{
            workoutComment.setCreatedAt(new Date(System.currentTimeMillis()));
            workoutComment.setUpdatedAt(new Date(System.currentTimeMillis()));
            workoutCommentRepository.save(workoutComment);
            return new ResponseEntity<WorkoutComment>(workoutComment, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> updateWorkoutCommentById(String id,WorkoutComment workoutComment){
        Optional<WorkoutComment> existingComment =  workoutCommentRepository.findById(id);
        if(existingComment.isPresent()){
            WorkoutComment updateComment = existingComment.get();
            updateComment.setText(workoutComment.getText());
            updateComment.setUpdatedAt(new Date(System.currentTimeMillis()));
            return new ResponseEntity<>(workoutCommentRepository.save(updateComment), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Comment Update Error",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> deleteWorkoutCommentById(String id){
        try{
            workoutCommentRepository.deleteById(id);
            return new ResponseEntity<>("Success deleted with " + id,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}

