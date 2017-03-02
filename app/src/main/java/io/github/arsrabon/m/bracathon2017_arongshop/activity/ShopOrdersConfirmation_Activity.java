package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.adapter.ShoppingCartAdapter;

public class ShopOrdersConfirmation_Activity extends AppCompatActivity {

    RecyclerView salesOrder;
    Button btn_confirm;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopordersconfirmation);
        salesOrder = (RecyclerView) findViewById(R.id.shopOrders);
        btn_confirm = (Button) findViewById(R.id.btn_confirmOrders);
        setRecyclerView();

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("SalesOrders");


        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        salesOrder.setLayoutManager(linearLayoutManager);

        try {
            ShoppingCartAdapter shoppingCartAdapter = new ShoppingCartAdapter(ShopOrdersConfirmation_Activity.this);
            salesOrder.setAdapter(shoppingCartAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
