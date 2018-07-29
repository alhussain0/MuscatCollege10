package com.learning.om.muscatcollege.initial_setup;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import com.learning.om.muscatcollege.MainHomeNavigation;
import com.learning.om.muscatcollege.MuscatCollegeBaseActivity;
import com.learning.om.muscatcollege.R;
import com.learning.om.muscatcollege.global_contants.MuscatCollegeConstants;

public class SplashScreen extends MuscatCollegeBaseActivity {
    private static final int TIME_WAIT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
       setContentView(R.layout.activity_main);
       if(getSharedPreferences(MuscatCollegeConstants.LANG_FILE,MODE_PRIVATE).
       getString(MuscatCollegeConstants.LANG,null)!=null &&
               getSharedPreferences(MuscatCollegeConstants.LANG_FILE,MODE_PRIVATE).
                getString(MuscatCollegeConstants.LANG, null).
                equalsIgnoreCase(MuscatCollegeConstants.AR)){
           changeLang(MuscatCollegeConstants.AR);
    }
    else {
           changeLang(MuscatCollegeConstants.EN);
       }

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    SharedPreferences sharedPreferences = getSharedPreferences(MuscatCollegeConstants.TERMS_CONDITIONS_FILE, MODE_PRIVATE);
                                    boolean accepted = sharedPreferences.getBoolean(MuscatCollegeConstants.ACCEPTED, false);
                                    if (accepted) {

                                        Intent intent = new Intent(SplashScreen.this,MainHomeNavigation.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Intent intent = new Intent(SplashScreen.this, TermsAndCondition.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            }, TIME_WAIT);

//        Thread thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                    try {
//                        Thread.sleep(3000);
//                        setContentView(R.layout.activity_main);
//                        getSupportActionBar().show();
////                        Intent intent=new Intent(MainActivity.this,HomeActivity.class);
////                        startActivity(intent);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            });
//

    }
    }




