package com.juangm.starwarsmvp.ui.planets.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juangm.starwarsmvp.R;
import com.juangm.starwarsmvp.data.models.Planet;
import com.juangm.starwarsmvp.ui.planets.presenter.PlanetsPresenter;

import java.util.ArrayList;

public class PlanetsFragment extends Fragment implements IPlanetsView {

    private String TAG = PlanetsFragment.class.getName();
    private PlanetsPresenter planetsPresenter;

    public PlanetsFragment() {
        planetsPresenter = new PlanetsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planets, container, false);

        planetsPresenter.loadPlanets();

        return view;
    }

    @Override
    public void onPlanetsLoadedSuccess(ArrayList<Planet> planets) {
        Log.d(TAG, "Received planets: " + planets.size());
    }

    @Override
    public void onPlanetsLoadedError() {
        Log.d(TAG, "Error receiving planets");
    }
}
