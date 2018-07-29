package com.learning.om.muscatcollege.gallary;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.learning.om.muscatcollege.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentWithRecyclerView extends Fragment implements RecyclerAdapter.onItemClick {
    //data source need to pass to adapter to update the views
    private String[] name={"Ali","Ammar","Hatim","Ahmed","a","s"};
    private String[] specialization={"MCA","IT","ENG","AC","ad","d"};
    private String[] address={"Ruwi","Sohar","Seeb","Nizwa","sd","s"};
    private int[] image={R.mipmap.ic_img1,R.mipmap.ic_img1,R.mipmap.ic_img1,R.mipmap.ic_img1,R.mipmap.ic_img1,R.mipmap.ic_img1};

    // container that will be contain all the teacher information at one place for easy code management
    private ArrayList<TeacherProfile> teacherProfiles;



    public FragmentWithRecyclerView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        teacherProfiles=new ArrayList<>();
       createTeacher();

        View view=inflater.inflate(R.layout.fragment_fragment_with_recycler_view, container, false);


        RecyclerView recyclerView=view.findViewById(R.id.recyclerView);
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(), 2);
       FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
       LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),
               LinearLayoutManager.VERTICAL , false);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(getActivity(),teacherProfiles,fragmentTransaction);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.onCardViewClick(this);

//        RecyclerView recyclerView2=view.findViewById(R.id.r2);
//        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(getActivity(),
//                LinearLayoutManager.HORIZONTAL , false);
//        recyclerView2.setLayoutManager(linearLayoutManager2);
//        RecyclerAdapter recyclerAdapter2=new RecyclerAdapter(getActivity(),teacherProfiles);
//        recyclerView2.setAdapter(recyclerAdapter2);

        return view;
    }
    public void createTeacher() {
        for (int i = 0; i < name.length; i++) {
            TeacherProfile teacherProfile = new TeacherProfile();
            teacherProfile.setImage(image[i]);
            teacherProfile.setAddress(address[i]);
            teacherProfile.setName(name[i]);
            teacherProfile.setSpecialization(specialization[i]);
            teacherProfiles.add(teacherProfile);

        }

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getActivity(),"position: "+position,Toast.LENGTH_SHORT ).show();
    }
}
