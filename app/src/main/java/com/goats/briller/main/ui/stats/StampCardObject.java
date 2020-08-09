package com.goats.briller.main.ui.stats;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.sql.Timestamp;
import java.util.HashMap;

public class StampCardObject extends JSONObject {

    private String habit;
    private int timer = 0;
    private JSONObject stampcardData = new JSONObject();
    private Timestamp habitStartTime = new Timestamp(System.currentTimeMillis());
    private Boolean started = false;
    private Boolean alarm = false;

    public StampCardObject(String habit) throws JSONException {

        this.habit = habit;

        stampcardData.put("0", 0);
        stampcardData.put("1", 0);
        stampcardData.put("2", 0);
        stampcardData.put("3", 0);
        stampcardData.put("4", 0);
        stampcardData.put("5", 0);
        stampcardData.put("6", 0);
        stampcardData.put("timer", timer);
        stampcardData.put("started", started);
        stampcardData.put("alarm", alarm);
        stampcardData.put("habitStartTime", habitStartTime);

    }

    public String getHabit() {
        return habit;
    }

    public JSONObject getStampcardData() {
        return stampcardData;
    }

}
