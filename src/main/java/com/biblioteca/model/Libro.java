package com.biblioteca.model;

import java.util.Objects;

public class Libro {
	//Atributos
	private int    id;
	private String nombre;
	private String autor;
	private String genero;
	private int cantidad;
	
	//Constructor
	public Libro() {		
	}
	public Libro(String pNombre, String pAutor, String pGenero) {		
		this.nombre = pNombre;
		this.autor  = pAutor;
		this.genero = pGenero;
	}
	
	//Methods
	public int getId() { return this.id; }
	public void setId(int id) { this.id = id; }
	
	public String getNombre() { return this.nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	
	public String getAutor() { return this.autor; }
	public void setAutor(String autor) { this.autor = autor; }
	
	public String getGenero() { return this.genero; }
	public void setGenero(String genero) { this.genero = genero; }
	
	public void setCantidad(int cant) { this.cantidad = cant; }
	public int getCantidad() { return this.cantidad; }	
	
	public boolean equals(Object obj) {
		if(this == obj) { return true; }
		if(obj == null || getClass() != obj.getClass()) { return false; }
		Libro l = (Libro)obj;
		return (Objects.equals(l.id, this.id) && Objects.equals(l.nombre, this.nombre));
	}
	
	public String toString() {
		String str = "";
		str += "Id: "+this.id+"\n";
		str += "Nombre: "+this.nombre+"\n";
		str += "Autor: "+this.autor+"\n";
		str += "Genero: "+this.genero+"\n";
		str += "Cantidad: "+this.cantidad+"\n";
		return str;
	}
}
