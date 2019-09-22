package com.example.tuan2_3_bai1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<NhanVIen> {

    private Context context;
    private  int resource;
    private ArrayList<NhanVIen> arrNhanvien;

    public MyArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<NhanVIen> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrNhanvien = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.my_item_layout,parent,false);
        ImageView img = (ImageView)convertView.findViewById(R.id.img_item);
        TextView txt = (TextView)convertView.findViewById(R.id.tv_item);
        if (arrNhanvien.size()>0 && position >= 0)
        {
            NhanVIen nv = arrNhanvien.get(position);
            txt.setText(nv.toString());
            if(nv.isGender()){
                img.setImageResource(R.drawable.women_image);
            }
            else {
                img.setImageResource(R.drawable.men_image);
            }
        }


        return convertView;
    }
}
