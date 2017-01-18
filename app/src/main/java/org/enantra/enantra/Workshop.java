package org.enantra.enantra;

import com.google.gson.annotations.SerializedName;

class Workshop {
    @SerializedName("registered")
    private Boolean registered;
    @SerializedName("paid")
    private Boolean paid;
    @SerializedName("paymentID")
    private String payId;

    @Override
    public String toString() {
        if (registered) {
            return "Registered";
        }
        if (payId.equals("none")) {
            return "Not Registered";
        }
        return payId;
    }
}
