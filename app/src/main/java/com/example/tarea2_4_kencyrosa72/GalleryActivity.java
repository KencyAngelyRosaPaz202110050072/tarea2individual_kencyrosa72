package com.example.tarea2_4_kencyrosa72;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea2_4_kencyrosa72.Transacciones.Operaciones;
import com.example.tarea2_4_kencyrosa72.tbl.firmadigital;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {
    RecyclerView recycler;

    ArrayList<firmadigital> galeria;
    List<firmadigital> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeriaf);
        galeria = new ArrayList<>();

        GetListGallery();

        recycler = (RecyclerView) findViewById(R.id.reciclador);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        SignAdapter adapter = new SignAdapter(items);
        recycler.setAdapter(adapter);
    }

    private void GetListGallery() {
        SQLiteConexion conexion = new SQLiteConexion(this, Operaciones.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();
        firmadigital Items = null;
        galeria = new ArrayList<firmadigital>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Operaciones.tabla_firmas, null);

        while (cursor.moveToNext()) {
            Items = new firmadigital();
            Items.setId(cursor.getInt(0));
            Items.setImage(cursor.getBlob(1));
            Items.setDescripcion(cursor.getString(2));

            galeria.add(Items);
        }

        cursor.close();
        GalleryList();
    }

    private void GalleryList() {

        items = new ArrayList<>();

        for (int i = 0;  i < galeria.size(); i++){

            items.add(new firmadigital(
                    galeria.get(i).getId(),
                    galeria.get(i).getImage(),
                    galeria.get(i).getDescripcion()));
        }
    }
}