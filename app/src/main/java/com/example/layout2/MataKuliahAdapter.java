package com.example.layout2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class MataKuliahAdapter extends RecyclerView.Adapter<MataKuliahAdapter.ViewHolder> {
    private List<Matakuliah> matakuliahList;
    FirebaseFirestore firebaseFirestoreDb;

    public MataKuliahAdapter(List<Matakuliah> inputData) {
        matakuliahList = inputData;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_matakuliah, parent, false);
        ViewHolder vh = new ViewHolder(v);
        firebaseFirestoreDb = FirebaseFirestore.getInstance();
        return vh;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.namaMatkul.setText(matakuliahList.get(position).getNama());
        holder.dosen.setText(matakuliahList.get(position).getDosen());
        holder.sks.setText(Integer.toString(matakuliahList.get(position).getSks()));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView sks;
        public TextView namaMatkul;
        public TextView dosen;

        public ViewHolder(View v) {
            super(v);
            namaMatkul = (TextView) v.findViewById(R.id.textNamaMatakuliah);
            dosen = (TextView) v.findViewById(R.id.textDosenMatakuliah);
            sks = (TextView) v.findViewById(R.id.textSksMatakuliah);
        }
    }

    @Override
    public int getItemCount() {
        return matakuliahList.size();
    }
}
