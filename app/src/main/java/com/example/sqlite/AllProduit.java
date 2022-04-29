package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AllProduit extends AppCompatActivity {

    MyDBProduit db;
    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_produit);
        ls=findViewById(R.id.lst);
        db=new MyDBProduit(this);
        ArrayList<Produit>prds= MyDBProduit.getAllProduits(db.getReadableDatabase());
        ArrayList<String>listprds= new ArrayList<>();
        for(Produit p :prds){
           listprds.add(p.getIDProduit()+" - " +p.getLibelle());

        }
     ArrayAdapter<String> ad =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listprds);
           ls.setAdapter(ad);
    }
}