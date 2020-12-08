
package co.edu.udea.MVCDAO.dao.impl;

import co.edu.udea.MVCDAO.dao.EstudianteDAO;
import co.edu.udea.MVCDAO.modelo.EstudianteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EstudianteDAOList implements EstudianteDAO
{
    public static final List<EstudianteDTO> estudiantesBD = new ArrayList<EstudianteDTO>();
    
    public List<EstudianteDTO> getLista()
    {
        return estudiantesBD;
    }
    
    @Override
    public boolean storeEstudiante(EstudianteDTO estudiante) 
    {
        estudiantesBD.add(estudiante);
        return true;
    }

    @Override
    public EstudianteDTO searchEstudiante(String identificacion) 
    {
        for (EstudianteDTO estudiante : estudiantesBD)
        {
            if (estudiante.getIdentificacion().equals(identificacion))
            return estudiante;
        }
        return null;
    }

    @Override
    public List<EstudianteDTO> listEstudiantes() 
    {
        List<EstudianteDTO> estudiantes = new ArrayList<>();
        for(EstudianteDTO estudiante : estudiantesBD)
        {
            estudiantes.add(estudiante);
        }
        return estudiantes;
    }

    @Override
    public boolean deleteEstudiante(String documento)
    {
        for(EstudianteDTO estudiante : estudiantesBD)
        {
            if(estudiante.getIdentificacion().equals(documento))
            {
                estudiantesBD.remove(estudiante);
                return true;
            }
        }
        JOptionPane.showMessageDialog(null,"No se encontro el estudiante en la base de datos.");
        return false;
    }

    @Override
    public boolean updateEstudiantes(EstudianteDTO parametro) 
    {
        for(EstudianteDTO estudiante : estudiantesBD)
        {
            if(estudiante.getIdentificacion().equals(parametro.getIdentificacion()))
            {
                estudiantesBD.remove(estudiante);
                estudiantesBD.add(parametro);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean updateBaseDatos()
    {
        return false;
    }
    
}
