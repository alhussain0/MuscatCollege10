package com.learning.om.muscatcollege.gallery;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.learning.om.muscatcollege.R;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CollegeGalleryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CollegeGalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CollegeGalleryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static int[] galleryImage = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6};
    private final int TIME_TO_CHANGE =3000;
    private Handler handler;
    private Runnable runnable;
    private ViewPager viewPager;
    private int pageNumber;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CollegeGalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CollegeGalleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CollegeGalleryFragment newInstance(String param1, String param2) {
        CollegeGalleryFragment fragment = new CollegeGalleryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_college_gallery, container, false);
        final MyPagerAdapter pagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        viewPager= view.findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        CircleIndicator indicator=view.findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                if(pagerAdapter.getCount()==pageNumber){
                    pageNumber=0;
                }else {
                    pageNumber++;
                }
                viewPager.setCurrentItem(pageNumber,true);
                handler.postDelayed(this,TIME_TO_CHANGE);
            }
        };
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable,TIME_TO_CHANGE);
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceHolderFragment.newInstance(position+1);
        }

        @Override
        public  int getCount() {
            return galleryImage.length;
        }
    }

    public static class PlaceHolderFragment extends Fragment{

    public static final String SECTION = "section";

    public static PlaceHolderFragment newInstance (int section_number){
        PlaceHolderFragment placeHolderFragment = new PlaceHolderFragment();
        Bundle args = new Bundle();
        args.putInt(SECTION,section_number);
        placeHolderFragment.setArguments(args);
        return placeHolderFragment;
    }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
           View view = inflater.inflate(R.layout.pager_layout,container,false);
           int page = getArguments().getInt(SECTION);
            KenBurnsView imageView = view.findViewById(R.id.image);
            imageView.setImageResource(galleryImage[page-1]);
            return view;
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
