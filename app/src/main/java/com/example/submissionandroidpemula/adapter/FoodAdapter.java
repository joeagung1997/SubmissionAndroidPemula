package com.example.submissionandroidpemula.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.submissionandroidpemula.DetilItemFoodActivity;
import com.example.submissionandroidpemula.R;
import com.example.submissionandroidpemula.model.Food;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private ArrayList<Food> listFood;
    private Context mContext;

//    private OnItemClickCallback onItemClickCallback;


//    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback;
//    }


    public FoodAdapter(Context mContext, ArrayList<Food> listFood) {
        this.listFood = listFood;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_food, viewGroup, false);

        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FoodViewHolder holder, final int position) {
        Food food = listFood.get(position);

        Glide.with(holder.itemView.getContext())
                .load(listFood.get(position).getPhoto())
                .into(holder.imgPhoto);

        holder.tvTempat.setText(food.getTempat());
        holder.tvJarak.setText(food.getJarak());
        holder.tvDesc.setText(food.getDesc());

        holder.linearLayoutId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DetilItemFoodActivity.class);
                i.putExtra("image", listFood.get(position).getPhoto());
                i.putExtra("tempat", listFood.get(position).getTempat());
                i.putExtra("jarak", listFood.get(position).getJarak());
                i.putExtra("desc", listFood.get(position).getDesc());

                mContext.startActivity(i);
            }
        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onItemClickCallback.onItemClicked(listFood.get(holder.getAdapterPosition()));
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayoutId;
        ImageView imgPhoto;
        TextView tvTempat, tvDesc, tvJarak;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvTempat = itemView.findViewById(R.id.tv_tempat);
            tvDesc = itemView.findViewById(R.id.tv_desc_makanan);
            tvJarak = itemView.findViewById(R.id.tv_jarak);
            linearLayoutId = itemView.findViewById(R.id.linearId);


        }
    }

//    public interface OnItemClickCallback {
//        void onItemClicked(Food data);
//    }


}
