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

    StampCard [] all_stampCards;
    ArrayList<JSONObject> stampCards_JSONObjects;

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

    public void addStampCardstoArray() {

        StampCard gym_stampCard = new StampCard("Gym", null, null, null,
                null,null, null, null);

        StampCard run_stampCard = new StampCard("Run", null, null, null,
                null,null, null, null);

        StampCard pushUps_stampCard = new StampCard("Push Ups", null, null, null,
                null,null, null, null);

        StampCard squats_stampCard = new StampCard("Squats", null, null, null,
                null,null, null, null);

        StampCard meditation_stampCard = new StampCard("Meditation", null,
                null, null,
                null,null, null, null);

        StampCard Reading_stampCard = new StampCard("Reading", null,
                null, null,
                null,null, null, null);

        StampCard Journal_stampCard = new StampCard("Journal", null,
                null, null,
                null,null, null, null);

        StampCard Study_stampCard = new StampCard("Study", null,
                null, null,
                null,null, null, null);

        all_stampCards = new StampCard[] {gym_stampCard, run_stampCard, pushUps_stampCard,
                squats_stampCard, meditation_stampCard, Reading_stampCard, Journal_stampCard, Study_stampCard};

    }

    public void convertToJSONObject() throws JSONException {

        for (int i = 0; i < all_stampCards.length; i++) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("habit", all_stampCards[i].habit);
            jsonObject.put("monday_score", all_stampCards[i].monday_score);
            jsonObject.put("tuesday_score", all_stampCards[i].tuesday_score);
            jsonObject.put("wednesday_score", all_stampCards[i].wednesday_score);
            jsonObject.put("thursday_score", all_stampCards[i].thursday_score);
            jsonObject.put("friday_score", all_stampCards[i].friday_score);
            jsonObject.put("saturday_score", all_stampCards[i].saturday_score);
            jsonObject.put("sunday_score", all_stampCards[i].sunday_score);

            stampCards_JSONObjects.add(jsonObject);

        }

    }

    public void createJSONFile(){


    }
}
