package com.goats.briller.partner;

import android.os.Parcel;
import android.os.Parcelable;

import com.goats.briller.R;

public class Partner implements Parcelable {
    private String type, name;

    public Partner(String type, String name) {
        this.type = type;
        this.name = name;
    }

    protected Partner(Parcel in) {
        type = in.readString();
        name = in.readString();
    }

    public static final Creator<Partner> CREATOR = new Creator<Partner>() {
        @Override
        public Partner createFromParcel(Parcel in) {
            return new Partner(in);
        }

        @Override
        public Partner[] newArray(int size) {
            return new Partner[size];
        }
    };

    public int getPartnerSad() {
        switch (this.type) {
            case "dog":
                return R.drawable.dog_sad;
            case "cat":
                return R.drawable.cat_sad;
            default:
                return 0;
        }
    }

    public int getPartnerHappy() {
        switch (this.type) {
            case "dog":
                return R.drawable.dog_happy;
            case "cat":
                return R.drawable.cat_happy;
            default:
                return 0;
        }
    }

    public int getPartnerIsland() {
        switch (this.type) {
            case "dog":
                return R.drawable.island_dog;
            case "cat":
                return R.drawable.island_cat;
            default:
                return 0;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(name);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
