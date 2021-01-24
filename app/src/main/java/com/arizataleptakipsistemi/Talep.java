package com.arizataleptakipsistemi;


public class Talep {                            //model sınıfı görüntü ve kontrol arasındaki köprüdür.
    private String ad;                          // getter ve setter metodları ile veri alıp bu veriyi set ettim.
    private String soyad;
    private String email;
    private String detay;

    public Talep(String ad, String soyad, String email, String detay) {
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.detay = detay;


    }
    public Talep(){ }

    public Talep(Object ad, Object soyad, Object email, Object detay) {
    }


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }
}

