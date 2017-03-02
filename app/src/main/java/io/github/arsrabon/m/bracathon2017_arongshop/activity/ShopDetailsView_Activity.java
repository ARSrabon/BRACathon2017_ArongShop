package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.github.arsrabon.m.bracathon2017_arongshop.R;

public class ShopDetailsView_Activity extends AppCompatActivity {

    Button btn_takeorder;
    Button btn_viewSalesHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detailsview);

        btn_takeorder = (Button) findViewById(R.id.btn_TakeOrder);


        btn_takeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopDetailsView_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
