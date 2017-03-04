package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.adapter.ProductsSkuButtonAdapater;
import io.github.arsrabon.m.bracathon2017_arongshop.controller.ActionBarBadgeCountUpdater;
import io.github.arsrabon.m.bracathon2017_arongshop.model.Product;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ProductGroup;

public class ProcessProductOrder extends AppCompatActivity {

    private ActionBarBadgeCountUpdater countUpdater = ActionBarBadgeCountUpdater.getInstance();
    private Toolbar toolbar;
    Intent intent;
    TextView lbl_productname;
    TextView lbl_productdiscount;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    ProductGroup productGroup;

    RecyclerView recyclerView;

    ImageButton btn_plus;
    ImageButton btn_minus;
    ImageView productView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processproductorder);
        intent = getIntent();
        final String product = intent.getStringExtra("ProductName");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_productsku);
        lbl_productname = (TextView) findViewById(R.id.lbl_productname);
        lbl_productdiscount = (TextView) findViewById(R.id.lbl_showDiscount);

        btn_plus = (ImageButton) findViewById(R.id.btn_plus);
        btn_minus = (ImageButton) findViewById(R.id.btn_minus);
        productView = (ImageView) findViewById(R.id.img_Product);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("ProductGroupedList");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue(ProductGroup.class).getpName().equals(product)) {
                        productGroup = snapshot.getValue(ProductGroup.class);
                    }
                }
                setProductGroupsView(productGroup.getProducts());
                lbl_productname.setText(productGroup.getpNameBng());
                int picId = getResources().getIdentifier(productGroup.getImgLocation(), "drawable", getApplicationContext().getPackageName());
                productView.setImageResource(picId);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void setProductGroupsView(List<Product> productGroups) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getBaseContext(), 4);
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        try {
            ProductsSkuButtonAdapater adapater = new ProductsSkuButtonAdapater(productGroups, ProcessProductOrder.this);
            recyclerView.setAdapter(adapater);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
