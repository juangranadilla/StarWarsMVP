package com.juangm.starwarsmvp.ui.planets.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.juangm.starwarsmvp.R;
import com.juangm.starwarsmvp.data.models.Planet;
import com.juangm.starwarsmvp.ui.planets.presenter.PlanetsPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetsFragment extends Fragment implements IPlanetsView {

    @BindView(R.id.rv_planets)
    RecyclerView planetsRecyclerView;

    @BindView(R.id.progress_planets)
    ProgressBar progressBar;

    private String TAG = PlanetsFragment.class.getName();
    private PlanetsPresenter planetsPresenter;

    public PlanetsFragment() {
        planetsPresenter = new PlanetsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planets, container, false);

        ButterKnife.bind(this, view);

        planetsPresenter.loadPlanets();

        return view;
    }

    private void setRecyclerAdapter(List<Planet> planets) {
        progressBar.setVisibility(View.GONE);
        planetsRecyclerView.setVisibility(View.VISIBLE);
        PlanetsAdapter planetsAdapter = new PlanetsAdapter(getContext(), planets);
        planetsRecyclerView.setAdapter(planetsAdapter);
        planetsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onPlanetsLoadedSuccess(List<Planet> planets) {
        Log.d(TAG, "Received planets: " + planets.size());
        setRecyclerAdapter(planets);
    }

    @Override
    public void onPlanetsLoadedError() {
        Log.d(TAG, "Error receiving planets");
    }
}
