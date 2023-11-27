package com.example.practica3desplegaments.models;

public class Producte {
    private int id;
    private String nom;
    private double preu;
    private String descripcio;
    private String categoria;

    public Producte(int id, String nom, double preu, String descripcio, String categoria) {
        this.id = id;
        this.nom = nom;
        this.preu = preu;
        this.descripcio = descripcio;
        this.categoria = categoria;
    }

    public Producte() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
