package com.ngekoding.userinterface.features.detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ngekoding.userinterface.R;

public class DetailActivity extends AppCompatActivity {

    private TextView detailTitle, detailDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailTitle = (TextView) findViewById(R.id.detail_title);
        detailDate = (TextView) findViewById(R.id.detail_date);

        // Mengambil data dari intent
        Intent intent = getIntent();
        String newsTitle = intent.getStringExtra("newsTitle");
        String newsDate = intent.getStringExtra("newsDate");

        // Set detail value
        detailTitle.setText(newsTitle);
        detailDate.setText(newsDate);
    }
}
