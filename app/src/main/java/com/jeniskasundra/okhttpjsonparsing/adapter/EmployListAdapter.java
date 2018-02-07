package com.jeniskasundra.okhttpjsonparsing.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jeniskasundra.okhttpjsonparsing.R;
import com.jeniskasundra.okhttpjsonparsing.activity.DetailActivity;
import com.jeniskasundra.okhttpjsonparsing.model.EmployDetail;
import com.jeniskasundra.okhttpjsonparsing.utils.Keys;

import java.util.ArrayList;

/**
 * Created by Jenis Kasundra on 2/2/2018.
 */

public class EmployListAdapter extends  RecyclerView.Adapter<EmployListAdapter.ViewHolder> {

    private ArrayList<EmployDetail> employList;
    private  Context context;
    public EmployListAdapter(Context context,ArrayList<EmployDetail> employList) {
        this.context=context;
        this.employList=employList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_employ_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final EmployDetail employDetail = employList.get(position);
        holder.name.setText(employDetail.getName());
        holder.email.setText(employDetail.getEmail());
        Glide.with(context).load(employDetail.getPicture()).placeholder(R.mipmap.ic_launcher).into(holder.picture);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                Bundle extras = new Bundle();
                extras.putString(Keys.KEY_ID,employDetail.getId());
                extras.putString(Keys.KEY_NAME,employDetail.getName());
                extras.putString(Keys.KEY_GENDER,employDetail.getGender());
                extras.putString(Keys.KEY_ADDRESS,employDetail.getAddress());
                extras.putString(Keys.KEY_PICTURE,employDetail.getPicture());
                extras.putString(Keys.KEY_MOBILE,employDetail.getMobile());
                extras.putString(Keys.KEY_EMAIL,employDetail.getEmail());
                intent.putExtras(extras);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return employList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView name, email;
        public ImageView picture;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tvEmployName);
            email = (TextView) itemView.findViewById(R.id.tvEmployEmail);
            picture = (ImageView) itemView.findViewById(R.id.imgPicture);
        }
    }


}
