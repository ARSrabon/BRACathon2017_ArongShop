package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.model.Route;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ShopDetail;

public class MenuActivity extends AppCompatActivity {

    Button btn_todaysRoute;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference shopReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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

        btn_todaysRoute = (Button) findViewById(R.id.btn_todayRouteMap);

        btn_todaysRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,ShowOutletsOnMap_Activity.class);
                startActivity(intent);
            }
        });
    }
}
