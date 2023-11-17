package com.example.tarea2_4_kencyrosa72;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea2_4_kencyrosa72.tbl.firmadigital;

import java.util.List;

public class SignAdapter extends RecyclerView.Adapter<SignAdapter.SignViewHolder> {
    private List<firmadigital> items;

    public SignAdapter(List<firmadigital> items) {
        this.items = items;
    }

    @Override
    public SignViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_scard, viewGroup, false);
        return new SignViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SignViewHolder viewHolder, int i) {
        Bitmap BMP = BitmapFactory.decodeByteArray(items.get(i).getImage(), 0,items.get(i).getImage().length);

        viewHolder.firma.setImageBitmap(BMP);
        viewHolder.descripcion.setText(items.get(i).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class SignViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView firma;
        public TextView id, nombre, fecha, formato, bytes, descripcion;

        public SignViewHolder(View v) {
            super(v);
            firma = (ImageView) v.findViewById(R.id.firma);
            descripcion = (TextView) v.findViewById(R.id.descripcion);
        }
    }
}
