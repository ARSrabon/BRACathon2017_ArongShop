package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.github.arsrabon.m.bracathon2017_arongshop.R;

public class ShopDetailsView_Activity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopdetailsview);

        intent = getIntent();
        String shopKey = intent.getStringExtra("Shopkey");

        Log.d("onCreate ",shopKey);

    }
}
