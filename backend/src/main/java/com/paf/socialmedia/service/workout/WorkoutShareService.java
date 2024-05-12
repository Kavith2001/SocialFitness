package com.paf.socialmedia.service.workout;

import com.paf.socialmedia.document.User;
import com.paf.socialmedia.document.workout.Workout;
import com.paf.socialmedia.document.workout.WorkoutShare;
import com.paf.socialmedia.dto.workout.WorkoutDTO;
import com.paf.socialmedia.dto.workout.WorkoutShareDTO;
import com.paf.socialmedia.repository.UserRepository;
import com.paf.socialmedia.repository.workout.WorkoutRepository;
import com.paf.socialmedia.repository.workout.WorkoutShareRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutShareService {

    @Autowired
    private WorkoutShareRepository workoutShareRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WorkoutRepository workoutRepository;
    public ResponseEntity<?> getWorkoutById(String id){
        Optional<WorkoutShare> workout =  workoutShareRepository.findById(id);
        if(workout.isPresent()){
            return new ResponseEntity<>(workout.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Workout Found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> getWorkouts(){
        List<WorkoutShare> workoutNotifications = workoutShareRepository.findAll();
        return new ResponseEntity<List<WorkoutShare>>(workoutNotifications, HttpStatus.OK);
    }

    public ResponseEntity<?> getsharedWorkoutsByUserId(String userId) {
        List<WorkoutShare> sharedWorkouts = workoutShareRepository.findByUserId(userId);
        List<WorkoutShareDTO> sharedWorkoutDTOList = new ArrayList<>();

        for (WorkoutShare workoutShare:sharedWorkouts) {
            WorkoutShareDTO workoutShareDTO = new WorkoutShareDTO();
            workoutShareDTO.setId(workoutShare.getId());
            workoutShareDTO.setCaption(workoutShare.getCaption());
            workoutShareDTO.setUpdatedAt(workoutShare.getUpdatedAt());
            workoutShareDTO.setCreatedAt(workoutShare.getCreatedAt());
            workoutShareDTO.setUserId(workoutShare.getUserId());

            Optional<User> user =  userRepository.findById(workoutShare.getUserId());
            if(user.isPresent()) {
                workoutShareDTO.setUsername(user.get().getUsername());
                workoutShareDTO.setProfileImage(user.get().getProfileImage());
            }

            WorkoutDTO workoutDTO = new WorkoutDTO();
            Optional<Workout> workout =  workoutRepository.findById(workoutShare.getWorkout().getId());
            System.out.println("postshare.getPost().getId()" + workoutShare.getWorkout().getId());
            if(workout.isPresent()) {
                System.out.println("post.isPresent()" + workout.get().getId());
                workoutDTO.setId(workout.get().getId());
                workoutDTO.setCaption(workout.get().getCaption());
                workoutDTO.setImgLink(workout.get().getImgLink());
                workoutDTO.setUpdatedAt(workout.get().getUpdatedAt());
                workoutDTO.setCreatedAt(workout.get().getCreatedAt());
                workoutDTO.setUserId(workout.get().getUserId());

                Optional<User> workoutUser =  userRepository.findById(workout.get().getUserId());
                if(workoutUser.isPresent()) {
                    workoutDTO.setUsername(workoutUser.get().getUsername());
                    workoutDTO.setProfileImage(workoutUser.get().getProfileImage());
                }else{
                    workoutDTO.setUsername("Unavailable");
                }
                workoutShareDTO.setWorkout(workoutDTO);
            }


            sharedWorkoutDTOList.add(workoutShareDTO);
        }

        return new ResponseEntity<>(sharedWorkoutDTOList, HttpStatus.OK);
    }

    public ResponseEntity<?> saveWorkout(WorkoutShare workoutShare){
        try{
            workoutShare.setCreatedAt(new Date(System.currentTimeMillis()));
            workoutShare.setUpdatedAt(new Date(System.currentTimeMillis()));
            workoutShareRepository.save(workoutShare);
            return new ResponseEntity<WorkoutShare>(workoutShare, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> updateWorkoutById(String id,WorkoutShare workoutShare){
        Optional<WorkoutShare> existingWorkout =  workoutShareRepository.findById(id);
        if(existingWorkout.isPresent()){
            WorkoutShare updateWorkout = existingWorkout.get();
            if(workoutShare.getCaption() != null) {
                updateWorkout.setCaption(workoutShare.getCaption());
            }
            updateWorkout.setUpdatedAt(new Date(System.currentTimeMillis()));
            return new ResponseEntity<>(workoutShareRepository.save(updateWorkout), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Shared Workout Update Error",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteWorkoutById(String id){
        try{
            workoutShareRepository.deleteById(id);
            return new ResponseEntity<>("Success deleted with " + id,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
