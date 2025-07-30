package com.biblioteca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.biblioteca.db.BaseDeDatos;
import com.biblioteca.model.Socio;

public class SocioDAO {

    public String insertar(Socio s) {
    	String sqlTest = "SELECT count(*) "+
		        		 "FROM \"GestionBiblioteca\".socios s "+
		        		 "WHERE s.nombre = ? and "+
		        		       "s.email = ? and "+
		        		       "s.dni = ?";
		try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sqlTest)){
			stmt.setString(1,s.getNombre());
			stmt.setString(2,s.getCorreo());
			stmt.setInt(3, s.getDni());
		  int cant = 0;
		  try(ResultSet rs = stmt.executeQuery()){
		  	rs.next(); // Solo una fila
		      cant = rs.getInt(1);
		      if(cant > 0 ) {
		      		return "El socio que intentas registrar ya existe en el sistema.";
		      }
		  }
		}catch(SQLException e) {
			e.printStackTrace();
		  return "Ocurrió un error al intentar verificar si ya existe este socio: "+e.getMessage();
		}
		
        String sql = "INSERT INTO \"GestionBiblioteca\".socios (nombre, apellido, dni, email, nro_telefono) VALUES (?, ?, ?, ?, ?)";
        String error = "";
        try (PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sql)) {
            stmt.setString(1, s.getNombre());
            stmt.setString(2, s.getApellido());
            stmt.setInt(3, s.getDni());
            stmt.setString(4, s.getCorreo());
            stmt.setString(5, s.getNroTel());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                // Recupera el ID generado
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        s.setId(generatedKeys.getInt(1)); // asigna el ID generado al objeto
                        System.out.println("Socio creado con ID: " + s.getId());
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // podés delegar el manejo a una clase logger también
            error = "Ocurrió un error al crear el Socio: "+e.getMessage();
        }
        return error;
    }
    public String eliminar(int id) {
    	String sqlTest = "SELECT count(*) "+
		         		 "FROM \"GestionBiblioteca\".socios s "+
		         		 "WHERE s.id = ?";
		try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sqlTest)){
		   stmt.setInt(1, id);
		   int cant = 0;
		   try(ResultSet rs = stmt.executeQuery()){
		   	rs.next(); // Solo una fila
		       cant = rs.getInt(1);
		       System.out.println("cant: "+cant);
		       if(cant == 0 ) {
		       		return "No se pudo encontrar el socio con el ID: "+id+".";
		       }
		   }
		}catch(SQLException e) {
			e.printStackTrace();
		   return "Ocurrió un error al intentar obtener el Socio: "+e.getMessage();
		}
    	
    	String error = "",
    		   sql   = "DELETE FROM \"GestionBiblioteca\".socios s WHERE s.id = ?";
    	try (PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sql)){
    		stmt.setInt(1, id);
    		int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                error = "Ninguna fila fue afectada. Revisar";
            }
            if(rowsAffected > 1) {
            	error = "Màs de una fila fue afectada. Revisar";
            }
            //si es exitoso se devuelve cadena vacia para informar en el gui que todo fue ok
    	}catch(SQLException e) {
    		e.printStackTrace(); 
            error = "Ocurrió un error al eliminar el Socio: "+e.getMessage();
    	}
    	return error;
    }
    public String actualizar(int id, String nombre, String apellido, String email, String nroTel, int dni) {
    	String sqlTest = "SELECT count(*) "+
    			         "FROM \"GestionBiblioteca\".socios s "+
    			         "WHERE s.id = ?";
    	try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sqlTest)){
            stmt.setInt(1, id);
            int cant = 0;
            try(ResultSet rs = stmt.executeQuery()){
            	rs.next(); // Solo una fila
                cant = rs.getInt(1);
                if(cant == 0 ) {
                	return "No se pudo encontrar el socio con el ID: "+id+".";
                }
            }
    	}catch(SQLException e) {
    		e.printStackTrace();
            return "Ocurrió un error al intentar obtener el Socio: "+e.getMessage();
    	}
    	
    	String error = "",
     		   sql   = "UPDATE \"GestionBiblioteca\".socios s "+
     		   		   "SET nombre   = ?, "+
     		   		       "apellido = ?, "+
     		   		       "email    = ?, "+
     		   		       "nro_telefono  = ?, "+
     		   		       "dni      = ? "+
     				   "WHERE s.id = ?";
    	try(PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sql)){
    		stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, email);
            stmt.setString(4, nroTel);
            stmt.setInt(5, dni);
            stmt.setInt(6, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                error = "Ninguna fila fue afectada. Revisar";
            }
            if(rowsAffected > 1) {
            	error = "Más de una fila fue afectada. Revisar";
            }
    	}catch(SQLException e) {
    		e.printStackTrace();
            error = "Ocurrió un error al actualizar el Socio: "+e.getMessage();
    	}
    	return error;
    }
    public ArrayList<Socio> buscarConFiltros(Map<String, Object> filtros) {
        ArrayList<Socio> socios = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM \"GestionBiblioteca\".socios WHERE 1=1 ");
        ArrayList<Object> valores = new ArrayList<>();

        for (String campo : filtros.keySet()) {
            Object valor = filtros.get(campo);
            if (valor instanceof String) {
                sql.append("AND ").append(campo).append(" ILIKE ? ");
                valores.add("%" + valor + "%");
            } else {
                sql.append("AND ").append(campo).append(" = ? ");
                valores.add(valor);
            }
        }

        try (PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sql.toString())) {
            for (int i = 0; i < valores.size(); i++) {
                stmt.setObject(i + 1, valores.get(i));
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Socio s = new Socio();
                    s.setId(rs.getInt("id"));
                    s.setNombre(rs.getString("nombre"));
                    s.setApellido(rs.getString("apellido"));
                    s.setDni(rs.getInt("dni"));
                    s.setCorreo(rs.getString("email"));
                    s.setNroTel(rs.getString("nro_telefono"));
                    socios.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return socios;
    }
    public Socio buscar(int id) {
        Socio s = null;
        String sql = new String("SELECT * FROM \"GestionBiblioteca\".socios s WHERE s.id = ? ");

        try (PreparedStatement stmt = BaseDeDatos.getConexion().prepareStatement(sql)) {
        	stmt.setInt(1, id);
        	
        	int cant = 0;        	
            try (ResultSet rs = stmt.executeQuery()) {
            	
            	rs.next(); // Solo una fila
                cant = rs.getInt(1);
                if(cant == 0 ) {
                	return s;
                }
            	
            	s = new Socio();
                s.setId(rs.getInt("id"));
                s.setNombre(rs.getString("nombre"));
                s.setApellido(rs.getString("apellido"));
                s.setDni(rs.getInt("dni"));
                s.setCorreo(rs.getString("email"));
                s.setNroTel(rs.getString("nro_telefono"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }
}