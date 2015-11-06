package com.vimo.trainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeffliu on 11/3/15.
 */
public class WorkoutCategory {
    private String name;
    private List<WorkoutExercise> exerciseList = new ArrayList<WorkoutExercise>();

    public WorkoutCategory(String name) {
        this.name = name;
    }

    public boolean addExercise(WorkoutExercise exercise) {
        return exerciseList.add(exercise);
    }

    public WorkoutExercise getList(int position){
        return exerciseList.get(position);
    }

    public String getName() {
        return name;
    }
}