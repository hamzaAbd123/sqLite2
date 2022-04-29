package com.example.sqlite;

import java.io.Serializable;

public class Produit implements Serializable {

   private int IDProduit;
    private  String Libelle;
    private String Famille;
    private double Prix_achat;
    private double Prix_vente;

    public Produit() {
    }

    public Produit(int IDProduit, String libelle, String famille, double prix_achat, double prix_vente) {
        this.IDProduit = IDProduit;
        Libelle = libelle;
        Famille = famille;
        Prix_achat = prix_achat;
        Prix_vente = prix_vente;
    }

    public int getIDProduit() {
        return IDProduit;
    }

    public void setIDProduit(int IDProduit) {
        this.IDProduit = IDProduit;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public String getFamille() {
        return Famille;
    }

    public void setFamille(String famille) {
        Famille = famille;
    }

    public double getPrix_achat() {
        return Prix_achat;
    }

    public void setPrix_achat(double prix_achat) {
        Prix_achat = prix_achat;
    }

    public double getPrix_vente() {
        return Prix_vente;
    }

    public void setPrix_vente(double prix_vente) {
        Prix_vente = prix_vente;
    }


}


