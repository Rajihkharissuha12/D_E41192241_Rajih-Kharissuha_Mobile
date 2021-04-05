package com.example.recyclelistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RcyclerViewActivity extends AppCompatActivity {

    private RecyclerView rvMahasiswa;
    private MahasiswaAdapter adapterMahasiswa;
    private ArrayList<Mahasiswa> mDataMahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcycler_view);

        addData();

        adapterMahasiswa = new MahasiswaAdapter(mDataMahasiswa);

        rvMahasiswa = findViewById(R.id.rv_mahasiswa);
        rvMahasiswa.setLayoutManager(new LinearLayoutManager(this));
        rvMahasiswa.setAdapter(adapterMahasiswa);

    }

    private void addData() {
        mDataMahasiswa = new ArrayList<>();
        mDataMahasiswa.add(new Mahasiswa("Rajih Kharissuha", "E41192241", "082339584778"));
        mDataMahasiswa.add(new Mahasiswa("Rajih", "E41192241", "082339584778"));
        mDataMahasiswa.add(new Mahasiswa("Rajih K", "E41192241", "082339584778"));
        mDataMahasiswa.add(new Mahasiswa("Rajih Kharis", "E41192241", "082339584778"));
        mDataMahasiswa.add(new Mahasiswa("Rajih Khari", "E41192241", "082339584778"));
    }

}