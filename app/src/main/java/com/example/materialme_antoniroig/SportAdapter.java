package com.example.materialme_antoniroig;

import android.content.Context;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

class SportAdapter extends RecyclerView.Adapter<SportAdapter.ViewHolder>  {

    private ArrayList<Sport> mSportsData;
    private Context mContext;

    SportAdapter(Context context, ArrayList<Sport> sportsData) {
        this.mSportsData = sportsData;
        this.mContext = context;
    }

    @Override
    public SportAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false));
    }


    @Override
    public void onBindViewHolder(SportAdapter.ViewHolder holder,
                                 int position) {
        Sport currentSport = mSportsData.get(position);

        holder.mTitleText.setText(currentSport.getTitle());
        Glide.with(mContext).load(currentSport.getimageResource()).into(holder.mSportsImage);
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mSportsData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportsImage;

        ViewHolder(View itemView) {
            super(itemView);

            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
            mSportsImage = (ImageView) itemView.findViewById(R.id.sportsImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            Sport currentSport = mSportsData.get(position);
            Intent detailIntent = new Intent(mContext, Detail.class);
            detailIntent.putExtra("title", currentSport.getTitle());
            detailIntent.putExtra("image_resource", currentSport.getimageResource());
            detailIntent.putExtra("subTitle", currentSport.getInfo());
            mContext.startActivity(detailIntent);
        }

        void bindTo(Sport currentSport){

            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());
        }
    }
}