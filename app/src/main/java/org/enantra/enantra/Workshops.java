package org.enantra.enantra;

import com.google.gson.annotations.SerializedName;

class Workshops {
    @SerializedName("startup")
    private Workshop startup;
    @SerializedName("kids")
    private Workshop kids;
    @SerializedName("abled")
    private Workshop abled;
    @SerializedName("growth")
    private Workshop growth;
    @SerializedName("stocks")
    private Workshop stocks;

    String getStartup() {
        return startup.toString();
    }

    String getKids() {
        return kids.toString();
    }

    String getAbled() {
        return abled.toString();
    }

    String getGrowth() {
        return growth.toString();
    }

    String getStocks() {
        return stocks.toString();
    }
}
