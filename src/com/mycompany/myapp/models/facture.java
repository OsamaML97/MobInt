/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author aymen
 */
public class facture {
    private int id;
    private float montant;
    private Date delais;
    private int id_user;
       private String Etat;

    public facture() {
    }

    public facture(float montant, Date delais, int id_user, String Etat) {
        this.montant = montant;
        this.delais = delais;
        this.id_user = id_user;
        this.Etat = Etat;
    }

    public facture(int id, float montant, Date delais, int id_user, String Etat) {
        this.id = id;
        this.montant = montant;
        this.delais = delais;
        this.id_user = id_user;
        this.Etat = Etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Date getDelais() {
        return delais;
    }

    public void setDelais(Date delais) {
        this.delais = delais;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }
       
       
}
