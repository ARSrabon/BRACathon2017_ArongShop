package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

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
import io.github.arsrabon.m.bracathon2017_arongshop.adapter.ShopDetailViewAdapter;
import io.github.arsrabon.m.bracathon2017_arongshop.model.Route;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ShopDetail;

public class ShopsList_Activity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener, Drawer.OnDrawerItemClickListener {

    List<Route> routeList;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    Spinner routeSpinner;
    Button btn_visitedList;
    Button btn_notYetVisitedList;
    Button btn_ShopsOnMap;
    ImageButton btn_Search;

    ImageButton btn_newShop;

    RecyclerView recyclerShopListView;

    Toolbar toolbar;
    AccountHeader headerResult;
    Drawer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopslist);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Take Orders");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setNavDrawer();


        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("RoutesAndShops");

        routeSpinner = (Spinner) findViewById(R.id.routeSpinner);
        recyclerShopListView = (RecyclerView) findViewById(R.id.recyclerview_shopsList);

        btn_newShop = (ImageButton) findViewById(R.id.btn_addnewshop);

        btn_ShopsOnMap = (Button) findViewById(R.id.btn_ShowShopsOnMap);

        routeList = new ArrayList<>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    routeList.add(snapshot.getValue(Route.class));
                }
                setRouteSpinner();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btn_ShopsOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopsList_Activity.this, ShowOutletsOnMap_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_newShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopsList_Activity.this, RegisterNewShop_Activity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ShopsList_Activity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    public void setRouteSpinner() {
        ArrayAdapter<Route> dataAdapter = new ArrayAdapter<Route>(this, R.layout.spinner_item, routeList);
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
