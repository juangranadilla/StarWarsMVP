package com.juangm.starwarsmvp.data.network;

import com.juangm.starwarsmvp.data.models.PlanetsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StarWarsService {

    /**
     * Retrieve list of planets
     */
    @GET("planets/")
    Call<PlanetsResponse> getPlanets();

}
