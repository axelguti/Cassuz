package cassuz.examples.com.beans;

import java.time.LocalDate;


public class Promotor {
    private final String dni;
    private final String nombre;
    private final String apellido;
    private final String direccion;
    private final String telefono;
    private final String correo;
    private final String recomendado;
    private final LocalDate fechaNacimiento;

    public Promotor(String dni,String nombre, String apellido,String direccion,String telefono,String correo
            ,String recomendado,LocalDate fechaNacimiento) {
        this.dni=dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion=direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.recomendado = recomendado;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
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
        System.out.println("correo: "+getCorreo());
        System.out.println("recomendado: "+getRecomendado());
        System.out.println("Fecha: "+getFechaNacimiento());
    }


}