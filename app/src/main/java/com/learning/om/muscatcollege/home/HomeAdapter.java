package com.learning.om.muscatcollege.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.learning.om.muscatcollege.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Home> homeArrayList;
    private CardView cardView;
    private OnHomeItemClick onHomeItemClick;
    Home home;
    public interface OnHomeItemClick {
        public void onHomeItemClick(int position,String text);

    }

    public HomeAdapter(Context context, ArrayList<Home> homeArrayList) {
        this.context = context;
        this.homeArrayList = homeArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.home_adapter,parent,false);
       cardView= view.findViewById(R.id.cardV2);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
      home= homeArrayList.get(position);
        holder.image.setImageResource(home.getImage());
        holder.name.setText(home.getText());
    cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onHomeItemClick.onHomeItemClick(position,home.getText());
        }
    });
    }

    public void setOnHomeItemClick (OnHomeItemClick onHomeItemClick){
        this.onHomeItemClick= onHomeItemClick;
    }

    @Override
    public int getItemCount() {
        return homeArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image4);
            name= itemView.findViewById(R.id.textView4);
        }
    }
}
