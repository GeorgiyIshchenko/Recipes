package com.example.recipes;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.example.recipes.ui.DashboardFragment;
import com.example.recipes.ui.HomeFragment;
import com.example.recipes.ui.MapFragment;
import com.example.recipes.ui.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navView;

    //Обработка переключений между экранами
    private BottomNavigationView.OnNavigationItemSelectedListener myItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case (R.id.navigation_profile):
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new ProfileFragment()).commit();
                    break;
                case (R.id.navigation_home):
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragment()).commit();
                    break;
                case (R.id.navigation_dashboard):
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new DashboardFragment()).commit();
                    break;
                case (R.id.navigation_map):
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new MapFragment()).commit();
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(myItemSelectedListener);
        navView.setSelectedItemId(R.id.navigation_home);
    }

}