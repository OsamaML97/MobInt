/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author OsamaML97
 */
public class Event {
    
    private int id;
    private String EvName;
    private String EvMonth;
    private String EvStart;
    private String EvEnd;
    private String EvPur;
    private String EvDesc;

    public Event() {
    }

    public Event( int id ,String EvName, String EvMonth, String EvStart, String EvEnd, String EvPur, String EvDesc) {
        this.id=id;
        this.EvName = EvName;
        this.EvMonth = EvMonth;
        this.EvStart = EvStart;
        this.EvEnd = EvEnd;
        this.EvPur = EvPur;
        this.EvDesc = EvDesc;
    }
    
    public Event( String EvName, String EvMonth, String EvStart, String EvEnd, String EvPur, String EvDesc) {
        
        this.EvName = EvName;
        this.EvMonth = EvMonth;
        this.EvStart = EvStart;
        this.EvEnd = EvEnd;
        this.EvPur = EvPur;
        this.EvDesc = EvDesc;
    }
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getEvName() {
        return EvName;
    }

    public void setEvName(String EvName) {
        this.EvName = EvName;
    }

    public String getEvMonth() {
        return EvMonth;
    }

    public void setEvMonth(String EvMonth) {
        this.EvMonth = EvMonth;
    }

    public String getEvStart() {
        return EvStart;
    }

    public void setEvStart(String EvStart) {
        this.EvStart = EvStart;
    }

    public String getEvEnd() {
        return EvEnd;
    }

    public void setEvEnd(String EvEnd) {
        this.EvEnd = EvEnd;
    }

    public String getEvPur() {
        return EvPur;
    }

    public void setEvPur(String EvPur) {
        this.EvPur = EvPur;
    }

    public String getEvDesc() {
        return EvDesc;
    }

    public void setEvDesc(String EvDesc) {
        this.EvDesc = EvDesc;
    }

    @Override
    public String toString() {
        return "Events{" + "id=" + id + ", EvName=" + EvName + ", EvMonth=" + EvMonth + ", EvStart=" + EvStart + ", EvEnd=" + EvEnd + ", EvPur=" + EvPur + ", EvDesc=" + EvDesc + '}';
    }

  
   
    
    
    
    
    
}
