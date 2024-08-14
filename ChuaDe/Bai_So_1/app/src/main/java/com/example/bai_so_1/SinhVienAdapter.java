package com.example.bai_so_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SinhVienAdapter extends ArrayAdapter<SinhVien> {
    Context context;
    int resource;
    List<SinhVien> sinhViens;
    public SinhVienAdapter(@NonNull Context context, int resource, @NonNull List<SinhVien> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.sinhViens = objects;
    }

    public class ViewHolder {
        TextView txtTenSv;
        TextView txtGioiTinh;
        TextView txtNamSinh;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_item, parent, false);
            viewHolder.txtTenSv = convertView.findViewById(R.id.txtTenSv);
            viewHolder.txtGioiTinh = convertView.findViewById(R.id.txtGioiTinh);
            viewHolder.txtNamSinh = convertView.findViewById(R.id.txtNamSinh);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SinhVien sinhVien = sinhViens.get(position);
        viewHolder.txtTenSv.setText(sinhVien.TenSv);
        viewHolder.txtGioiTinh.setText(sinhVien.GioiTinh);
        viewHolder.txtNamSinh.setText(sinhVien.NamSinh);
        return convertView;
    }
}
