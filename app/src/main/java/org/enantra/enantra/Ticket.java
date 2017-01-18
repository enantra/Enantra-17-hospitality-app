package org.enantra.enantra;

import com.google.gson.annotations.SerializedName;

import java.util.Locale;

class Ticket {
    @SerializedName("day")
    private Integer day;
    @SerializedName("fullPackage")
    private Boolean fullPackage;
    @SerializedName("amount")
    private Integer amount;

    @Override
    public String toString() {
        if (this.fullPackage) {
            return "All Talks " + amount;
        }
        return String.format(Locale.ENGLISH, "Day %d : Rs.%d", day, amount);
    }
}
