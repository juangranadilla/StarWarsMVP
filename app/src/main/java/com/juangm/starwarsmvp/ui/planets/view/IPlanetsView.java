package com.juangm.starwarsmvp.ui.planets.view;

import com.juangm.starwarsmvp.data.models.Planet;

import java.util.ArrayList;

public interface IPlanetsView {
    void onPlanetsLoadedSuccess(ArrayList<Planet> planets);
    void onPlanetsLoadedError();
}
