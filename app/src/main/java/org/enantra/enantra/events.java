package org.enantra.enantra;

import com.google.gson.annotations.SerializedName;

/**
 * Created by theMachine on 14-01-2017.
 */
public class events {
    @SerializedName("Street")
    eve Street;
    @SerializedName("SixDegree")
    eve SixDegree;
    @SerializedName("Workshop")
    eve Workshop;
    @SerializedName("Runway")
    eve Runway;


    public eve getStreet() {
        return Street;
    }

    public void setStreet(eve street) {
        Street = street;
    }

    public eve getSixDegree() {
        return SixDegree;
    }

    public void setSixDegree(eve sixDegree) {
        SixDegree = sixDegree;
    }

    public eve getWorkshop() {
        return Workshop;
    }

    public void setWorkshop(eve workshop) {
        Workshop = workshop;
    }

    public eve getRunway() {
        return Runway;
    }

    public void setRunway(eve runway) {
        Runway = runway;
    }


}
