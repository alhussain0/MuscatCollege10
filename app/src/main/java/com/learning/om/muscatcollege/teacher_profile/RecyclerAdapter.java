package com.learning.om.muscatcollege.teacher_profile;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.learning.om.muscatcollege.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private Context context;
    private ArrayList<TeacherProfile> teacherProfiles;
    private FragmentTransaction fragmentTransaction;
    private CardView cardView;
    private TeacherProfile teacherProfile;
    private  onItemClick itemClick;
    public interface  onItemClick {
        public void onItemClick (int position);

    }


    public RecyclerAdapter(Context context, ArrayList<TeacherProfile> teacherProfiles, FragmentTransaction fragmentTransaction) {
        this.context = context;
        this.teacherProfiles = teacherProfiles;
        this.fragmentTransaction = fragmentTransaction;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.recycler_view_adapter,parent, false);
        cardView= view.findViewById(R.id.cardV);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        teacherProfile=teacherProfiles.get(position);
    holder.image.setImageResource(teacherProfile.getImage());
    holder.name.setText(teacherProfile.getName());
    holder.specialization.setText(teacherProfile.getSpecialization());
    holder.address.setText(teacherProfile.getAddress());
    cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                itemClick.onItemClick(position);
//                teacherProfile = teacherProfiles.get(position);
//                TeacherDetailFragment teacherDetailFragment=TeacherDetailFragment.newInstance(teacherProfile.getName(), teacherProfile.getAddress(),
//                        teacherProfile.getSpecialization(),teacherProfile.getImage());
//                fragmentTransaction.replace(R.id.main_container1,teacherDetailFragment);
//                fragmentTransaction.addToBackStack(teacherDetailFragment.getClass().getSimpleName());
//                fragmentTransaction.commit();
            }
        });
    }

    public void onCardViewClick (onItemClick itemClick){
        this.itemClick=itemClick;
    }
    @Override
    public int getItemCount() {
        return teacherProfiles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,address,specialization;
        ImageView image;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageView2);
            name=itemView.findViewById(R.id.name);
            address=itemView.findViewById(R.id.address);
            specialization=itemView.findViewById(R.id.specialization);
            cardView = itemView.findViewById(R.id.cardV);
        }
    }
}
