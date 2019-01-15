package com.example.android.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;
    ImageView image1;
    TextView description1,title1,bar;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

    }
    public void setDetails(Context context,String description,String image,String title){
        title1 = (TextView) itemView.findViewById(R.id.rTitleTv);
        description1= (TextView)itemView.findViewById(R.id.rDescriptionView);
        image1 = (ImageView)itemView.findViewById(R.id.rImageView);
        bar = (TextView) itemView.findViewById(R.id.barrier);

        title1.setText(description);
        description1.setText(image);
        Picasso.get().load(title).into(image1);

    }
}
