package com.example.www.weekcalendarview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView weekView = findViewById(R.id.week_recycler);
        weekView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        weekView.setHasFixedSize(true);

        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);
        WeekViewRecycler weekViewRecycler = new WeekViewRecycler(startDate);
        weekView.setAdapter(weekViewRecycler);
    }
}
