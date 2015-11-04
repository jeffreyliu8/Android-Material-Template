package com.vimo.trainer;

/**
 * Created by jeffliu on 11/3/15.
 */
public class WorkoutExercise {
    private String name;
    private int imageId;

    public WorkoutExercise(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;

    }

    public WorkoutExercise() {
        this.name = "jeff";
        this.imageId = 0;
    }
}
