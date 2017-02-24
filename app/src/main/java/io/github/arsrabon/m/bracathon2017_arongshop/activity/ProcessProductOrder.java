package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ActionBarBadgeCountUpdater;

public class ProcessProductOrder extends AppCompatActivity {

    private ActionBarBadgeCountUpdater countUpdater = ActionBarBadgeCountUpdater.getInstance();
    private Toolbar toolbar;
    Intent intent;
    TextView lbl_productname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processproductorder);
        intent = getIntent();
        countUpdater = ActionBarBadgeCountUpdater.getInstance();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle(intent.getStringExtra("ProductName"));
        setSupportActionBar(toolbar);

        lbl_productname = (TextView) findViewById(R.id.lbl_productname);

        lbl_productname.setText(intent.getStringExtra("ProductName"));
    }
}
