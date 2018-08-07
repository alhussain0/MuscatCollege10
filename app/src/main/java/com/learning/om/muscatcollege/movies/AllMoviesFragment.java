package com.learning.om.muscatcollege.movies;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.learning.om.muscatcollege.EXdatabase.MyHelperDatabase;
import com.learning.om.muscatcollege.MainHomeNavigation;
import com.learning.om.muscatcollege.R;
import com.learning.om.muscatcollege.teacher_profile.NewTeacherAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AllMoviesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AllMoviesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllMoviesFragment extends Fragment implements MoviesAdapter.OnItemClick {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    //this web service UI
    private static final String WEBSERVICE_API="https://api.androidhive.info/json/movies.json";

    private static final String TITLE_KEY = "title";
    private static final String IMAGE_KEY = "image";
    private static final String RELEASE_YEAR_KEY = "releaseYear";
    private static final String RATING_KEY = "rating";

    private JSONArray jsonArray;
    private JSONObject jsonObject;
    private RequestQueue requestQueue;
    private JsonArrayRequest jsonArrayRequest;

    //you can use json object request if the most outer  in the json file is an object
//    private JsonObjectRequest jsonObjectRequest;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ArrayList<Movies> moviesArrayList;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private MyHelperDatabase myHelperDatabase;
    private OnFragmentInteractionListener mListener;
    private Movies movies;


    public AllMoviesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllTeacherProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AllMoviesFragment newInstance(String param1, String param2) {
        AllMoviesFragment fragment = new AllMoviesFragment();
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
//        myHelperDatabase= new MyHelperDatabase(getContext());
        ((MainHomeNavigation)getActivity()).getSupportActionBar().setTitle("All Teacher Profile");
 //       teacherProfileNews = myHelperDatabase.getAllTheTeacher();
        // Inflate the layout for this fragment
        requestQueue = Volley.newRequestQueue(getContext());
        jsonArrayRequest=new JsonArrayRequest(WEBSERVICE_API, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(getActivity(),response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonArrayRequest);

         View view =inflater.inflate(R.layout.movies_adapter, container, false);
        RecyclerView recyclerView =view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
//        MoviesAdapter moviesAdapter= new NewTeacherAdapter(getActivity(),moviesArrayList);
//        moviesAdapter.onCardViewClick(this);
//        recyclerView.setAdapter(moviesAdapter);
         return view;
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

    @Override
    public void onItemClick(int position) {

        movies = moviesArrayList.get(position);
        
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
