package com.goats.briller.main.ui.stats;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class StampCard {

    String habit;
    Integer monday_score;
    Integer tuesday_score;
    Integer wednesday_score;
    Integer thursday_score;
    Integer friday_score;
    Integer saturday_score;
    Integer sunday_score;


    public StampCard(String habit, Integer monday_score, Integer tuesday_score,
                     Integer wednesday_score, Integer thursday_score, Integer friday_score,
                     Integer saturday_score, Integer sunday_score) {

        this.habit = habit;
        this.monday_score = monday_score;
        this.tuesday_score = tuesday_score;
        this.wednesday_score = wednesday_score;
        this.thursday_score = thursday_score;
        this.friday_score = friday_score;
        this.saturday_score = saturday_score;
        this.sunday_score = sunday_score;


    }

    public String getHabit() {
        return habit;
    }


}
