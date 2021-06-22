package cassuz.examples.com.beans;

public class Catalogo {
    private int id;
    private String nombre;
    private String representante;
    private String telefono;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRepresentante(){
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void Imprimir(){
        System.out.println(getId());
        System.out.println(getNombre());
        System.out.println(getRepresentante());
        System.out.println(getTelefono());
    }
}
