package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.github.arsrabon.m.bracathon2017_arongshop.R;

public class ShopDetailsView_Activity extends AppCompatActivity {

    Button btn_takeorder;
    Button btn_viewSalesHistory;
    Button btn_takeSurvey;

    TextView lbl_shopName;
    TextView lbl_shopOwner;
    TextView lbl_shopContact;
    TextView lbl_shopAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detailsview);

        btn_takeorder = (Button) findViewById(R.id.btn_TakeOrder);
        btn_takeSurvey = (Button) findViewById(R.id.btn_TakeSurvey);
        btn_viewSalesHistory = (Button) findViewById(R.id.btn_ViewShopsOrderHistory);

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

            }
        });

        btn_viewSalesHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
