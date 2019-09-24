package com.example.harj3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Model> ItemModelList;
    MyAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv);

        ItemModelList = new ArrayList<Model>();
        customAdapter = new MyAdapter(getApplicationContext(), ItemModelList);
        listView.setAdapter(customAdapter);
    }

    @SuppressLint("NewApi")
    public void addDate(View v) {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        String date = df.format(Calendar.getInstance().getTime());


        Model md = new Model(date);
        ItemModelList.add(md);
        customAdapter.notifyDataSetChanged();


    }
}
