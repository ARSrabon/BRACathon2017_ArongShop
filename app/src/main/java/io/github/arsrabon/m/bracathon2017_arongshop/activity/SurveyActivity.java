package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.model.BrandSurvey;

public class SurveyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner brand_spinner;
    ImageView imageView;

    List<BrandSurvey> brandSurveys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        brand_spinner = (Spinner) findViewById(R.id.brand_spinner);
        imageView = (ImageView) findViewById(R.id.img_survey);
        brandSurveys = new ArrayList<>();

        brandSurveys.add(new BrandSurvey("Milk Vita", R.drawable.s1));
        brandSurveys.add(new BrandSurvey("Arla", R.drawable.s2));
//        brandSurveys.add(new BrandSurvey("Shape Up", R.drawable.s3));
        setRouteSpinner();

    }

    public void setRouteSpinner() {
        ArrayAdapter<BrandSurvey> dataAdapter = new ArrayAdapter<BrandSurvey>(this, R.layout.spinner_item, brandSurveys);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brand_spinner.setAdapter(dataAdapter);
        brand_spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        imageView.setImageResource(brandSurveys.get(position).getImg_id());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        imageView.setImageResource(brandSurveys.get(0).getImg_id());
    }
}
