package com.example.layout2;

import android.content.Intent;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class fragment_firebase extends Fragment {
    private EditText namaMatakuliah;
    private EditText sksMatakuliah;
    private EditText dosenMatakuliah;
    private Button buttonSimpan;
    private Button buttonHapus;
    private Button buttonUpdate;
    private FirebaseFirestore firebaseFirestoreDb;
    private RecyclerView rv;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lm;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_firebase, container, false);
        rv = (RecyclerView) view.findViewById(R.id.recycle_matakuliah);
        namaMatakuliah = view.findViewById(R.id.namaMatakuliah);
        sksMatakuliah = view.findViewById(R.id.sksMatakuliah);
        dosenMatakuliah = view.findViewById(R.id.dosenMatakuliah);
        buttonSimpan = view.findViewById(R.id.simpanButton);
        buttonHapus = view.findViewById(R.id.hapusButton);
        buttonUpdate = view.findViewById(R.id.updateButton);



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

        buttonHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(!namaMatakuliah.getText().toString().isEmpty()){
                    //fungsi hapus matakuliah
                    deleteDataMatakuliah();
                }else{
                    Toast.makeText(requireActivity(), "Isi nama matakuliah yang akan dihapus",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                    //belum work
                    updateDataMatakuliah();
                }
        });

        getDataMatakuliah();

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

    private void getDataMatakuliah() {
        final ArrayList<Matakuliah> dataMtk = new ArrayList<Matakuliah>();
        Task<QuerySnapshot> docRef = firebaseFirestoreDb.collection("Daftar Matakuliah")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot doc : task.getResult()){
                                Matakuliah m = new Matakuliah();
                                m.setNama(doc.get("nama").toString());
                                m.setDosen(doc.get("dosen").toString());
                                m.setSks(Integer.parseInt(doc.get("sks").toString()));
                                dataMtk.add(m);
                            }
                            rv.setHasFixedSize(true);
                            rv.setNestedScrollingEnabled(false);
                            lm = new LinearLayoutManager(getContext());
                            rv.setLayoutManager(lm);
                            adapter = new MataKuliahAdapter(dataMtk);
                            rv.setAdapter(adapter);
                        }
                    }
                });
    }

    private void deleteDataMatakuliah() {
        firebaseFirestoreDb.collection("Daftar Matakuliah").document("B9qI10XRukHXsjvv8cJF")
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        namaMatakuliah.setText("");
                        sksMatakuliah.setText("");
                        dosenMatakuliah.setText("");
                        Toast.makeText(requireActivity(), "Matakuliah berhasil dihapus",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(requireActivity(), "Error deleting document: " + e.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void updateDataMatakuliah(){
        //belum work
//        Intent intent = new Intent(context, NoteActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.putExtra("UpdateNoteId", note.getId());
//        intent.putExtra("UpdateNoteTitle", note.getTitle());
//        intent.putExtra("UpdateNoteContent", note.getContent());
//        context.startActivity(intent);
    }






}
