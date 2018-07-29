package com.learning.om.muscatcollege.initial_setup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.Toast;

import com.learning.om.muscatcollege.MainHomeNavigation;
import com.learning.om.muscatcollege.R;
import com.learning.om.muscatcollege.global_contants.MuscatCollegeConstants;

public class TermsAndCondition extends AppCompatActivity {
    private WebView webView;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_condition);
        webView = findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/terms_conditions.html");
        checkBox = findViewById(R.id.checkBox);
    }

    public void accepted(View view) {

        if (checkBox.isChecked()) {
            SharedPreferences sharedPreferences =
                    getSharedPreferences(MuscatCollegeConstants.TERMS_CONDITIONS_FILE, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(MuscatCollegeConstants.ACCEPTED, true);
            editor.commit();
            Intent intent = new Intent(TermsAndCondition.this, MainHomeNavigation.class);
            startActivity(intent);
            finish();
        } else {

            Toast.makeText(TermsAndCondition.this, "Please accept", Toast.LENGTH_LONG).show();
        }
    }
}


