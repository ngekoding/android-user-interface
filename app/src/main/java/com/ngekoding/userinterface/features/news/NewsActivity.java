package com.ngekoding.userinterface.features.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ngekoding.userinterface.R;
import com.ngekoding.userinterface.adapters.NewsAdapter;
import com.ngekoding.userinterface.features.detail.DetailActivity;
import com.ngekoding.userinterface.models.News;
import com.ngekoding.userinterface.utils.OnItemClickListener;
import com.ngekoding.userinterface.utils.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements OnItemClickListener {

    private RecyclerView newsRecyclerView;
    private NewsAdapter newsAdapter;
    private List<News> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // Get dummy data
        newsList = new ArrayList<>();
        getDummyData();

        // Bind view
        newsRecyclerView = (RecyclerView) findViewById(R.id.rv_news);
        newsAdapter = new NewsAdapter(newsList);
        newsAdapter.setClickListener(this);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        newsRecyclerView.setAdapter(newsAdapter);
    }

    // Dummy data
    private void getDummyData() {
        String imgUrl1 = "http://blogs.jpmsonline.com/wp-content/uploads/2016/01/change-bulbs.jpg";

        newsList.add(new News("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod",
                "20 Januari 2018", imgUrl1));
        newsList.add(new News("Lorem ipsum dolor sit amet, consectetur adipisicing elit",
                "28 Februari 2018", imgUrl1));
        newsList.add(new News("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod",
                "10 Februari 2018", imgUrl1));
        newsList.add(new News("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod",
                "16 Maret 2018", imgUrl1));
        newsList.add(new News("Lorem ipsum dolor sit amet, consectetur adipisicing",
                "05 Maret 2018", imgUrl1));
        newsList.add(new News("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod",
                "03 April 2018", imgUrl1));
        newsList.add(new News("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod",
                "27 Januari 2018", imgUrl1));
        newsList.add(new News("Lorem ipsum dolor sit amet, consectetur",
                "30 Mei 2018", imgUrl1));
        newsList.add(new News("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod",
                "27 Juni 2018", imgUrl1));
        newsList.add(new News("Lorem ipsum dolor sit amet, consectetur",
                "29 Agustus 2018", imgUrl1));
        newsList.add(new News("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod",
                "27 Januari 2019", imgUrl1));
    }

    @Override
    public void onItemClick(int position) {
        News news = newsList.get(position);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("newsTitle", news.getTitle());
        intent.putExtra("newsDate", news.getDate());
        // Go to detail activity
        startActivity(intent);
    }
}
