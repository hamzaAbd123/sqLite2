package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
       MyDBProduit db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//       db= new MyDBProduit(this);
//       ArrayList<Produit> prds= new ArrayList<>();
//
//        prds.add(new Produit(1,"produit1","Liquide",12.4,22));
//        prds.add(new Produit(1,"produit1","Liquide",12,23));
//      prds.add(new Produit(1,"produit1","Liquide",15,29)) ;
//      prds.add(new Produit(1,"produit1","Liquide",20,29));
//       prds.add(new Produit(1,"produit1","Liquide",13,30)) ;
//
//      for (Produit p :prds)
//           MyDBProduit.insertProduit(db.getWritableDatabase(),p);


    }

    public void acceder(View view) {
        Intent i= null;

        switch (view.getId()){
        case R.id.btn1:
            i=new Intent(this,AllProduit.class);
            break;
        case R.id.btn2:
        i=new Intent(this,ficheProduit.class);
        break;
        case R.id.btn3:
        i=new Intent(this,nouveau_produit.class);
        break;
        case R.id.btn4:
        i=new Intent(this,EditerProduit.class);
        break;

    }
    startActivity(i);
    }
}