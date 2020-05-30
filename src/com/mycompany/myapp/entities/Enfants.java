/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author bhk
 */
public class Enfants {
    
    private int id;
    private String nom;
    private String prenom;
    private String sexe;
    private String lieuN;
    private String dateN;
    private String medicin;
    private int MedNum;

    public Enfants(int id, String nom, String prenom, String sexe, String lieuN, String dateN, String medicin, int MedNum) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.lieuN = lieuN;
        this.dateN = dateN;
        this.medicin = medicin;
        this.MedNum = MedNum;
    }
    public Enfants( String nom, String prenom, String sexe, String lieuN, String dateN, String medicin, int MedNum) {
       
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.lieuN = lieuN;
        this.dateN = dateN;
        this.medicin = medicin;
        this.MedNum = MedNum;
    }

    public Enfants() {
         //To change body of generated methods, choose Tools | Templates.
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getLieuN() {
        return lieuN;
    }

    public void setLieuN(String lieuN) {
        this.lieuN = lieuN;
    }

    public String getDateN() {
        return dateN;
    }

    public void setDateN(String dateN) {
        this.dateN = dateN;
    }



   

    public String getMedicin() {
        return medicin;
    }

    public void setMedicin(String medicin) {
        this.medicin = medicin;
    }

    public int getMedNum() {
        return MedNum;
    }

    public void setMedNum(int MedNum) {
        this.MedNum = MedNum;
    }

    @Override
    public String toString() {
        return "Enfant{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", lieuN=" + lieuN + ", dateN=" + dateN + ", medicin=" + medicin + ", MedNum=" + MedNum + '}';
    }
    
    
    
}


;