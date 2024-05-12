package com.paf.socialmedia.service.workout;

import com.paf.socialmedia.document.User;
import com.paf.socialmedia.document.workout.Workout;
import com.paf.socialmedia.document.workout.WorkoutComment;
import com.paf.socialmedia.dto.workout.WorkoutCommentDTO;
import com.paf.socialmedia.dto.workout.WorkoutDTO;
import com.paf.socialmedia.repository.UserRepository;
import com.paf.socialmedia.repository.workout.WorkoutCommentRepository;
import com.paf.socialmedia.repository.workout.WorkoutRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {
    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private WorkoutCommentRepository workoutCommentRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> getWorkoutById(String id){
        Optional<Workout> workout =  workoutRepository.findById(id);
        if(workout.isPresent()){
            return new ResponseEntity<>(workout.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Workout Found",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> getWorkouts(){
        List<Workout> workouts = workoutRepository.findAll();

        List<WorkoutDTO> workoutDTOList = new ArrayList<>();

        for (Workout workout:workouts) {
            WorkoutDTO workoutDTO = new WorkoutDTO();
            workoutDTO.setId(workout.getId());
            workoutDTO.setCaption(workout.getCaption());
            workoutDTO.setImgLink(workout.getImgLink());
            workoutDTO.setUpdatedAt(workout.getUpdatedAt());
            workoutDTO.setCreatedAt(workout.getCreatedAt());
            workoutDTO.setLikedby(workout.getLikedby());
            workoutDTO.setUserId(workout.getUserId());

            Optional<User> user =  userRepository.findById(workout.getUserId());
            if(user.isPresent()) {
                workoutDTO.setUsername(user.get().getUsername());
                workoutDTO.setProfileImage(user.get().getProfileImage());
            }

            List<WorkoutComment> workoutComments = workoutCommentRepository.findByWorkoutId(workout.getId());
            if(workoutComments.size() > 0){
                List<WorkoutCommentDTO> workoutCommentDTOList = new ArrayList<>();

                for(WorkoutComment workoutComment: workoutComments){
                    WorkoutCommentDTO workoutCommentDTO = new WorkoutCommentDTO();
                    workoutCommentDTO.setId(workoutComment.getId());
                    workoutCommentDTO.setText(workoutComment.getText());
                    workoutCommentDTO.setWorkoutId(workoutComment.getWorkoutId());
                    workoutCommentDTO.setCreatedAt(workoutComment.getCreatedAt());
                    workoutCommentDTO.setUpdatedAt(workoutComment.getUpdatedAt());
                    workoutCommentDTO.setUserId(workoutComment.getUserId());
                    Optional<User> commentedUser =  userRepository.findById(workoutComment.getUserId());
                    if(commentedUser.isPresent()) {
                        workoutCommentDTO.setUsername(commentedUser.get().getUsername());
                        workoutCommentDTO.setProfileImage(commentedUser.get().getProfileImage());
                    }
                    if(commentedUser.isPresent()) {
                        workoutCommentDTOList.add(workoutCommentDTO);
                    }

                }

                workoutDTO.setWorkoutComments(workoutCommentDTOList);
            }
            if(user.isPresent()) {
                workoutDTOList.add(workoutDTO);
            }

        }

        return new ResponseEntity<List<WorkoutDTO>>(workoutDTOList, HttpStatus.OK);
    }

    public ResponseEntity<?> getWorkoutsByUserId(String userId) {
        List<Workout> workouts = workoutRepository.findByUserId(userId);
        List<WorkoutDTO> workoutDTOList = new ArrayList<>();

        for (Workout workout:workouts) {
            WorkoutDTO workoutDTO = new WorkoutDTO();
            workoutDTO.setId(workout.getId());
            workoutDTO.setCaption(workout.getCaption());
            workoutDTO.setImgLink(workout.getImgLink());
            workoutDTO.setUpdatedAt(workout.getUpdatedAt());
            workoutDTO.setCreatedAt(workout.getCreatedAt());
            workoutDTO.setLikedby(workout.getLikedby());
            workoutDTO.setUserId(workout.getUserId());

            Optional<User> user =  userRepository.findById(workout.getUserId());
            if(user.isPresent()) {
                workoutDTO.setUsername(user.get().getUsername());
                workoutDTO.setProfileImage(user.get().getProfileImage());
            }

            List<WorkoutComment> workoutComments = workoutCommentRepository.findByWorkoutId(workout.getId());
            if(workoutComments.size() > 0){
                List<WorkoutCommentDTO> workoutCommentDTOList = new ArrayList<>();

                for(WorkoutComment workoutComment: workoutComments){
                    WorkoutCommentDTO workoutCommentDTO = new WorkoutCommentDTO();
                    workoutCommentDTO.setId(workoutComment.getId());
                    workoutCommentDTO.setText(workoutComment.getText());
                    workoutCommentDTO.setWorkoutId(workoutComment.getWorkoutId());
                    workoutCommentDTO.setCreatedAt(workoutComment.getCreatedAt());
                    workoutCommentDTO.setUpdatedAt(workoutComment.getUpdatedAt());
                    workoutCommentDTO.setUserId(workoutComment.getUserId());
                    Optional<User> commentedUser =  userRepository.findById(workoutComment.getUserId());
                    if(commentedUser.isPresent()) {
                        workoutCommentDTO.setUsername(commentedUser.get().getUsername());
                        workoutCommentDTO.setProfileImage(commentedUser.get().getProfileImage());
                    }
                    if(commentedUser.isPresent()) {
                        workoutCommentDTOList.add(workoutCommentDTO);
                    }

                }

                workoutDTO.setWorkoutComments(workoutCommentDTOList);
            }
            if(user.isPresent()) {
                workoutDTOList.add(workoutDTO);
            }

        }

        return new ResponseEntity<List<WorkoutDTO>>(workoutDTOList, HttpStatus.OK);
    }
    public ResponseEntity<?> saveWorkout(Workout workoutShare){
        try{
            workoutShare.setCreatedAt(new Date(System.currentTimeMillis()));
            workoutShare.setUpdatedAt(new Date(System.currentTimeMillis()));
            workoutRepository.save(workoutShare);
            return new ResponseEntity<Workout>(workoutShare, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> updateWorkoutById(String id,Workout workout){
        Optional<Workout> existingWorkout =  workoutRepository.findById(id);
        if(existingWorkout.isPresent()){
            Workout updateWorkout = existingWorkout.get();
            if(workout.getCaption() != null) {
                updateWorkout.setCaption(workout.getCaption());
            }
            if(workout.getImgLink() != null) {
                updateWorkout.setImgLink(workout.getImgLink());
            }
            updateWorkout.setUpdatedAt(new Date(System.currentTimeMillis()));
            return new ResponseEntity<>(workoutRepository.save(updateWorkout), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Workout Update Error",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> likeWorkoutById(String id,Workout workout){
        Optional<Workout> existingWorkout =  workoutRepository.findById(id);
        if(existingWorkout.isPresent()){
            Workout updateWorkout = existingWorkout.get();
            if(workout.getLikedby() != null) {
                updateWorkout.setLikedby(workout.getLikedby());
            }
            return new ResponseEntity<>(workoutRepository.save(updateWorkout), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Workout Update Error",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> deleteWorkoutById(String id){
        try{
            workoutRepository.deleteById(id);
            return new ResponseEntity<>("Success deleted with " + id,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
