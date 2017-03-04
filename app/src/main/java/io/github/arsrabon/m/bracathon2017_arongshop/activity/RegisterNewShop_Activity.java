package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import io.github.arsrabon.m.bracathon2017_arongshop.R;

public class RegisterNewShop_Activity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_shop);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RegisterNewShop_Activity.this,MenuActivity.class);
        startActivity(intent);
        finish();
    }
}
