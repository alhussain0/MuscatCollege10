package com.learning.om.muscatcollege.gallary;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.learning.om.muscatcollege.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GallaryFragment extends Fragment {


    public GallaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallary, container, false);
        ListView listView=view.findViewById(R.id.listView);
        String[] data= new String[]{"Oman","UAE","KSA","QATUR","KUWET","RUSTAQ"};


        String[] data2= new String[]{"Hatim","Amar","Mohammad","Azan","Abrar","Ali"};
        String[] data3= new String[]{"123","456","789","1011","1213","1415"};

        int[] images=new int[]{R.mipmap.ic_img1,R.mipmap.ic_img1,R.mipmap.ic_img1,R.mipmap.ic_img1,R.mipmap.ic_img1,R.mipmap.ic_img1};
          CustomAdapter adapter=new CustomAdapter(getActivity(),data,data2,data3,images);
          listView.setAdapter(adapter);

//        int[] to=new int[]{R.id.textView12};
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getActivity(), ""+1, Toast.LENGTH_SHORT).show();
//            }
//        });
      return view;

    }

}
