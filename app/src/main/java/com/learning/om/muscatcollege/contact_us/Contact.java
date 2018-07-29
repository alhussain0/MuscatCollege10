package com.learning.om.muscatcollege.contact_us;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.learning.om.muscatcollege.R;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        getSupportActionBar().setTitle(R.string.contact_us);
    }

    public void dialnumber(View view) {
        Intent intent = null;
        int id = view.getId();
        switch (id) {
            case R.id.phone1:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+968 91717716"));
                break;
            case R.id.phone2:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+968 24 501181"));
                break;
            case R.id.phone3:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+968 24 503821"));
                break;
            case R.id.mail:
                intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setType("vnd.android.cursor.item/email");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@muscatcollege.edu.om"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "my subject");
                intent.putExtra(Intent.EXTRA_TEXT, "body");
                startActivity(Intent.createChooser(intent, "send"));
                break;

            case R.id.textView6:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + "www.muscatcollege.edu.om/Assistant-Dean-for-Academics/"));
                break;
            case R.id.textView7:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + "www.muscatcollege.edu.om/Quality-Assurance/"));
                break;
            case R.id.textView8:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + "www.muscatcollege.edu.om/Assistant-Dean-for-Admission-and-Registration/"));
                break;
            case R.id.textView9:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + "www.muscatcollege.edu.om/Assistant-Dean-for-Administration-and-Finance/"));
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
