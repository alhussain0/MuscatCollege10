package com.learning.om.muscatcollege;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.learning.om.muscatcollege.about_us.MainAboutUsPage;
import com.learning.om.muscatcollege.contact_us.Contact;
import com.learning.om.muscatcollege.global_contants.MuscatCollegeConstants;

import java.util.Locale;

public class  HomeActivity extends MuscatCollegeBaseActivity {

private int mID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button aboutus=(Button)findViewById(R.id.aboutus);

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,MainAboutUsPage.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_settings1){

            Locale current=getResources().getConfiguration().locale;
            if(current.getLanguage().equalsIgnoreCase(MuscatCollegeConstants.AR)) {
                changeLang(MuscatCollegeConstants.EN);
            }else {
                changeLang(MuscatCollegeConstants.AR);
            }
            Intent intent=getIntent();
            finish();
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void homeItemClicked(View view) {
        Intent intent=null;
        mID=view.getId();
        switch (mID){

            case R.id.aboutus:
                intent=new Intent(HomeActivity.this, MainAboutUsPage.class);
                break;
            case R.id.academic:

                break;
            case R.id.departments:
                break;
            case R.id.research:
                break;
            case R.id.facilities:
                break;
            case R.id.student:
                break;
            case R.id.events:
                break;
            case R.id.contact:
                intent=new Intent(HomeActivity.this, Contact.class);
                break;



        }
        if(intent!=null){
        startActivity(intent);
    }

}}
