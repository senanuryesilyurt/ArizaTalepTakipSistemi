package com.arizataleptakipsistemi;

import android.app.Activity;
import android.os.Bundle;

public class Kullanici {
    String ad;
    String soyad;
    String email;
    String sifre;
    String birim;
    Integer oda_no;
    String unvan;
    String kat_no;

    public Kullanici(String ad, String soyad, String email, String sifre, String birim, Integer oda_no, String unvan, String kat_no) {
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.sifre = sifre;
        this.birim = birim;
        this.oda_no = oda_no;
        this.unvan = unvan;
        this.kat_no = kat_no;
    }

    public Kullanici (){}


    public String getAd() {
        return ad;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getSifre() {return sifre;}
    public void setSifre(String sifre) {this.sifre = sifre;}

    public String getBirim() {return birim;}
    public void setBirim(String birim) {this.birim = birim;}

    public Integer getOda_no() {
        return oda_no;
    }
    public void setOda_no(Integer oda_no) {this.oda_no = oda_no;}

    public String getUnvan() {return unvan ;}
    public void setUnvan(String unvan) { this.unvan = unvan; }

    public String getKat_no() {
        return kat_no;
    }
    public void setKat_no(String ad) {
        this.kat_no = kat_no;
    }

}
