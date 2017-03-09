package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.model.Product;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ProductGroup;

public class ProductShow_Activity extends AppCompatActivity {

    RecyclerView view;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    List<ProductGroup> productGroups;

    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_show);

        view = (RecyclerView) findViewById(R.id.view_products);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("ProductGroupedList");

        productGroups = new ArrayList<>();
        products = new ArrayList<>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    productGroups.add(snapshot.getValue(ProductGroup.class));
                }

                for(ProductGroup group : productGroups){
                    products.add(new Product());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
