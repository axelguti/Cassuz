package cassuz.examples.com.beans;

public class Rol {
    private int idrol;
    private String nomrol;

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getNomrol() {
        return nomrol;
    }

    public void setNomrol(String nomrol) {
        this.nomrol = nomrol;
    }

    public void Imprimir(){
        System.out.println(getIdrol());
        System.out.println(getNomrol());
    }
}
