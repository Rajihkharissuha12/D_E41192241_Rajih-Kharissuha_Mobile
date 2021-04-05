package com.example.recyclelistview;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Adapter penghubung antara list item dan list data

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>{


    private ArrayList<Mahasiswa> datalist;

    public MahasiswaAdapter(ArrayList<Mahasiswa> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public MahasiswaAdapter.MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaAdapter.MahasiswaViewHolder holder, int position) {
        holder.txNama.setText(datalist.get(position).getNama());
        holder.txNim.setText(datalist.get(position).getNim());
        holder.txNoHp.setText(datalist.get(position).getNoHp());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {

        private TextView txNama, txNim, txNoHp;

        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            txNama = itemView.findViewById(R.id.tx_nama_mahasiswa);
            txNim = itemView.findViewById(R.id.txt_npm_mahasiswaw);
            txNoHp = itemView.findViewById(R.id.txt_noph_mahasiswa);
        }
    }
}
