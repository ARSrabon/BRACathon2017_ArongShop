package io.github.arsrabon.m.bracathon2017_arongshop.controller;

import android.app.Activity;
import android.content.Context;
import android.view.MenuItem;

import com.mikepenz.actionitembadge.library.ActionItemBadge;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;

/**
 * Created by msrabon on 2/19/17.
 */
public class ActionBarBadgeCountUpdater {
    private static ActionBarBadgeCountUpdater ourInstance = new ActionBarBadgeCountUpdater();

    public static ActionBarBadgeCountUpdater getInstance() {
        return ourInstance;
    }
    Context context;
    Activity activity;
    int count;
    MenuItem menuItem;

    private ActionBarBadgeCountUpdater() {
    }

    public void initialize(Context context, MenuItem id){
        this.context = context;
        this.activity = (Activity) context;
        this.count = 0;
        this.menuItem = id;
        ActionItemBadge.update(activity, this.menuItem, FontAwesome.Icon.faw_shopping_basket, ActionItemBadge.BadgeStyles.GREY, 0);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void updateItemCount(){
        ActionItemBadge.update(menuItem,count);
    }
}
