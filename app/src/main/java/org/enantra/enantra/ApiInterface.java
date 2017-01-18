package org.enantra.enantra;

/**
 * Created by theMachine on 14-01-2017.
 */
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("allData/user")
    Call<EnantraResponse> getData(@Query("enantraId") Integer eid);
}
