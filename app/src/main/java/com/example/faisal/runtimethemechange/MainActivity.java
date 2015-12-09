package com.example.faisal.runtimethemechange;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
        setUpToolBar();
        markMenuItemCheck();


        navigationView.setNavigationItemSelectedListener(navigationItemSelecter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.coordinator), "I'm a Snackbar", Snackbar.LENGTH_LONG).setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Snackbar Action", Toast.LENGTH_LONG).show();
                    }
                }).show();
            }
        });
    }

    private void markMenuItemCheck() {
        SharedPreferences sharedPreferences=getSharedPreferences(AppConstent.APP_THEME, Context.MODE_PRIVATE);
        switch(sharedPreferences.getInt(AppConstent.APP_THEME_SELECTION, AppConstent.THEME_DEFAULT)) {
            case AppConstent.THEME_ONE:
                navigationView.getMenu().getItem(0).setChecked(true);
                break;
            case AppConstent.THEME_TWO:
                navigationView.getMenu().getItem(1).setChecked(true);
                break;
            case AppConstent.THEME_THREE:
                navigationView.getMenu().getItem(2).setChecked(true);
                break;
            case AppConstent.THEME_FOUR:
                navigationView.getMenu().getItem(3).setChecked(true);
                break;
            case AppConstent.THEME_FIVE:
                navigationView.getMenu().getItem(4).setChecked(true);
                break;
            default:
                navigationView.getMenu().getItem(0).setChecked(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * listener for navigation drawer
     */
    NavigationView.OnNavigationItemSelectedListener navigationItemSelecter=new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            menuItem.setChecked(true);
            mDrawerLayout.closeDrawers();
            switch(menuItem.getItemId()){
                case R.id.navigation_theme_one:
                    callAppropriateCode(AppConstent.themSet.ONE);
                    break;

                case R.id.navigation_theme_two:
                    callAppropriateCode(AppConstent.themSet.TWO);
                    break;

                case R.id.navigation_theme_three:
                    callAppropriateCode(AppConstent.themSet.THREE);
                    finish();
                    break;

                case R.id.navigation_theme_four:
                    callAppropriateCode(AppConstent.themSet.FOUR);
                    break;

                case R.id.navigation_theme_five:
                    callAppropriateCode(AppConstent.themSet.FIVE);
                    break;
            }
            return true;
        }
    };

    private void callAppropriateCode(AppConstent.themSet value) {
        Toast.makeText(MainActivity.this, value.toString(), Toast.LENGTH_LONG).show();
        SharedPreferences sharedPreferences=getSharedPreferences(AppConstent.APP_THEME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch(value){
            case ONE:
                editor.putInt(AppConstent.APP_THEME_SELECTION, AppConstent.THEME_ONE);
                break;
            case TWO:
                editor.putInt(AppConstent.APP_THEME_SELECTION, AppConstent.THEME_TWO);
                break;
            case THREE:
                editor.putInt(AppConstent.APP_THEME_SELECTION, AppConstent.THEME_THREE);
                break;
            case FOUR:
                editor.putInt(AppConstent.APP_THEME_SELECTION, AppConstent.THEME_FOUR);
                break;
            case FIVE:
                editor.putInt(AppConstent.APP_THEME_SELECTION, AppConstent.THEME_FIVE);
                break;


        }
        editor.commit();
        startActivity(new Intent(MainActivity.this, MainActivity.class));
        overridePendingTransition(0, 0);
        finish();
    }

    /**
     * initials all the views used in activity
     */
    private void initialization() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        fab = (FloatingActionButton)findViewById(R.id.fab);

    }

    /**
     * set up toolbar on activity
     */
    private void setUpToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
