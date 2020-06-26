package com.example.fragments2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //перегрузка метода интерфейса ListFragment, вызывается когда мы нажимаем кнопку в фрагменте
    @Override
    public void onFragmentInteraction(String link) {
        DetailFragment fragment=(DetailFragment)getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        if (fragment!=null && fragment.isInLayout()){
            fragment.setText(link);
        } else {
            Intent intent=new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_URL, link);
            startActivity(intent);
        }

    }
}
