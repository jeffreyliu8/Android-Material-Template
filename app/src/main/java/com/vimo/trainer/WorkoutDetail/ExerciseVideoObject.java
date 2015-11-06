package com.vimo.trainer.WorkoutDetail;

/**
 * Created by jeffliu on 11/5/15.
 */
public class ExerciseVideoObject {

    private int mRestTime;
    private String mExerciseName;

    ExerciseVideoObject(String name, int restTime) {
        mExerciseName = name;
        mRestTime = restTime;
    }

    public String getmExerciseName() {
        return mExerciseName;
    }

    public int getRestTime() {
        return mRestTime;
    }
}
