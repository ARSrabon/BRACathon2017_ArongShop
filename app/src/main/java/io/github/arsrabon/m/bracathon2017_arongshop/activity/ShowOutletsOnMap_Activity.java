package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.model.Route;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ShopDetail;

public class ShowOutletsOnMap_Activity extends FragmentActivity implements OnMapReadyCallback,
        AdapterView.OnItemSelectedListener, Drawer.OnDrawerItemClickListener {

    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    List<Route> routeList;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    Spinner routeSpinner;
    Button btn_visitedList;
    Button btn_notYetVisitedList;
    Button btn_ShopList;
    Button btn_Search;

    Toolbar toolbar;
    AccountHeader headerResult;
    Drawer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showoutletsonmap);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Take Orders");
        setNavDrawer();

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("RoutesAndShops");

        routeSpinner = (Spinner) findViewById(R.id.routeSpinner);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        routeList = new ArrayList<>();
        mapFragment.getMapAsync(this);

        btn_ShopList = (Button) findViewById(R.id.btn_ShowShopsList);
        btn_Search = (Button) findViewById(R.id.btn_SearchShops);
        btn_notYetVisitedList = (Button) findViewById(R.id.btn_ShowNotVisitedYet);
        btn_visitedList = (Button) findViewById(R.id.btn_ShowVisitedShops);

        btn_ShopList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowOutletsOnMap_Activity.this, ShopsList_Activity.class);
                Toast.makeText(ShowOutletsOnMap_Activity.this, "Wait", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ShowOutletsOnMap_Activity.this,MenuActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
//        final LatLng HAMBURG = new LatLng(53.558, 9.927);
//        mMap.addMarker(new MarkerOptions().position(HAMBURG).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG,17.20f));

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    routeList.add(snapshot.getValue(Route.class));
                }

                setRouteSpinner();

//                if (routeList.size() >  0 && mapReady) {
//                    for(Route route : routeList){
//                        for (ShopDetail detail : route.getShopDetailList()){
//                            LatLng latLng = new LatLng(detail.getLatitude(),detail.getLongiude());
//                            MarkerOptions markerOptions = new MarkerOptions().position(latLng).title(detail.getShopName());
//                            mMap.addMarker(markerOptions);
//                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,17.8f));
//                        }
//                    }
//                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void setRouteSpinner() {
        ArrayAdapter<Route> dataAdapter = new ArrayAdapter<Route>(this, R.layout.spinner_item, routeList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        routeSpinner.setAdapter(dataAdapter);
        routeSpinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Route route = routeList.get(position);
        for (ShopDetail detail : route.getShopDetailList()) {
            LatLng latLng = new LatLng(detail.getLatitude(), detail.getLongiude());
            MarkerOptions markerOptions = new MarkerOptions().position(latLng).title(detail.getShopName());
            mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17.5f));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Route route = routeList.get(0);
        for (ShopDetail detail : route.getShopDetailList()) {
            LatLng latLng = new LatLng(detail.getLatitude(), detail.getLongiude());
            MarkerOptions markerOptions = new MarkerOptions().position(latLng).title(detail.getShopName());
            mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17.5f));
        }
    }

    public void setNavDrawer() {
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(new ProfileDrawerItem().withName("Guest")
                        .withEmail("yourofficemail@officeemail.com")
                        .withIcon(getResources().getDrawable(R.drawable.profile2)))
                .build();
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .inflateMenu(R.menu.drawer_menu)
                .build();
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
        result.setOnDrawerItemClickListener(this);
    }

    @Override
    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

        Intent xintent;
        switch ((int) drawerItem.getIdentifier()) {

        }
        return false;
    }

}
