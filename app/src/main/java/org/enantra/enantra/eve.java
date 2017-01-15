package org.enantra.enantra;

import com.google.gson.annotations.SerializedName;

/**
 * Created by theMachine on 14-01-2017.
 */
public class eve {
    @SerializedName("registered")
    String reg;
    @SerializedName("paid")
    String paid;
    @SerializedName("paymentId")
    String payId;

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }
}
