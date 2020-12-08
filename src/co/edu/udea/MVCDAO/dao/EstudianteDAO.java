
package co.edu.udea.MVCDAO.dao;

import co.edu.udea.MVCDAO.modelo.EstudianteDTO;
import java.util.List;

// CRUDI de gestion de datos
// Create, Read, Update, Delete, Listar
public interface EstudianteDAO 
{
    public boolean storeEstudiante(EstudianteDTO estudiante);
    public EstudianteDTO searchEstudiante(String documento); // x documento tambien que locha
    public List<EstudianteDTO> listEstudiantes(); // Listar TODOS los estudiantes
    public boolean deleteEstudiante(String documento); //Se asume que se ingresa el documento para buscar al estudiante x
    public boolean updateEstudiantes(EstudianteDTO parametro); // Jeje no se ayuda
    public boolean updateBaseDatos(); // AJUAAAA
}
