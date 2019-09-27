package com.example.layout2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private ArrayList<String> rvData;

        public RecyclerViewAdapter(ArrayList<String> inputData) {
            rvData = inputData;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            // di tutorial ini kita hanya menggunakan data String untuk tiap item
            public TextView tvTitle;

            public ViewHolder(View v) {
                super(v);
                tvTitle = (TextView) v.findViewById(R.id.tv_title);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // membuat view baru
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false);
            // mengeset ukuran view, margin, padding, dan parameter layout lainnya
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - mengambil elemen dari dataset (ArrayList) pada posisi tertentu
            // - mengeset isi view dengan elemen dari dataset tersebut
            final String name = rvData.get(position);
            holder.tvTitle.setText(rvData.get(position));
        }

        @Override
        public int getItemCount() {
            // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
            return rvData.size();
        }
    }
