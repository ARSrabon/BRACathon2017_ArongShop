package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.model.Route;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ShopDetail;

public class ShopDetailsView_Activity extends AppCompatActivity {

    Button btn_takeorder;
    Button btn_viewSalesHistory;
    Button btn_takeSurvey;

    TextView lbl_shopName;
    TextView lbl_shopOwner;
    TextView lbl_shopContact;
    TextView lbl_shopAddress;

    List<ShopDetail> shopDetailList;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    Intent intent;

    ShopDetail shopDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detailsview);
        intent = getIntent();
        final String route = intent.getStringExtra("routeName");
        final String shopname = intent.getStringExtra("ShopName");

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("RoutesAndShops");

        lbl_shopName = (TextView) findViewById(R.id.lbl_ShopName);
        lbl_shopContact = (TextView) findViewById(R.id.lbl_shopContact);
        lbl_shopAddress = (TextView) findViewById(R.id.lbl_ShopAddress);
        lbl_shopOwner = (TextView) findViewById(R.id.lbl_ShopOwnerName);

        lbl_shopOwner.setVisibility(View.GONE);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    if (snapshot.getValue(Route.class).getRouteName().equals(route)){
                        shopDetailList = snapshot.getValue(Route.class).getShopDetailList();
                    }
                }

                for (ShopDetail detail : shopDetailList){
                    if (detail.getKey().equals(shopname)){
                        shopDetail = detail;
                    }
                }

                lbl_shopName.setText(shopDetail.getShopName());
                lbl_shopAddress.setText(shopDetail.getAddress());
                lbl_shopContact.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        btn_takeorder = (Button) findViewById(R.id.btn_TakeOrder);
        btn_takeSurvey = (Button) findViewById(R.id.btn_TakeSurvey);
        btn_viewSalesHistory = (Button) findViewById(R.id.btn_ViewShopsOrderHistory);

//        lbl_shopName =

        btn_takeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopDetailsView_Activity.this, TakeProductsOrder_Activity.class);
                startActivity(intent);
            }
        });

        btn_takeSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopDetailsView_Activity.this, SurveyActivity.class);
                startActivity(intent);
            }
        });

        btn_viewSalesHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
