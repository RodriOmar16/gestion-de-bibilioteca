package com.biblioteca.model;

public class Socio {
	//Atributos
	private String  nombre;
	private String  apellido;
	private String  email;
	private String  nroTel;
	private int     dni;
	private int     id;
	
	//Constructor
	public Socio() {
	}
	public Socio(String pNombre, String pApellido, int pDni, String pEmail, String pNroTel) {
		this.nombre   = pNombre;
		this.apellido = pApellido;
		this.dni	  = pDni;
		this.email	  = pEmail;
		this.nroTel	  = pNroTel;
	}
	
	//Methods
	public String getNombre()   { return this.nombre; }
	public String getApellido() { return this.apellido; }
	public String getNroTel()   { return this.nroTel; }
	public String getCorreo()   { return this.email; }
	public int getDni()         { return this.dni; }
	public int getId() 		    { return this.id; }
	
	public void setNombre(String pNombre)     { this.nombre   = pNombre; }
	public void setApellido(String pApellido) { this.apellido = pApellido; }
	public void setNroTel(String pNroTel) 	  { this.nroTel   = pNroTel; }
	public void setCorreo(String pCorreo)     { this.email	  = pCorreo; }
	public void setDni(int pDni) 			  { this.dni	  = pDni; }
	public void setId(int id) 				  { this.id       = id; }
	
	public boolean equals(Object obj) {
		if(this == obj) { return true; }
		if(obj == null || getClass() != obj.getClass()) { return false; }
		Socio s = (Socio) obj;
		return (this.id == s.id && this.dni == s.dni);
	}

}
