package com.example.recipes.ui;

import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.recipes.MainActivity;
import com.example.recipes.R;
import com.example.recipes.Restaurant;
import com.example.recipes.RestaurantAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;


public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<Restaurant> restaurants = new ArrayList<>();
    private NestedScrollView nestedScrollView;
    private BottomSheetBehavior behavior;
    private RestaurantAdapter adapter;
    private ArrayList<String> places = new ArrayList<>();
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        nestedScrollView = view.findViewById(R.id.nested_scroll_view);
        listView = view.findViewById(R.id.lv_places);
        behavior = BottomSheetBehavior.from(nestedScrollView);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        behavior.setHideable(false);
        behavior.setPeekHeight(300);
        listView.setNestedScrollingEnabled(true);

        nestedScrollView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                behavior.setPeekHeight(nestedScrollView.getHeight(), true);
            }
        });

        restaurants.add(new Restaurant("Макдоналдс", new LatLng(55, 35)));
        restaurants.add(new Restaurant("KFC", new LatLng(53, 32)));
        restaurants.add(new Restaurant("Бургер кинг", new LatLng(56, 37)));

        adapter = new RestaurantAdapter(getActivity(), restaurants);
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        for (Restaurant restaurant:restaurants){
            mMap.addMarker(new MarkerOptions().position(restaurant.getLatLng()).title(restaurant.getName()).icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_hamburger)));
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                behavior.setPeekHeight(nestedScrollView.getHeight(), true);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(restaurants.get(position).getLatLng(), 16));
            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 16));
                behavior.setPeekHeight(nestedScrollView.getHeight(), true);
                return false;
            }
        });
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                behavior.setPeekHeight(120, true);
            }
        });
    }

}