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
import android.widget.TextView;

import com.mikepenz.actionitembadge.library.ActionItemBadge;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
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
import io.github.arsrabon.m.bracathon2017_arongshop.model.Product;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ProductGroup;

public class MainActivity extends AppCompatActivity implements Drawer.OnDrawerItemClickListener {

    Toolbar toolbar;
    TextView textView;
    RecyclerView productGroupView;


    int badgeCount = 0;
    private AccountHeader headerResult;
    private Drawer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setNavDrawer();

        productGroupView = (RecyclerView) findViewById(R.id.productGroupsView);
//        textView = (TextView) findViewById(R.id.shopingCart);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Ghee", "400g", 499.00));
        products.add(new Product("Ghee", "900g", 899.00));

        List<Product> products1 = new ArrayList<>();
        products1.add(new Product("Borhani", "250ml", 30.00));
        products1.add(new Product("Ghee", "500ml", 65.00));
        products1.add(new Product("Ghee", "1000ml", 120.00));


        List<ProductGroup> productGroups = new ArrayList<>();
        productGroups.add(new ProductGroup("Ghee", "Made from full creamed milk.", products));
        productGroups.add(new ProductGroup("Borhani", "Made with sour curd,salt etc.", products1));

        for (int i = 0; i < productGroups.size(); i++) {
            Log.d("ProductGroup", String.valueOf(productGroups.get(i).getProducts().size()));
        }

        setProductGroupsView(productGroups);

    }

    public void setProductGroupsView(List<ProductGroup> productGroups) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        productGroupView.setLayoutManager(linearLayoutManager);

        try {
            ProductGroupAdapter productGroupAdapter = new ProductGroupAdapter(productGroups, MainActivity.this);
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

        ActionItemBadge.update(this, menu.findItem(R.id.item_samplebadge), FontAwesome.Icon.faw_shopping_basket, ActionItemBadge.BadgeStyles.GREY, 0);

        //If you want to add your ActionItem programmatically you can do this too. You do the following:
//        new ActionItemBadgeAdder().act(this).menu(menu).title("").itemDetails(0, R.string.sample, 1).showAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS).add(R.drawable.ic_action_name);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.item_samplebadge) {
            Intent intent = new Intent(MainActivity.this, ShopOrdersConfirmation_Activity.class);
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
