package com.biblioteca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.biblioteca.db.BaseDeDatos;
import com.biblioteca.model.Libro;

public class LibroDAO {
	
	private String actualizaStock(Libro l) {
		String sqlUpdate =  "UPDATE \"GestionBiblioteca\".libros l "+
    						"SET cantidad = l.cantidad + 1 "+
    						"WHERE id = ?",
			   sqlSelect =  "SELECT l.* "+
					   		"FROM \"GestionBiblioteca\".libros l "+ 
					   		"WHERE l.nombre  = ? AND " +
					   			  "l.autores = ? AND "+
					   			  "l.genero  = ?";
		try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sqlSelect)){
			stmt.setString(1,l.getNombre());
			stmt.setString(2,l.getAutor());
			stmt.setString(3,l.getGenero());
			try(ResultSet res = stmt.executeQuery()){
				if (res.next()) {
				    int idLibro = res.getInt("id"); // nombre exacto de la columna en tu BD
				    System.out.println("ID del libro encontrado: " + idLibro);
				    
				    try(PreparedStatement stmt2 = BaseDeDatos.getConexion().prepareStatement(sqlUpdate)){
				    	stmt2.setInt(1,idLibro);
				    	 int rowsAffected = stmt2.executeUpdate();
				    	 if (rowsAffected == 0) {
			                return "Ninguna fila fue afectada. Revisar";
				    	 }
				    	 if(rowsAffected > 1) {
			            	return "Más de una fila fue afectada. Revisar";
				    	 }
				    }
				    
				}else return "No se encontró un libro con esos datos en el Stock.";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return "Ocurrió un error al intentar verificar si existe el libro en el sistema: "+e.getMessage();
		}
		return "";
	}
	private String insertarStock(Libro l) {
		String sqlInsert = "";
		return "";
	}
	public String insertar(Libro l) {
		String sqlTest = "SELECT count(*) "+
						 "FROM \"GestionBiblioteca\".libros l "+
						 "WHERE l.nombre  = ? AND " +
						       "l.autores = ? AND "+
						       "l.genero  = ?";
		try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sqlTest)){
			stmt.setString(1,l.getNombre());
			stmt.setString(2,l.getAutor());
			stmt.setString(3,l.getGenero());
			try(ResultSet res = stmt.executeQuery()){
				res.next();
				int cant = res.getInt(1);
				String cadRes;
				if(cant > 0) {
					cadRes = actualizaStock(l);
					if(!cadRes.isEmpty()) {
						return cadRes;
					}
				}else {
					insertarStock(l);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return "Ocurrió un error al intentar verificar si existe el libro en el sistema: "+e.getMessage();
		}
		return "";
	}
}
