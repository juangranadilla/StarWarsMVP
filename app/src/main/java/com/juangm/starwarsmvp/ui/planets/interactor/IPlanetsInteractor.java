package com.juangm.starwarsmvp.ui.planets.interactor;

import com.juangm.starwarsmvp.data.models.Planet;

import java.util.ArrayList;

public interface IPlanetsInteractor {
    void onNetworkSuccess(ArrayList<Planet> planets);
    void onNetworkFailure();
}
