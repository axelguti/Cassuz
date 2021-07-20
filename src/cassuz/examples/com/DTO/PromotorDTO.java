package cassuz.examples.com.DTO;

import java.time.LocalDate;


public class PromotorDTO {
    private  String dni;
    private  String nombre;
    private  String apellido;
    private  String direccion;
    private  String telefono;
    private  LocalDate fechaNacimiento;
    private  String recomendado;
    private LocalDate fechaInscripcion;


    public PromotorDTO() {

    }

    public PromotorDTO(String dni, String nombre, String apellido, String direccion, String telefono, LocalDate fechaInscripcion
            , String recomendado, LocalDate fechaNacimiento) {
        this.dni=dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion=direccion;
        this.telefono = telefono;
        this.fechaInscripcion = fechaInscripcion;
        this.recomendado = recomendado;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRecomendado() {
        return recomendado;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }



    public void Imprimir() {
        System.out.println("dni: "+getDni());
        System.out.println("Nombres: "+getNombre());
        System.out.println("Apellidos: "+getApellido());
        System.out.println("Direccion: "+getDireccion());
        System.out.println("Telefono: "+getTelefono());
        System.out.println("fecha nacimiento: "+getFechaNacimiento());
        System.out.println("recomendado: "+getRecomendado());
        System.out.println("Fecha: "+getFechaNacimiento());
    }


}