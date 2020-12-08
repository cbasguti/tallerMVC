
package co.edu.udea.MVCDAO.negocio;

import co.edu.udea.MVCDAO.dao.EstudianteDAO;
import co.edu.udea.MVCDAO.dao.impl.EstudianteDAOFile;
import co.edu.udea.MVCDAO.modelo.EstudianteDTO;
import java.util.List;
import javax.swing.JOptionPane;


public class EstudianteNegocio 
{
    EstudianteDAOFile estudianteDAO = new EstudianteDAOFile();
	
    public boolean storeEstudiante(EstudianteDTO estudiante){
        EstudianteDTO buscado = estudianteDAO.searchEstudiante(estudiante.getIdentificacion());
        if(estudianteDAO.getList().getLista().contains(buscado))
        {
            JOptionPane.showMessageDialog(null,"Ya existe un estudiante con ese # de documento.");
            return false;
        }
        return estudianteDAO.storeEstudiante(estudiante);
    }

    public List<EstudianteDTO> listEstudiantes(){
        return estudianteDAO.listEstudiantes();
    }
    
    public EstudianteDTO searchEstudiante(String documento)
    {
        EstudianteDTO buscado = estudianteDAO.searchEstudiante(documento);
        if(!estudianteDAO.getList().getLista().contains(buscado))
        {
            JOptionPane.showMessageDialog(null,"No existe un estudiante con ese # de documento.");
            return null;
        }
        return estudianteDAO.searchEstudiante(documento);
    }
    
    public boolean deleteEstudiante(String documento)
    {
        EstudianteDTO buscado = estudianteDAO.searchEstudiante(documento);
        if(!estudianteDAO.getList().getLista().contains(buscado))
        {
            JOptionPane.showMessageDialog(null,"No existe un estudiante con ese # de documento.");
            return false;
        }
        return estudianteDAO.deleteEstudiante(documento);
    }
    
    public boolean updateEstudiantes(EstudianteDTO parametro)
    {
        return estudianteDAO.updateEstudiantes(parametro);
    }
    
    public boolean updateBaseDatos()
    {
        return estudianteDAO.updateBaseDatos();
    }

}
