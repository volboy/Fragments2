package com.example.fragments2;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_URL="url";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }
        setContentView(R.layout.activity_detail);
        Bundle extras=getIntent().getExtras();
        if (extras!=null){
            String url=extras.getString(EXTRA_URL);
            DetailFragment detailFragment=(DetailFragment)getSupportFragmentManager().findFragmentById(R.id.detailFragment);
            detailFragment.setText(url);

        }
    }
}
