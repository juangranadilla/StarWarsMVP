package com.juangm.starwarsmvp.ui.planets.presenter;

import com.juangm.starwarsmvp.data.models.Planet;
import com.juangm.starwarsmvp.ui.planets.interactor.IPlanetsInteractor;
import com.juangm.starwarsmvp.ui.planets.interactor.PlanetsInteractor;
import com.juangm.starwarsmvp.ui.planets.view.IPlanetsView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlanetsPresenter implements IPlanetsPresenter, IPlanetsInteractor {

    private IPlanetsView view;
    private PlanetsInteractor interactor;

    public PlanetsPresenter(IPlanetsView view) {
        this.view = view;
        this.interactor = new PlanetsInteractor(this);
    }

    @Override
    public void loadPlanets() {
        interactor.getPlanetsFromServer();
    }

    @Override
    public void onNetworkSuccess(List<Planet> planets) {
        Collections.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        view.onPlanetsLoadedSuccess(planets);
    }

    @Override
    public void onNetworkFailure() {
        view.onPlanetsLoadedError();
    }
}
