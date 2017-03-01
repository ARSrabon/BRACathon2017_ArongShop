package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.adapter.ShopDetailViewAdapter;
import io.github.arsrabon.m.bracathon2017_arongshop.model.Route;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ShopDetail;

public class ShopsList_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    List<Route> routeList;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    Spinner routeSpinner;
    Button btn_visitedList;
    Button btn_notYetVisitedList;
    Button btn_ShopsOnMap;
    Button btn_Search;
    RecyclerView recyclerShopListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopslist);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("RoutesAndShops");

        routeSpinner = (Spinner) findViewById(R.id.routeSpinner);
        recyclerShopListView = (RecyclerView) findViewById(R.id.recyclerview_shopsList);
        routeList = new ArrayList<>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    routeList.add(snapshot.getValue(Route.class));
                }
                setRouteSpinner();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void setRouteSpinner() {
        ArrayAdapter<Route> dataAdapter = new ArrayAdapter<Route>(this,R.layout.spinner_item,routeList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        routeSpinner.setAdapter(dataAdapter);
        routeSpinner.setOnItemSelectedListener(this);

    }

    public void setShopsListView(List<ShopDetail> shopDetailList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL)
        recyclerShopListView.setLayoutManager(linearLayoutManager);

        try {
            ShopDetailViewAdapter shopDetailViewAdapter = new ShopDetailViewAdapter(shopDetailList, ShopsList_Activity.this);
            recyclerShopListView.setAdapter(shopDetailViewAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Route route = routeList.get(position);
        setShopsListView(route.getShopDetailList());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Route route = routeList.get(0);
        setShopsListView(route.getShopDetailList());
    }
}
