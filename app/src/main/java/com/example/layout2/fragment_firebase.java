package com.example.layout2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class fragment_firebase extends Fragment {
    private EditText namaMatakuliah;
    private EditText sksMatakuliah;
    private EditText dosenMatakuliah;
    private Button buttonSimpan;
    private Button buttonHapus;
    private FirebaseFirestore firebaseFirestoreDb;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_firebase, container, false);
        namaMatakuliah = view.findViewById(R.id.namaMatakuliah);
        sksMatakuliah = view.findViewById(R.id.sksMatakuliah);
        dosenMatakuliah = view.findViewById(R.id.dosenMatakuliah);
        buttonSimpan = view.findViewById(R.id.simpanButton);
        buttonHapus = view.findViewById(R.id.hapusButton);



        firebaseFirestoreDb = FirebaseFirestore.getInstance();

        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sanity check
                if (!namaMatakuliah.getText().toString().isEmpty() && !sksMatakuliah.getText().toString().isEmpty()) {
                    tambahMatakuliah();
                } else {
                    Toast.makeText(requireActivity(), "No dan Nama Mhs tidak boleh kosong",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void tambahMatakuliah(){
        Matakuliah mtk = new Matakuliah(namaMatakuliah.getText().toString(),
                 Integer.parseInt(sksMatakuliah.getText().toString()),
                 dosenMatakuliah.getText().toString());
        firebaseFirestoreDb.collection("Daftar Matakuliah").
                document().set(mtk).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(requireActivity(), "Matakuliah berhasil didaftarkan"
                        , Toast.LENGTH_SHORT).show();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(requireActivity(),
                        "ERROR" + e.toString(),
                        Toast.LENGTH_SHORT).show();
                Log.d("TAG", e.toString());
            }
        });
    }




}
