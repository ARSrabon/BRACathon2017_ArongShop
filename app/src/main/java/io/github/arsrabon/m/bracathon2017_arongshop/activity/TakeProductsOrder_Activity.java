package io.github.arsrabon.m.bracathon2017_arongshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.adapter.ProductGroupAdapter;
import io.github.arsrabon.m.bracathon2017_arongshop.controller.ActionBarBadgeCountUpdater;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ProductGroup;

public class TakeProductsOrder_Activity extends AppCompatActivity implements Drawer.OnDrawerItemClickListener {

    Toolbar toolbar;
    RecyclerView productGroupView;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    List<ProductGroup> productGroups;
    ActionBarBadgeCountUpdater countUpdater;

    AccountHeader headerResult;
    Drawer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takeproductoreder);
        countUpdater = ActionBarBadgeCountUpdater.getInstance();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Take Orders");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setNavDrawer();

        productGroups = new ArrayList<>();

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("ProductGroupedList");

        productGroupView = (RecyclerView) findViewById(R.id.productGroupsView);


//        List<Product> products = new ArrayList<>();
//        products.add(new Product("Ghee","ঘি","900gm","৯০০ গ্রাম",878.00,"৮৭৮ টাকা",false));
//        products.add(new Product("Ghee","ঘি","400gm","৯০০ গ্রাম",415.00,"৪১৫ টাকা",false));
//        products.add(new Product("Ghee","ঘি","200gm","৯০০ গ্রাম",218.00,"২১৮ টাকা",false));
//        products.add(new Product("Ghee","ঘি","100gm","৯০০ গ্রাম",115.00,"১১৫ টাকা",false));
//        products.add(new Product("Ghee","ঘি","60gm","৯০০ গ্রাম",64.00,"৬৪ টাকা",false));
//        products.add(new Product("Ghee","ঘি","30gm","৯০০ গ্রাম",34.00,"৩৪ টাকা",false));
//        products.add(new Product("Ghee","ঘি","15gm","৯০০ গ্রাম",17.00,"১৭ টাকা",false));
//
//        List<Product> products2 = new ArrayList<>();
//        products2.add(new Product("Pasteurized","পাস্তুরিত দুধ","1000 ml","১০০০ মিলি.",65.00,"৬৫ টাকা",false));
//        products2.add(new Product("Pasteurized","পাস্তুরিত দুধ","500 ml","৫০০ মিলি.",35.20,"৩৫.২০ টাকাা",false));
//        products2.add(new Product("Pasteurized","পাস্তুরিত দুধ","250 ml","২৫০ মিলি.",20.00,"২০ টাকা",false));
//        products2.add(new Product("Pasteurized","পাস্তুরিত দুধ","200 ml","২০০ মিলি.",18.00,"১৮ টাকা",false));
//        products2.add(new Product("Pasteurized","লো-ফ্যাট দুধ","500 ml","৫০০ মিলি.",37.00,"১৮ টাকা",false));
//
//        List<Product> products1 = new ArrayList<>();
//        products1.add(new Product("Borhani","বোরহানি","1000 ml","১০০০ মিলি.",105.00,"১০৫ টাকা",false));
//        products1.add(new Product("Borhani","বোরহানি","500 ml","৫০০ মিলি.",55.00,"৫৫ টাকা",false));
//        products1.add(new Product("Borhani","বোরহানি","200 ml","২০০ মিলি.",25.00,"২৫ টাকা",false));
//
//        List<Product> products3 = new ArrayList<>();
//        products3.add(new Product("Laban","লাবান","500 ml","৫০০ মিলি.",55.00,"৫৫ টাকা",false));
//        products3.add(new Product("Laban","লাবান","250 ml","২৫০ মিলি.",25.00,"২৬.৫ টাকা",false));
//
//        productGroups = new ArrayList<>();
//        productGroups.add(new ProductGroup("Pasteurized","পাস্তুরিত দুধ","Made from full creamed milk.","","uht_liquid", products2));
//        productGroups.add(new ProductGroup("Ghee","ঘি","Made from full creamed milk.","","ghee", products));
//        productGroups.add(new ProductGroup("Borhani","বোরহানি","Made with sour curd,salt etc.","","borhani",products1));
//        productGroups.add(new ProductGroup("Laban","লাবান","Made with sour curd,salt etc.","","labang",products3));
//
//        for (ProductGroup group : productGroups) {
//            reference.push().setValue(group);
//        }
//
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    productGroups.add(snapshot.getValue(ProductGroup.class));
                }
                Log.d("progroSize", String.valueOf(productGroups.size()));
                setProductGroupsView(productGroups);
//                cartController.newShoppingCart();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("onCancelled ",databaseError.getMessage());
            }
        });

    }

    public void setProductGroupsView(List<ProductGroup> productGroups) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        productGroupView.setLayoutManager(linearLayoutManager);

        try {
            ProductGroupAdapter productGroupAdapter = new ProductGroupAdapter(productGroups, TakeProductsOrder_Activity.this);
            productGroupView.setAdapter(productGroupAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);

        //you can add some logic (hide it if the count == 0)
//        if (badgeCount > 0) {
//
//        } else {
//            ActionItemBadge.hide(menu.findItem(R.id.item_samplebadge));
//        }
        countUpdater.initialize(TakeProductsOrder_Activity.this, menu.findItem(R.id.item_samplebadge));

        //If you want to add your ActionItem programmatically you can do this too. You do the following:
//        new ActionItemBadgeAdder().act(this).menu(menu).title("").itemDetails(0, R.string.sample, 1).showAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS).add(R.drawable.ic_action_name);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.item_samplebadge) {
            Intent intent = new Intent(TakeProductsOrder_Activity.this, ShopOrdersConfirmation_Activity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void setNavDrawer() {
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(new ProfileDrawerItem().withName("Guest")
                        .withEmail("yourofficemail@officeemail.com")
                        .withIcon(getResources().getDrawable(R.drawable.profile2)))
                .build();
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .inflateMenu(R.menu.drawer_menu)
                .build();
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
        result.setOnDrawerItemClickListener(this);
    }

    @Override
    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

        Intent xintent;
        switch ((int) drawerItem.getIdentifier()) {

        }
        return false;
    }

}
