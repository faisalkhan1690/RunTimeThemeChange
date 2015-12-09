package com.example.faisal.runtimethemechange;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by faisal on 12/9/2015.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences=getSharedPreferences(AppConstent.APP_THEME, Context.MODE_PRIVATE);
        switch(sharedPreferences.getInt(AppConstent.APP_THEME_SELECTION,AppConstent.THEME_DEFAULT)) {
            case AppConstent.THEME_ONE:
                setTheme(R.style.AppThemeOne);
                break;
            case AppConstent.THEME_TWO:
                setTheme(R.style.AppThemeTwo);
                break;
            case AppConstent.THEME_THREE:
                setTheme(R.style.AppThemeThree);
                break;
            case AppConstent.THEME_FOUR:
                setTheme(R.style.AppThemeThree);
                break;
            case AppConstent.THEME_FIVE:
                setTheme(R.style.AppThemeThree);
                break;
            default:
                setTheme(R.style.AppThemeOne);
        }
        super.onCreate(savedInstanceState);
    }
}
