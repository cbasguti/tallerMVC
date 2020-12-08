/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.MVCDAO.dao.impl;

import co.edu.udea.MVCDAO.dao.EstudianteDAO;
import co.edu.udea.MVCDAO.modelo.EstudianteDTO;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.JOptionPane;

public class EstudianteDAOFile implements EstudianteDAO
{
    private static final String DELIMITADOR = ",";
    private static String ESTUDIANTEFILENAME = "estudiante.txt";
    private EstudianteDAOList estudiantesBD = new EstudianteDAOList();
    private BufferedWriter escritorBuffer;
    private BufferedReader lectorBuffer;
    private FileWriter escritorArchivo;
    private Scanner lector;
    private File archivoEstudiante;
    
    public EstudianteDAOFile()
    {
        archivoEstudiante = new File(ESTUDIANTEFILENAME);
        try{
            lector = new Scanner(archivoEstudiante);
            lector.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean storeEstudiante(EstudianteDTO estudiante) 
    {
        StringBuilder sb = new StringBuilder();
        sb.append(estudiante.getIdentificacion());
        sb.append(DELIMITADOR);
        sb.append(estudiante.getNombre());
        sb.append(DELIMITADOR);
        sb.append(estudiante.getApellidos());
        sb.append(DELIMITADOR);
        sb.append(estudiante.getGenero());
        
        try{
            escritorArchivo = new FileWriter(archivoEstudiante, true);
            escritorBuffer = new BufferedWriter(escritorArchivo);
            escritorBuffer.write(sb.toString());
            escritorBuffer.newLine();
            escritorBuffer.close();
            estudiantesBD.storeEstudiante(estudiante);
            return true;
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Algo no funcionó :c");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public EstudianteDTO searchEstudiante(String documento) {
        return estudiantesBD.searchEstudiante(documento);
    }

    @Override
    public List<EstudianteDTO> listEstudiantes() {
        return estudiantesBD.listEstudiantes();
    }
    
    public File createTemp()
    {
        File tempFile = new File("temp.txt");
        try{
            if(tempFile.createNewFile())
            {
                lector = new Scanner(tempFile);
                lector.close();
            }  
        }catch(IOException e){
            e.printStackTrace();
        } 
        return tempFile;
    }

    @Override
    public boolean deleteEstudiante(String documento) {
        EstudianteDTO estudiante;
        estudiante = estudiantesBD.searchEstudiante(documento);
        if(estudiante != null)
        {
            estudiantesBD.deleteEstudiante(estudiante.getIdentificacion());
            StringBuilder sb = new StringBuilder();
            sb.append(estudiante.getIdentificacion());
            sb.append(DELIMITADOR);
            sb.append(estudiante.getNombre());
            sb.append(DELIMITADOR);
            sb.append(estudiante.getApellidos());
            sb.append(DELIMITADOR);
            sb.append(estudiante.getGenero());          
            File tempFile = createTemp();
            try{
                lectorBuffer = new BufferedReader(new FileReader(archivoEstudiante));
                escritorArchivo = new FileWriter(tempFile,true);
                escritorBuffer = new BufferedWriter(escritorArchivo); 
                String finalLinea = "";
                while ((finalLinea = lectorBuffer.readLine()) != null) {
                    if(finalLinea.equals(sb.toString()))
                    {
                        
                    }
                    else
                    {
                        escritorBuffer.write(finalLinea);
                        escritorBuffer.newLine();
                    }
                }
                lectorBuffer.close();
                escritorBuffer.close();
                escritorArchivo.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Algo salio mal :c");
                ex.printStackTrace();
            }
            if(archivoEstudiante.delete())
            {
                JOptionPane.showMessageDialog(null, estudiante.getNombre()+" fue eliminad@ con exito.");
                tempFile.renameTo(new File("estudiante.txt"));
                return true;
            }             
        }  
        return false;
    }

    @Override
    public boolean updateEstudiantes(EstudianteDTO parametro) 
    {
        EstudianteDTO estudiante;
        estudiante = estudiantesBD.searchEstudiante(parametro.getIdentificacion());
        if(estudiante != null)
        { 
            estudiantesBD.updateEstudiantes(parametro);
            File tempFile = createTemp();
            try{
                lectorBuffer = new BufferedReader(new FileReader(archivoEstudiante));
                escritorArchivo = new FileWriter(tempFile,true);
                escritorBuffer = new BufferedWriter(escritorArchivo); 
                String finalLinea = "";
                while ((finalLinea = lectorBuffer.readLine()) != null) {
                    if(finalLinea.contains(estudiante.getIdentificacion()))
                    {
                        StringBuilder sb = new StringBuilder();
                        sb.append(estudiante.getIdentificacion());
                        sb.append(DELIMITADOR);
                        sb.append(estudiante.getNombre());
                        sb.append(DELIMITADOR);
                        sb.append(estudiante.getApellidos());
                        sb.append(DELIMITADOR);
                        sb.append(estudiante.getGenero());  
                        escritorBuffer.write(sb.toString());
                        escritorBuffer.newLine();
                    }
                    else
                    {
                        escritorBuffer.write(finalLinea);
                        escritorBuffer.newLine();
                    }
                }
                lectorBuffer.close();
                escritorBuffer.close();
                escritorArchivo.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Algo salio mal :c");
                ex.printStackTrace();
            }
            if(archivoEstudiante.delete())
            {
                JOptionPane.showMessageDialog(null, estudiante.getNombre()+" fue actualizad@ con exito.");
                tempFile.renameTo(new File("estudiante.txt"));
                return true;
            }             
        }  
        return false;
    }
    @Override
    public boolean updateBaseDatos()
    {
        try{
            lectorBuffer = new BufferedReader(new FileReader(archivoEstudiante));
            String finalLinea = "";
            while ((finalLinea = lectorBuffer.readLine()) != null)
            {
                EstudianteDTO estudiante = new EstudianteDTO();
                String[] datos = finalLinea.split(DELIMITADOR);
                estudiante.setIdentificacion(datos[0]);
                estudiante.setNombre(datos[1]);
                estudiante.setApellidos(datos[2]);
                estudiante.setGenero(datos[3].charAt(0));
                estudiantesBD.storeEstudiante(estudiante);
            }
            lectorBuffer.close();
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Algo salio mal :c");
            ex.printStackTrace();
        }     
        return false;
    }
    
    public EstudianteDAOList getList()
    {
        return estudiantesBD;
    }
    

}
