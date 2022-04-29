package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditerProduit extends AppCompatActivity {

    MyDBProduit db;
    Button btn;
    Spinner spin;
    EditText el,ef,epa,epv;
    ArrayList<Produit> prds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editer_produit);
        btn=findViewById(R.id.edit);
        el=findViewById(R.id.lib);
        ef=findViewById(R.id.fam);
        epa=findViewById(R.id.pra);
        epv=findViewById(R.id.prv);
        spin=findViewById(R.id.spin);
        db=new MyDBProduit(this);
        prds=MyDBProduit.getAllProduits(db.getReadableDatabase());
        ArrayList<String> listeP=new ArrayList<>();
        for(Produit p: prds){
            listeP.add(p.getIDProduit()+" - "+ p.getLibelle());
        }
        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listeP);
        spin.setAdapter(ad);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(el.getText().toString().isEmpty() || ef.getText().toString().isEmpty()
                        || epa.getText().toString().isEmpty() || epv.getText().toString().isEmpty())

                    Toast.makeText(EditerProduit.this, R.string.msgErr, Toast.LENGTH_LONG).show();
                else {
                    Produit p =prds.get(spin.getSelectedItemPosition());
                    p.setLibelle(el.getText().toString());
                    p.setFamille(el.getText().toString());
                    p.setPrix_achat(Double.valueOf(epa.getText().toString()));
                    p.setPrix_vente(Double.valueOf(epv.getText().toString()));
                    MyDBProduit.updateProduit(db.getWritableDatabase(),p);
                    Toast.makeText(EditerProduit.this, R.string.msgEdi, Toast.LENGTH_LONG).show();
                    el.getText().clear();
                    ef.getText().clear();
                    epa.getText().clear();
                    epv.getText().clear();
                    el.requestFocus();
                }
            }
        });
    }
}