
package co.edu.udea.MVCDAO.control;

import co.edu.udea.MVCDAO.modelo.EstudianteDTO;
import co.edu.udea.MVCDAO.negocio.EstudianteNegocio;
import static java.lang.String.valueOf;
import java.util.List;
import javax.swing.JOptionPane;

public class EstudianteControlador {
    private EstudianteNegocio estudianteNegocio = new EstudianteNegocio();
    
    private static boolean isNumeric(String cadena){
    try {
        Integer.parseInt(cadena);
        return true;
    } catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null,"La identificacion no puede contener caracteres distintos a numeros.");
        e.printStackTrace();
    }
    return false;
}
    
    public boolean storeEstudiante(EstudianteDTO estudiante)
    {
        for(int i = 0; i < 10; i++)
        {
            String n = valueOf(i);
            if(estudiante.getNombre().contains(n))
            {
                JOptionPane.showMessageDialog(null,"El nombre no puede contener numeros.");
                return false;
            }
            if(estudiante.getApellidos().contains(n))
            {
                JOptionPane.showMessageDialog(null,"El apellido no puede contener numeros.");
                return false;
            }
        }   
        if(!isNumeric(estudiante.getIdentificacion()))
        {
            JOptionPane.showMessageDialog(null,"El documento no puede contener algo distinto a numeros");
            return false;
        }
        return estudianteNegocio.storeEstudiante(estudiante);
    }
    
    public List<EstudianteDTO> listEstudiantes()
    {
        return estudianteNegocio.listEstudiantes();
    }
    
    public EstudianteDTO searchEstudiante(String documento)
    {
        return estudianteNegocio.searchEstudiante(documento);
    }
    
    public boolean deleteEstudiante(String documento)
    {
        return estudianteNegocio.deleteEstudiante(documento);
    }
    
    public boolean updateEstudiante(EstudianteDTO parametro)
    {
        for(int i = 0; i < 10; i++)
        {
            String n = valueOf(i);
            if(parametro.getNombre().contains(n))
            {
                JOptionPane.showMessageDialog(null,"El nombre no puede contener numeros.");
                return false;
            }
            if(parametro.getApellidos().contains(n))
            {
                JOptionPane.showMessageDialog(null,"El apellido no puede contener numeros.");
                return false;
            }
        }   
        if(!isNumeric(parametro.getIdentificacion()))
        {
            JOptionPane.showMessageDialog(null,"El documento no puede contener algo distinto a numeros");
            return false;
        }
        return estudianteNegocio.updateEstudiantes(parametro);
    }
    
    public boolean updateBaseDatos()
    {
        return estudianteNegocio.updateBaseDatos();
    }
}
