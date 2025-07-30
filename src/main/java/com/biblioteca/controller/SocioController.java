package com.biblioteca.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.JFrame;

import com.biblioteca.dao.SocioDAO;
import com.biblioteca.model.Socio;
import com.biblioteca.vista.socio.NuevoEditarSocioDialog;

import interfaces.AccionFilaController;

public class SocioController implements AccionFilaController{
	//Atributos
	private SocioDAO socioDAO;
	
	//Constructos
	public SocioController() {
		this.socioDAO = new SocioDAO();
	}
	
	//Methods
	public String agregarNuevoSocio(String nombre, String apellido, String email, String nroTel, int dni) {
		Socio nuevo = new Socio(nombre, apellido, dni, email, nroTel);
		String res = this.socioDAO.insertar(nuevo);
		return res; //si el lengh == 0 entonces no hay error sigo, sino muestro error;
	}
	public String eliminarSocio(int id) {
		String res = this.socioDAO.eliminar(id);
		return res; //si el lengh == 0 entonces no hay error sigo, sino muestro error;
	}
	public String actualizarSocio(int id, String nombre, String apellido, String email, String nroTel, int dni) {
		String res = this.socioDAO.actualizar(id, nombre, apellido, email, nroTel, dni);
		return res; //si el lengh == 0 entonces no hay error sigo, sino muestro error;
	}
	public ArrayList<Socio> buscarSocios(Map<String, Object> filtros){
		return this.socioDAO.buscarConFiltros(filtros);
	}
	public Socio buscarSocio(int id){
		return this.socioDAO.buscar(id);
	}
	
	@Override
    public Socio obtenerEntidadPorId(int id) {
        return buscarSocio(id);
    }

    @Override
    public String eliminarEntidad(int id) {
        return eliminarSocio(id);
    }

    @Override
    public void abrirEditor(JFrame parent, Object entidad) {
        Socio socio = (Socio) entidad;
        NuevoEditarSocioDialog dialog = new NuevoEditarSocioDialog(parent, this, socio, "Editar");
        dialog.setVisible(true);
    }
}
