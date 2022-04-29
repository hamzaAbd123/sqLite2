package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ficheProduit extends AppCompatActivity {

    MyDBProduit db;
    Spinner spin;
    ArrayList<Produit> prds;
    TextView tl,tf,tpa,tpv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_produit);
        spin=findViewById(R.id.spin);
        tl=findViewById(R.id.libelle);
        tf=findViewById(R.id.famille);
        tpa=findViewById(R.id.prixa);
        tpv=findViewById(R.id.prixv);
        db=new MyDBProduit(this);
        prds=MyDBProduit.getAllProduits(db.getReadableDatabase());
        ArrayList<String> listeP=new ArrayList<>();
        for(Produit p: prds){
            listeP.add(p.getIDProduit()+" - "+ p.getLibelle());
        }
        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listeP);
        spin.setAdapter(ad);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Produit p= prds.get(i);
                tl.setText(R.string.hintLib+" : "+p.getLibelle());
                tf.setText(R.string.hintFa+"Famille : "+p.getFamille());
                tpa.setText(String.format("%s : %.2f",R.string.hintpa,p.getPrix_vente()));
                tpv.setText(String.format("%s : %.2f",R.string.hintpv,p.getPrix_vente()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}