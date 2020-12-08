
package co.edu.udea.MVCDAO.modelo;

//POJO de estudiante Plain Old Java Object
//DTO Data Transfer Object
//bean Grano de codigo
//completo

public class EstudianteDTO
{
    private String nombre;
    private String apellidos;
    private String documento;
    private char genero;

    public EstudianteDTO() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return documento;
    }

    public void setIdentificacion(String identificacion) {
        this.documento = identificacion;
    }

    public char getGenero() {
        return genero;
    }

    // Constructores
    public void setGenero(char genero) {
        this.genero = genero;
    }

    // Getters and Setters
    @Override
    public String toString() {
        return " > " + nombre + " " + apellidos + ", ID: " + documento + ", genero: " + genero + ".";
    }
                    

}
