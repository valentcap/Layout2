package com.example.layout2;

public class Matakuliah {
    private String nama;
    private int sks;
    private String dosen;

    public Matakuliah(String nama, int sks, String dosen) {
        this.nama = nama;
        this.sks = sks;
        this.dosen = dosen;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

}
