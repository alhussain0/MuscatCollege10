package com.learning.om.muscatcollege.about_us;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.learning.om.muscatcollege.R;

public class MainAboutUsPage extends AppCompatActivity {
 private int mID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_about_us_page);
    }

    public void aboutMuscatCollegeOnclick(View view) {

        Intent intent=null;
        mID=view.getId();
        switch (mID){
            case R.id.about_mus:
                intent=new Intent(MainAboutUsPage.this,AboutMuscatCollge.class);
                break;

        }
        if(intent!=null){
            startActivity(intent);
        }
    }
}
