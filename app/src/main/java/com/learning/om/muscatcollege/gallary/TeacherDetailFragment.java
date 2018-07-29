package com.learning.om.muscatcollege.gallary;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.learning.om.muscatcollege.MainHomeNavigation;
import com.learning.om.muscatcollege.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeacherDetailFragment extends Fragment {

    private TeacherProfile teacherProfile;
    private static final String KEY1="key1";
    private static final  String KEY2="key2";
    private static final String KEY3="key3";
    private static final String KEY4="key4";
    private String name;
    private String address;
    private String speci;
    private int image;

    public TeacherDetailFragment() {
        // Required empty public constructor
    }
    public static TeacherDetailFragment newInstance(String name,String address,String specialization,int image){
        TeacherDetailFragment fragment=new TeacherDetailFragment();
        Bundle bundle=new Bundle();
        bundle.putString(KEY1,name);
        bundle.putString(KEY2,address);
        bundle.putString(KEY3,specialization);
        bundle.putInt(KEY4,image);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle state) {
        super.onCreate(state);
        if(getArguments()!=null){

            name=getArguments().getString(KEY1);
            address=getArguments().getString(KEY2);
            speci=getArguments().getString(KEY3);
            image=getArguments().getInt(KEY4);

        }




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        ((MainHomeNavigation)getActivity()).getSupportActionBar().hide();

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_teacher_detail, container, false);
        TextView headerTitle=view.findViewById(R.id.header_text);
        headerTitle.setText("Teacher Profile");
        ImageView imageView=view.findViewById(R.id.img1);
        imageView.setImageResource(image);
        TextView name1=view.findViewById(R.id.te1);
        name1.setText(name);

        return  view;
    }

}
