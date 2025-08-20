package com.biblioteca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.biblioteca.db.BaseDeDatos;
import com.biblioteca.model.Libro;

import utiles.ConstruirConsulta;

public class LibroDAO {
	
	private String actualizaStock(Libro l, int cantidad) {
		String sqlUpdate =  "UPDATE \"GestionBiblioteca\".stock l "+
    						"SET cantidad = l.cantidad + ? "+
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
				    	stmt2.setInt(1,cantidad);
				    	stmt2.setInt(2,idLibro);
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
	private String crearStock(int cantidad, int id) {
		String error = "", 
			   sqlInsert = "INSERT INTO \"GestionBiblioteca\".stock(cantidad, libro_id) VALUES(?,?)";
		try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sqlInsert) ){
			stmt.setInt(1, cantidad);
			stmt.setInt(2, id);
			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected == 0) {
				error = "No fue posible agregar en Stock el Libro.";
			}
			if(rowsAffected > 1){
				error = "Más de una fila fue afectada. Revisar.";
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			error = "Ocurrió un error al intentar agregar en Stock: "+e.getMessage();
		}
		return error;
	}
	private String insertarStock(Libro l, int cantidad) {
		String sqlInsert = "INSERT INTO \"GestionBiblioteca\".libros(nombre, autores, genero) values(?,?,?)",
			   error     = "";
		try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sqlInsert)){
			stmt.setString(1, l.getNombre());
			stmt.setString(2, l.getAutor());
			stmt.setString(3, l.getGenero());
			
			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected > 0) {
				try(ResultSet generatedKey = stmt.getGeneratedKeys()){
					if(generatedKey.next()) {
						l.setId(generatedKey.getInt(1));
						error = crearStock(cantidad, l.getId());
					}
				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
			error = "Ocurrió un error al crear al Libro: "+e.getMessage();
 		}
		return error;
	}
	public String insertar(Libro l, int cantidad) {
		String sqlTest = "SELECT count(*) "+
						 "FROM \"GestionBiblioteca\".libros l "+
						 "WHERE l.nombre  = ? AND " +
						       "l.autores = ? AND "+
						       "l.genero  = ?",
			   error = "";
		try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sqlTest)){
			stmt.setString(1,l.getNombre());
			stmt.setString(2,l.getAutor());
			stmt.setString(3,l.getGenero());
			try(ResultSet res = stmt.executeQuery()){
				res.next();
				int cant = res.getInt(1);
				String cadRes;
				if(cant > 0) {
					cadRes = actualizaStock(l, cantidad);
					if(!cadRes.isEmpty()) {
						return cadRes;
					}
				}else {
					error = insertarStock(l, cantidad);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return "Ocurrió un error al intentar verificar si existe el libro en el sistema: "+e.getMessage();
		}
		return error;
	}
	public String eliminar(int id) {
		String error = "",
			   sqlSelect = "SELECT count(*) "+
					       "FROM \"GestionBiblioteca\".libros l "+
					       "WHERE l.id = ?";
		
		//Busco si existe en el sistema
		try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sqlSelect)){
			stmt.setInt(1, id);
			int cant = 0;
			try(ResultSet rs = stmt.executeQuery()){
				rs.next();
				cant = rs.getInt(1);
				if(cant == 0) {
					return "No fue posible encontrar el libro en el sistema.";
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return "Ocurrió un error al intentar verificar que el libro existe en el sistema para eliminarlo: "+e.getMessage();
		}
		
		//Si llegué hasta aquí elimino en la tabla Stock
		String sqlDeleteStock = "DELETE FROM \"GestionBiblioteca\".stock s "+
				   				"WHERE s.libro_id = ?";
		try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sqlDeleteStock)){
			stmt.setInt(1, id);
			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected == 0) {
				error = "Ninguna fila fue afectada. Revisar.";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			error = "Ocurrió un problema al intentar eliminar el Stock: "+e.getMessage(); 
		}
		
		//Si llegué aquí procedo a eliminar en libro
		String sqlDeleteLibros = "DELETE FROM \"GestionBiblioteca\".libros l "+
						         "WHERE l.id = ?";
		try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sqlDeleteLibros)){
			stmt.setInt(1, id);
			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected == 0) {
				error = "Ninguna fila fue afectada. Revisar.";
			}
			if(rowsAffected > 1) {
				error = "Más de una fila fue afectada. Revisar.";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			error = "Ocurrió un problema al intentar eliminar al Libro: "+e.getMessage(); 
		}
		
		return error;
	}
	private String actualizarStock(int id, int cantidad) {
		String error = "",
			   sqlUpdate = "UPDATE \"GestionBiblioteca\".stock s "+
					   	   "SET cantidad = ? "+
					   	   "WHERE libro_id = ?";
		try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sqlUpdate)){
			stmt.setInt(1, cantidad);
			stmt.setInt(2, id);
			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected == 0) {
				return "No se actualizó ningun stock. Revisar";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			error = ""+e.getMessage();
		}
		return error;
	}
	public String actualizar(int id, String pNom, String pAutores, String pGenero, int cantidad) {
		String error = "", sqlSelect = "", sqlUpdate = "";
		
		//Controlo que exista
		sqlSelect = "SELECT count(*) "+
				    "FROM \"GestionBiblioteca\".libros l "+
				    "WHERE l.id = ?";
		try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sqlSelect)){
			stmt.setInt(1, id);
			int cant = 0;
			try(ResultSet rs = stmt.executeQuery()){
				rs.next();
				cant = rs.getInt(1);
				if(cant == 0) {
					return "No fue posible encontrar el libro que deseas actualizar.";
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return "Ocurrió un problema al obtener los datos del Libro: "+e.getMessage();
		}
		
		//Si llegué existe -> debo editar
		sqlUpdate = "UPDATE \"GestionBiblioteca\".libros "+
					"SET nombre = ?, autores = ?, genero  = ? "+
					"WHERE id = ?"; 
		try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sqlUpdate)){
			stmt.setString(1, pNom);
			stmt.setString(2, pAutores);
			stmt.setString(3, pGenero);
			stmt.setInt(2, id);
			
			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected == 0) {
				error = "No se actualizó ninguna fila. Revisar.";
			}
			if(rowsAffected > 1) {
				error = "Se actualizó más de una fila. Revisar.";
			}
			if(rowsAffected == 1) {
				error = actualizarStock(id, cantidad);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			error = "Ocurrió asl intentar actualizar los datos del Libro: "+e.getMessage();
		}
		return error;
	}
	public ArrayList<Libro> buscarConFiltros(Map<String, Object> filtros){
		ArrayList<Libro> libros = new ArrayList<Libro>();
		ArrayList<Object> valores;
		ConstruirConsulta consulta = new ConstruirConsulta("SELECT * FROM \"GestionBiblioteca\".libros l WHERE 1 = 1");
		StringBuilder sql;
		
		sql = consulta.crearConsulta(filtros);
        valores = consulta.getValores();
		
        try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sql.toString())){
        	for(int i=0; i<valores.size() ;i++) {
        		stmt.setObject(i+1, valores.get(i));
        	}
        	try(ResultSet rs = stmt.executeQuery()){
        		while(rs.next()) {
        			Libro l = new Libro();
        			l.setId(rs.getInt("id"));
        			l.setNombre(rs.getString("nombre"));
        			l.setAutor(rs.getString("autores"));
        			l.setGenero(rs.getString("genero"));
        			libros.add(l);
        		}
        	}
        }catch(SQLException e) {
        	e.printStackTrace();
        	System.out.println("Error al buscar los libros.");
        }
        
		return libros;
	}
	public Libro buscar(int id) {
		Libro l = null;
		String sql = "SELECT * FROM \"GestionBiblioteca\".libros l WHERE l.id = ?";
		
		try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sql)){
			stmt.setInt(1, id);
			int cant = 0;
			try(ResultSet rs = stmt.executeQuery()){
				rs.next();
				cant = rs.getInt(1);
				if(cant == 0) {
					return l;
				}
				l = new Libro();
				l.setId(rs.getInt("id"));
				l.setNombre(rs.getString("nombre"));
				l.setAutor(rs.getString("autores"));
				l.setGenero(rs.getString("genero"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}
}
