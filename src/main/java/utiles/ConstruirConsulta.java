package utiles;

import java.util.ArrayList;
import java.util.Map;

public class ConstruirConsulta {
	private String consulta;
	private ArrayList<Object> valores;
	
	public ConstruirConsulta(String sql) {
		this.consulta = sql;
		this.valores = new ArrayList<>();
	}
	
	public StringBuilder crearConsulta(Map<String, Object> filtros) {
		StringBuilder sql = new StringBuilder(this.consulta); 
		
		for (String campo : filtros.keySet()) {
            Object valor = filtros.get(campo);
            if (valor instanceof String) {
                sql.append(" AND ").append(campo).append(" ILIKE ? ");
                valores.add("%" + valor + "%");
            } else {
                sql.append(" AND ").append(campo).append(" = ? ");
                valores.add(valor);
            }
        }
		return sql;
	}
	public ArrayList<Object> getValores(){ return this.valores; }
}
