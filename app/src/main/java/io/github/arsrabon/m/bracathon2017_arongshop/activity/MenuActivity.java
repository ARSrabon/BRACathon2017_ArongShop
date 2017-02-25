package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import io.github.arsrabon.m.bracathon2017_arongshop.R;

public class MenuActivity extends AppCompatActivity {

    Button btn_todaysRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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
