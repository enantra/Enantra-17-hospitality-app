package org.enantra.enantra;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiClient {
    private static final String BASE_URL = "https://register.enantra.org/";
    private static Retrofit retrofit = null;

    private static Gson gson = new GsonBuilder().setLenient().create();

    static Retrofit getClient() {
        if (retrofit == null) {
           retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}