package com.h5170062.q1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter  extends RecyclerView.Adapter<Adapter.MyViewHolder> {


    Context context; //Aktiviyeyi başlatmak için context değişkeni oluşturdum.
    ArrayList<Ogrenci> list;

    public Adapter(Context context, ArrayList<Ogrenci> list) { //kurucu metod oluşturdum.
        this.context = context; // kurucu metod context ve listeyi dışardan aldığı parametreye göre set ettiriyor.
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        //v değişkenini oluşturuyoruz context'i veri olarak gönderiyorum.
        return  new MyViewHolder(v);

    }
    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {

        Ogrenci ogr =  list.get(position);

        //Ekranda gösterilecek değişkenleri classdan alarak set işlemi yapıyorum.

        holder.ad.setText(ogr.getAd());
        holder.soyad.setText(ogr.getSoyad());
        holder.no.setText(ogr.getNo());
        holder.tarih.setText(ogr.getTarih());
        holder.ders.setText(ogr.getDers());
    }

    @Override
    public int getItemCount() {
        return list.size(); //Oluşturduğum ogrenci listesinin boyutunu aldırıyorum.
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView ad,soyad,no,tarih,ders;

        public MyViewHolder(@NonNull View itemView) { // Firebaseden gelen verileri birleştiriyorum.
            super(itemView);

            ad = itemView.findViewById(R.id.tvadi);
            soyad = itemView.findViewById(R.id.tvsoyadi);
            no = itemView.findViewById(R.id.tvno);
            tarih = itemView.findViewById(R.id.tvTarih);
            ders = itemView.findViewById(R.id.tvDers);
        }
    }
}