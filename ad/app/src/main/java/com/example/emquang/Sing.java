package com.example.emquang;

public class Sing {
    String tenBH;
    String tenCS;

    public Sing(String tenBH, String tenCS) {
        this.tenBH = tenBH;
        this.tenCS = tenCS;
    }

    public Sing() {
    }

    public String getTenBH() {
        return tenBH;
    }

    public void setTenBH(String tenBH) {
        this.tenBH = tenBH;
    }

    public String getTenCS() {
        return tenCS;
    }

    public void setTenCS(String tenCS) {
        this.tenCS = tenCS;
    }

    @Override
    public String toString() {
        return tenBH + " - " + tenCS;
    }
}
