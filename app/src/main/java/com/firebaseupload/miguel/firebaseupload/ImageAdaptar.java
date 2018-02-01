package com.firebaseupload.miguel.firebaseupload;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by miguel on 2/1/18.
 */

public class ImageAdaptar extends RecyclerView.Adapter<ImageAdaptar.ImageViewHolder> {

    private Context mContext;
    private List<Upload> mUploads;

    public ImageAdaptar(Context context, List<Upload> uploads) {
       mContext = context;
       mUploads =uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
       return  new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
      Upload uuploadCurrent = mUploads.get(position);
        Picasso.with(mContext).load(uuploadCurrent.getmImageUrl()).placeholder(R.mipmap.ic_launcher).fit().centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

       public TextView textViewName;
       public ImageView imageView;

       public ImageViewHolder(View itemView) {
           super(itemView);

           textViewName = itemView.findViewById(R.id.text_view_name);
           imageView = itemView.findViewById(R.id.image_view_upload);
       }
   }
}
