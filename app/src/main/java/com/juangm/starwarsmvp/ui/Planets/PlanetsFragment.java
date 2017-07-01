package com.juangm.starwarsmvp.ui.Planets;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juangm.starwarsmvp.R;
import com.juangm.starwarsmvp.data.models.PlanetsResponse;
import com.juangm.starwarsmvp.data.network.StarWarsClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetsFragment extends Fragment {


    public PlanetsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //TODO Just for testing. This must be in the interactor
        StarWarsClient starWarsClient = new StarWarsClient();
        starWarsClient.createStarWarsService().getPlanets().enqueue(new Callback<PlanetsResponse>() {
            @Override
            public void onResponse(Call<PlanetsResponse> call, Response<PlanetsResponse> response) {

            }

            @Override
            public void onFailure(Call<PlanetsResponse> call, Throwable t) {

            }
        });

        return inflater.inflate(R.layout.fragment_planets, container, false);
    }

}
