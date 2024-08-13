package com.example.de4;

public class danhba {
    String ten;
    String sdt;

    public danhba(String ten, String sdt) {
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getSdt() {
        return sdt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return ten + " - " + sdt;
    }
}
