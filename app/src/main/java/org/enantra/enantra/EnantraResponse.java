package org.enantra.enantra;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class EnantraResponse {
    @SerializedName("status")
    private Integer status;
    @SerializedName("error")
    private String error;
    @SerializedName("enantraId")
    private Integer enantraId;
    @SerializedName("details")
    private Details details;
    @SerializedName("tickets")
    private List<Ticket> tickets;
    @SerializedName("workshops")
    private Workshops workshops;
    @SerializedName("brandManager")
    private Boolean brand;
    @SerializedName("miniEvents")
    private Boolean miniEvents;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public Boolean getMiniEvents() {
        return miniEvents;
    }

    public Workshops getWorkshops() {
        return workshops;
    }

    public String getError() {
        return error;
    }

    public Boolean getBrand() {
        return brand;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getEnantraId() {
        return enantraId;
    }

    public Details getDetails() {
        return details;
    }

}
