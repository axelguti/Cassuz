package cassuz.examples.com.beans;

public class ListaPrecios {
    private String catalogo;
    private int pagina;
    private String marca;
    private String codigo;
    private String color;
    private double preciopublico;
    private double preciopromotor;

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPreciopublico() {
        return preciopublico;
    }

    public void setPreciopublico(double preciopublico) {
        this.preciopublico = preciopublico;
    }

    public double getPreciopromotor() {
        return preciopromotor;
    }

    public void setPreciopromotor(double preciopromotor) {
        this.preciopromotor = preciopromotor;
    }

    public void Imprimir() {
        System.out.println(getPagina());
        System.out.println(getMarca());
        System.out.println(getCodigo());
        System.out.println(getColor());
        System.out.println(getPreciopublico());
        System.out.println(getPreciopromotor());
    }
}
