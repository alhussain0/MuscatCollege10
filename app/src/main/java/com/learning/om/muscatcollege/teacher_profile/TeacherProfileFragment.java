package com.learning.om.muscatcollege.teacher_profile;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.learning.om.muscatcollege.EXdatabase.MyHelperDatabase;
import com.learning.om.muscatcollege.R;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TeacherProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TeacherProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeacherProfileFragment extends Fragment {

//    private TeacherProfileNew teacherProfileNew;
//
//    private String name;
//    private String specialization;
//    private String address;
//    private Bitmap image;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText nameEidt,addressEidt,specEidt;
    private String name , address ,specialization;
    private CircleImageView photoCirculer;
    private ImageView photoImageView;
    private Bitmap photoBitmap;
    private Button save;
    private static  final  int CAMERA_REQUEST_CODE=1;
    private static  final  int MY_PERMISSION_REQUEST_OPEN_CAMERA=2;
    private TeacherProfileNew teacherProfileNew;
    private MyHelperDatabase myHelperDatabase;
    private OnFragmentInteractionListener mListener;

    public TeacherProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeacherProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeacherProfileFragment newInstance(String param1, String param2) {
        TeacherProfileFragment fragment = new TeacherProfileFragment();
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
        View view= inflater.inflate(R.layout.fragment_teacher_profile, container, false);
        myHelperDatabase=new MyHelperDatabase(getActivity());
        nameEidt= view.findViewById(R.id.editTextName);
        addressEidt=view.findViewById(R.id.editTextAddress);
        specEidt= view.findViewById(R.id.editTextSpecialization);
        photoCirculer= view.findViewById(R.id.profilepic);
        photoImageView=view.findViewById(R.id.camera_id);
        photoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                    if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                            Manifest.permission.CAMERA)){
                        //show an explaination
                    }else {
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[] {Manifest.permission.CAMERA,},
                                MY_PERMISSION_REQUEST_OPEN_CAMERA);
                    }
                }
                else
                {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent,CAMERA_REQUEST_CODE);
                }
            }
        });

        save= view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(photoBitmap != null){
                    doMyWork();
                }
                else {
                    Toast.makeText(getActivity(),"please capture an image",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_REQUEST_CODE && resultCode==RESULT_OK){
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            photoBitmap= Bitmap.createScaledBitmap(bitmap,512,512,true);
            photoCirculer.setImageBitmap(photoBitmap);
        }
        else if(requestCode==CAMERA_REQUEST_CODE && resultCode==RESULT_CANCELED){

            Toast.makeText(getActivity(),"nothing change",Toast.LENGTH_LONG).show();
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case MY_PERMISSION_REQUEST_OPEN_CAMERA:
                //if request cancelled , the result arrays are empty
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent,CAMERA_REQUEST_CODE);
                }else {

                }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    public void  doMyWork (){
        name= nameEidt.getText().toString();
        if(TextUtils.isEmpty(name)){
            nameEidt.setError("Name Required");
            return;
        }
        address= addressEidt.getText().toString();
        if(TextUtils.isEmpty(address)){
            addressEidt.setError("Address Required");
            return;
        }
        specialization=specEidt.getText().toString();
        if(TextUtils.isEmpty(specialization)){
            specEidt.setError("Specialization Required");
            return;
        }

        teacherProfileNew=new TeacherProfileNew();
        teacherProfileNew.setAddress(address);
        teacherProfileNew.setName(name);
        teacherProfileNew.setSpecialization(specialization);
        teacherProfileNew.setImage(photoBitmap);
        long l =myHelperDatabase.insertTeacherProfile(teacherProfileNew);
        if(l>0){
            Toast.makeText(getActivity(),"inserted successfully and ID is " +1,Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(getActivity(),"Something went wronge",Toast.LENGTH_SHORT).show();
        }
        Log.v("test","test text");

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
