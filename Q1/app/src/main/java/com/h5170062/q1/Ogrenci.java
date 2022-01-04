package com.h5170062.q1;


public class Ogrenci { //Öğrenci isminde class oluşturdum.

    String ad,soyad,no,tarih,ders; //class değişkenleri ve  bu verileri firebaseden çektiriyorum.

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getNo() {
        return no;
    }

    public String getTarih( ){
        return  tarih;
    }

    public String getDers(){
        return  ders;
    }

}