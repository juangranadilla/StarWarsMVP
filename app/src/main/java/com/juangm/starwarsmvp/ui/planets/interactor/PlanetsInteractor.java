package com.juangm.starwarsmvp.ui.planets.interactor;

import com.juangm.starwarsmvp.data.models.PlanetsResponse;
import com.juangm.starwarsmvp.data.network.StarWarsClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetsInteractor implements Callback<PlanetsResponse> {

    private IPlanetsInteractor listener;
    private StarWarsClient starWarsClient;

    public PlanetsInteractor(IPlanetsInteractor listener) {
        this.listener = listener;
        starWarsClient = new StarWarsClient();
    }

    public void getPlanetsFromServer() {
        starWarsClient.createStarWarsService().getPlanets().enqueue(this);
    }

    @Override
    public void onResponse(Call<PlanetsResponse> call, Response<PlanetsResponse> response) {
        if(response.body().getResults() != null) {
            listener.onNetworkSuccess(response.body().getResults());
        } else {
            listener.onNetworkFailure();
        }
    }

    @Override
    public void onFailure(Call<PlanetsResponse> call, Throwable t) {
        listener.onNetworkFailure();
    }
}
