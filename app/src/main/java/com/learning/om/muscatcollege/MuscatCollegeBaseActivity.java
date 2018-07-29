package com.learning.om.muscatcollege;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.learning.om.muscatcollege.global_contants.MuscatCollegeConstants;

import java.util.Locale;

public class MuscatCollegeBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscat_college_base);
    }
    public void changeLang(String lang){
        Locale myLocale=new Locale(lang);
        Locale.setDefault(myLocale);
        Configuration config=new Configuration();
        config.locale=myLocale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences sharedPreferences=getSharedPreferences(MuscatCollegeConstants.LANG_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(MuscatCollegeConstants.LANG, lang);
        editor.commit();
    }
}
