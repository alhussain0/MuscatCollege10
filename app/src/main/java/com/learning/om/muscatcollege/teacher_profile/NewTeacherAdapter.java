package com.learning.om.muscatcollege.teacher_profile;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.learning.om.muscatcollege.R;

import java.util.ArrayList;

public class NewTeacherAdapter extends RecyclerView.Adapter<NewTeacherAdapter.ViewHolder> {

    private Context context;
    private ArrayList<TeacherProfileNew> teacherProfiles;
    private CardView cardView;
    private TeacherProfileNew teacherProfile;
    private  OnItemClick onItemClick;

    public NewTeacherAdapter(Context context, ArrayList<TeacherProfileNew> teacherProfiles) {
        this.context = context;
        this.teacherProfiles = teacherProfiles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.recycler_view_adapter,parent,false);
        cardView = view.findViewById(R.id.cardV);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        teacherProfile=teacherProfiles.get(position);
        holder.image.setImageBitmap(teacherProfile.getImage());
        holder.image.setImageBitmap(teacherProfile.getImage());
        holder.specialization.setText(teacherProfile.getSpecialization());
        holder.address.setText(teacherProfile.getAddress());
        holder.name.setText(teacherProfile.getName());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void onCardViewClick(AllTeacherProfileFragment allTeacherProfileFragment) {
    }

    public interface OnItemClick {
        public void  onItemClick(int position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,address,specialization;
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.i2);
            name=itemView.findViewById(R.id.name);
            address=itemView.findViewById(R.id.address);
            specialization=itemView.findViewById(R.id.specialization);
            cardView = itemView.findViewById(R.id.cardV);
        }
    }
}
