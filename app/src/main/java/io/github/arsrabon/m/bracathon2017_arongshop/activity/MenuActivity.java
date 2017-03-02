package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.MyApplication;
import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.model.Route;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ShopDetail;

public class MenuActivity extends AppCompatActivity implements Drawer.OnDrawerItemClickListener {

    Button btn_todaysRoute;
    Button btn_todaysShoplist;
    Button btn_TakeOrder;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference shopReference;

    Intent intent;

    Toolbar toolbar;
    AccountHeader headerResult;
    Drawer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Take Orders");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setNavDrawer();

        final List<Route> routes;

        firebaseDatabase = FirebaseDatabase.getInstance();
        shopReference = firebaseDatabase.getReference("RoutesAndShops");

//        List<ShopDetail> shopDetailList = new ArrayList<>();
//
//        shopDetailList.add(new ShopDetail("CP Fried Chicken","Biruttam AK khandokar RD,Dhaka",23.780493, 90.405618,false));
//        shopDetailList.add(new ShopDetail("Cinemon Restaurant ","Biruttam AK khandokar RD,Dhaka",23.780247, 90.406832,false));
//        shopDetailList.add(new ShopDetail("Cafe Bismillah","Biruttam AK khandokar RD,Dhaka",23.779895, 90.406865,false));
//        shopDetailList.add(new ShopDetail("Salma Hotel & Restaurant","Biruttam AK khandokar RD,Dhaka",23.779755, 90.407674,false));
//        shopDetailList.add(new ShopDetail("Allahar dan biriani restaurant","Biruttam AK khandokar RD,Dhaka",23.779788, 90.407502,false));
//        shopDetailList.add(new ShopDetail("Bite Buzz","Biruttam AK khandokar RD,Dhaka",23.780513, 90.406951,false));
//        shopDetailList.add(new ShopDetail("Ariston","Biruttam AK khandokar RD,Dhaka",23.780788, 90.406976,false));
//
//        Route route = new Route("Biruttam AK khandokar RD,Dhaka",shopDetailList);
//
//        shopReference.push().setValue(route);


//        routes = new ArrayList<>();
//        shopReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    routes.add(snapshot.getValue(Route.class));
//                }
//                dataReady = true;
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        btn_todaysRoute = (Button) findViewById(R.id.btn_todayRouteMap);
        btn_todaysShoplist = (Button) findViewById(R.id.btn_shopsList);
        btn_TakeOrder = (Button) findViewById(R.id.btn_TakeOrder);

        btn_todaysRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MenuActivity.this, ShowOutletsOnMap_Activity.class);
                startActivity(intent);
//                if (dataReady){
//                    intent.putExtra("routes",gson.toJson(routes));
//                    startActivity(intent);
//                }else {
//                    Toast.makeText(MenuActivity.this, "Please Wait Map data is downloading.", Toast.LENGTH_SHORT).show();
//                }

            }
        });

        btn_todaysShoplist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MenuActivity.this,ShopsList_Activity.class);
                startActivity(intent);
            }
        });

        btn_TakeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,TakeOrder_Activity.class);
                startActivity(intent);
                finish();
            }
        });
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
