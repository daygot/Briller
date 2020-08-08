package com.goats.briller.main.ui.stats;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.sql.Timestamp;
import java.util.HashMap;

public class StampCard extends JSONObject {

    String habit;
    JSONObject weekday_scores = new JSONObject();
    Timestamp habit_start_time;


    public StampCard(String habit) throws JSONException {

        this.habit = habit;

        this.habit_start_time = null;

        this.weekday_scores.put("Day 1", 0);
        this.weekday_scores.put("Day 2", 0);
        this.weekday_scores.put("Day 3", 0);
        this.weekday_scores.put("Day 4", 0);
        this.weekday_scores.put("Day 5", 0);
        this.weekday_scores.put("Day 6", 0);
        this.weekday_scores.put("Day 7", 0);

    }

    public String getHabit() {
        return habit;
    }

    public JSONObject getWeekday_scores() {
        return weekday_scores;
    }

    public void updateScore(Context context){

        File stampcard_file = new File(context.getFilesDir(), "StampCards.json");


    }



//    public void CompleteDay(String day) throws JSONException {
//        this.weekday_scores.put(day, 1);
//    }

}
