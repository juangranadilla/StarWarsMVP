package com.juangm.bottomnavigationmvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.juangm.bottomnavigationmvp.Favorites.FavoritesFragment;
import com.juangm.bottomnavigationmvp.Music.MusicFragment;
import com.juangm.bottomnavigationmvp.Schedules.SchedulesFragment;

public class BottomNavigationActivity extends AppCompatActivity {

    // It seems that BottomNavigationView doesn't work well with ButterKnife
    //@BindView(R.id.bottom_navigation)
    //BottomNavigationView bottomNavigationView;

    FavoritesFragment favoritesFragment;
    SchedulesFragment schedulesFragment;
    MusicFragment musicFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        favoritesFragment = new FavoritesFragment();
        schedulesFragment = new SchedulesFragment();
        musicFragment = new MusicFragment();

        showFragment(favoritesFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorites:
                                showFragment(favoritesFragment);
                                break;
                            case R.id.action_schedules:
                                showFragment(schedulesFragment);
                                break;
                            case R.id.action_music:
                                showFragment(musicFragment);
                                break;
                        }
                        return false;
                    }
                });
    }

    public void showFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.navigation_placeholder, fragment);
        fragmentTransaction.commit();
    }
}
