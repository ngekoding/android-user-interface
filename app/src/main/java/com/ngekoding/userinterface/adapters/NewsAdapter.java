package com.ngekoding.userinterface.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ngekoding.userinterface.R;
import com.ngekoding.userinterface.models.News;
import com.ngekoding.userinterface.utils.OnItemClickListener;

import java.util.List;

/**
 * Created by Nur on 1/27/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHoder> {

    // News data
    List<News> newsList;

    private OnItemClickListener clickListener;

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new MyViewHoder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHoder holder, int position) {
        News news = newsList.get(position);

        holder.title.setText(news.getTitle());
        holder.date.setText(news.getDate());

        // Image --> coming soon...
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class MyViewHoder extends RecyclerView.ViewHolder {

        // Deklarasikan semua view yang ada di news_item
        TextView title, date;
        ImageView image;

        public MyViewHoder(View itemView) {
            super(itemView);

            // View binding
            title = itemView.findViewById(R.id.news_title);
            date = itemView.findViewById(R.id.news_date);
            image = itemView.findViewById(R.id.news_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
