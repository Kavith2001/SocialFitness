package com.paf.socialmedia.controller.workout;

import com.paf.socialmedia.document.PostShare;
import com.paf.socialmedia.document.workout.WorkoutShare;
import com.paf.socialmedia.service.PostShareService;
import com.paf.socialmedia.service.workout.WorkoutShareService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/workoutshare")
public class WorkoutShareController {
    @Autowired
    private WorkoutShareService workoutShareService;

    @PostMapping
    public ResponseEntity<?> saveWorkout(@RequestBody WorkoutShare workoutShare){
        return workoutShareService.saveWorkout(workoutShare);
    }
    @GetMapping
    public ResponseEntity<?> getWorkouts(){
        return workoutShareService.getWorkouts();
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getsharedWorkoutsByUserId(@PathVariable String id){
        return workoutShareService.getsharedWorkoutsByUserId(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getWorkoutById(@PathVariable String id){
        return workoutShareService.getWorkoutById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateWorkoutById(@PathVariable String id, @RequestBody WorkoutShare workoutShare){
        return  workoutShareService.updateWorkoutById(id,workoutShare);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWorkoutById(@PathVariable String id){
        return workoutShareService.deleteWorkoutById(id);
    }
}

