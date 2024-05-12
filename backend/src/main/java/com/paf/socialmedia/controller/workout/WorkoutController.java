package com.paf.socialmedia.controller.workout;

import com.paf.socialmedia.document.workout.Workout;
import com.paf.socialmedia.service.workout.WorkoutService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @PostMapping
    public ResponseEntity<?> saveWorkout(@RequestBody Workout workout){
        return workoutService.saveWorkout(workout);
    }
    @GetMapping
    public ResponseEntity<?> getWorkouts(){
        return workoutService.getWorkouts();
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getWorkoutsByUserId(@PathVariable String id){
        return workoutService.getWorkoutsByUserId(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getWorkoutById(@PathVariable String id){
        return workoutService.getWorkoutById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateWorkoutById(@PathVariable String id, @RequestBody Workout workout){
        return  workoutService.updateWorkoutById(id,workout);
    }
    @PutMapping("/like/{id}")
    public ResponseEntity<?> likeWorkoutById(@PathVariable String id, @RequestBody Workout workout){
        return  workoutService.likeWorkoutById(id,workout);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWorkoutById(@PathVariable String id){
        return workoutService.deleteWorkoutById(id);
    }
}

