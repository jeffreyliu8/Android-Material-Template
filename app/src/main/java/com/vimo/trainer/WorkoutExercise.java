package com.vimo.trainer;

/**
 * Created by jeffliu on 11/3/15.
 */
public class WorkoutExercise {
    private String name;
    private int imageId;
    private String description;

    public WorkoutExercise(String name, int imageId, String description) {
        this.name = name;
        this.imageId = imageId;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getDescription() {
        return description;
    }
}
