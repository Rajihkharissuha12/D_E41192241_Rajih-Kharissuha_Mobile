package com.example.recyclelistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnListView;
    private  Button btnrecycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListView = findViewById(R.id.btn_list_view);
        btnrecycleview = findViewById(R.id.btn_recycleview);

        btnListView.setOnClickListener(v -> {
                startActivity(new Intent(MainActivity.this,ListViewActivity.class));
        });

        btnrecycleview.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,RcyclerViewActivity.class));
        });
    }
}