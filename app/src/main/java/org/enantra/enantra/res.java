package org.enantra.enantra;

import com.google.gson.annotations.SerializedName;

/**
 * Created by theMachine on 14-01-2017.
 */
public class res {
    @SerializedName("status")
    String status;
    @SerializedName("error")
    String error;
    @SerializedName("enantraId")
    String enantraId;
    @SerializedName("details")
    details d;
    @SerializedName("events")
    events e;
    @SerializedName("brandManager")
    eve brand;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public eve getBrand() {

        return brand;
    }

    public void setBrand(eve brand) {
        this.brand = brand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnantraId() {
        return enantraId;
    }

    public void setEnantraId(String enantraId) {
        this.enantraId = enantraId;
    }

    public details getD() {
        return d;
    }

    public void setD(details d) {
        this.d = d;
    }

    public events getE() {
        return e;
    }

    public void setE(events e) {
        this.e = e;
    }
}
