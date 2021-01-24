package com.arizataleptakipsistemi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TaleplerAdapter extends ArrayAdapter<Talep> {  //TaleplerAdapter olusturdum ve bunu ArrayAdapter sınıfından extend ettim

    private final LayoutInflater inflater;          //LayoutInflater sınıfından inflater adında bir nesne tanımladım
    private final Context context;                  //bağlam
    private ViewHolder holder;                      // Verileri tuttuğumuz yer
    private final ArrayList<Talep> talepler;       //adaptörümüzün ihtiyaç duyacağı verileri alacağımız yer.


    public TaleplerAdapter(Context context, ArrayList<Talep> talepler) {            // Constructor metodu
        super(context,0, talepler);
        this.context = context;
        this.talepler = talepler;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return talepler.size();
    }

    @Override
    public Talep getItem(int position) {
        return talepler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return talepler.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {             //getView position ile belirtilen her satır için bir view döner.

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.list_view_item, null);      // inflater : her satır için xml'i okuyup view haline getirir.

            holder = new ViewHolder();
          //  holder.personImage = (ImageView) convertView.findViewById(R.id.person_image);       //  TextView in id lerini tuttuğum kısım.
            holder.ad = (TextView) convertView.findViewById(R.id.customad);
            holder.soyad = (TextView) convertView.findViewById(R.id.customsoyad);
            holder.email = (TextView) convertView.findViewById(R.id.customemail);
            holder.detay = (TextView) convertView.findViewById(R.id.customdetay);

            convertView.setTag(holder);

        }
        else{
            //Get viewholder we already created
            holder = (ViewHolder)convertView.getTag();
        }

        Talep talep = talepler.get(position);                                                   // taleplerin indexindeki verileri alıp set ediyorum.
        if(talep != null){
         //   holder.personImage.setImageResource(R.drawable.android_icon);
            holder.ad.setText(talep.getAd());
            holder.soyad.setText(talep.getSoyad());
            holder.email.setText(talep.getEmail());
            holder.detay.setText(talep.getDetay());

        }
        return convertView;
    }
    //View Holder Pattern for better performance
    private static class ViewHolder {
        TextView ad;
        TextView soyad;
        TextView email;
        TextView detay;
       // ImageView personImage;

    }


}
