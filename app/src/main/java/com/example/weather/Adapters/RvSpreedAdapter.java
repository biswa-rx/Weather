package com.example.weather.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.Models.RvSpreedModel;
import com.example.weather.R;
import com.example.weather.WeatherType;

import java.util.ArrayList;

public class RvSpreedAdapter extends RecyclerView.Adapter<RvSpreedAdapter.viewHolder>{
    ArrayList<RvSpreedModel> list;
    Context context;
    OnItemClickListener onItemClickListener;
    public RvSpreedAdapter(ArrayList<RvSpreedModel> list, Context context,OnItemClickListener onItemClickListener) {
        this.list = list;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_model,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        RvSpreedModel rvSpreedModel = list.get(position);
        holder.time.setText(rvSpreedModel.getTime());
        holder.imageView.setImageResource(rvSpreedModel.getImage());
        holder.temperature.setText(rvSpreedModel.getTemp());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView time;
        TextView temperature;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.rvs_image);
            temperature = itemView.findViewById(R.id.rvs_temp);
            time = itemView.findViewById(R.id.rvs_time);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
    public interface OnItemClickListener{
        public void onItemClick(int position);
    }


}
