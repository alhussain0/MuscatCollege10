package com.learning.om.muscatcollege.gallary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.learning.om.muscatcollege.R;

public class CustomAdapter extends ArrayAdapter<String> {
    private Context context;
    private String[] objects;
    private String[] objects2;
    private String[] objects3;
    private int[] images;
    public CustomAdapter(@NonNull Context context, @NonNull String[] objects,@NonNull String[] objects2,@NonNull String[] objects3,int[] images) {
        super(context, -1, objects);
        this.context=context;
        this.objects=objects;
        this.images=images;
        this.objects2=objects2;
        this.objects3=objects3;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View view= inflater.inflate(R.layout.list_view_cell,parent,false);

//        ImageView imageView=view.findViewById(R.id.imageView2);
//        imageView.setImageResource(images[position]);
//
//        TextView textView=view.findViewById(R.id.t1);
//        textView.setText(objects[position]);
//
//        TextView textView1=view.findViewById(R.id.t2);
//        textView1.setText(objects2[position]);
//
//        TextView textView2=view.findViewById(R.id.t3);
//        textView2.setText(objects3[position]);



        return view;
    }
}
