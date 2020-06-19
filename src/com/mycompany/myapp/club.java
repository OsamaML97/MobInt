package com.mycompany.myapp;

public class club {

	  private int idclub ;
	  private String nomclub;
	  private String cap ;
	  
	  
	  public club()
	  {
		  
	  }


	public club(int idclub, String nomclub, String cap) {
	
		this.idclub = idclub;
		this.nomclub = nomclub;
		this.cap = cap;
	}


	public club(String nomclub, String cap) {
		
		this.nomclub = nomclub;
		this.cap = cap;
	}


	public int getIdclub() {
		return idclub;
	}


	public void setIdclub(int idclub) {
		this.idclub = idclub;
	}


	public String getNomclub() {
		return nomclub;
	}


	public void setNomclub(String nomclub) {
		this.nomclub = nomclub;
	}


	public String getCap() {
		return cap;
	}


	public void setCap(String cap) {
		this.cap = cap;
	}


	@Override
	public String toString() {
		return "club [idclub=" + idclub + ", nomclub=" + nomclub + ", cap=" + cap + "]";
	}
	  
	
	
	
	
}
