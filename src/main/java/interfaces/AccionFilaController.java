package interfaces;
import javax.swing.JFrame;

public interface AccionFilaController {
    Object obtenerEntidadPorId(int id);
    String eliminarEntidad(int id);
    void abrirEditor(JFrame parent, Object entidad);
}

