package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class nouveau_produit extends AppCompatActivity {

    MyDBProduit db;
    Button btn;
    EditText el,ef,epa,epv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_produit);
        db=new MyDBProduit(this);
        btn=findViewById(R.id.add);
        el=findViewById(R.id.lib);
        ef=findViewById(R.id.fam);
        epa=findViewById(R.id.pra);
        epv=findViewById(R.id.prv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(el.getText().toString().isEmpty() || ef.getText().toString().isEmpty()
                        || epa.getText().toString().isEmpty() || epv.getText().toString().isEmpty())

                    Toast.makeText(nouveau_produit.this, R.string.msgErr, Toast.LENGTH_LONG).show();
                else {
                    MyDBProduit.insertProduit(db.getWritableDatabase(),new Produit(1,el.getText().toString(),ef.getText().toString(),Double.valueOf(epa.getText().toString()),Double.valueOf(epv.getText().toString())));
                    Toast.makeText(nouveau_produit.this, R.string.msgAdd, Toast.LENGTH_LONG).show();
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