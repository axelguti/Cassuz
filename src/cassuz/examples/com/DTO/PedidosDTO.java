package cassuz.examples.com.DTO;

import java.time.LocalDate;

public class PedidosDTO {
    private String dniPromotor;
    private String nombrepromotor;
    private String apepromotor;
    private int idPedido;
    private LocalDate fechaPedido;
    private String nomCatalogo;
    private int pagina;
    private String marca;
    private String color;
    private double precio;
    private String talla;
    private String codProducto;

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getDniPromotor() {
        return dniPromotor;
    }

    public String getNomCatalogo() {
        return nomCatalogo;
    }

    public void setNomCatalogo(String nomCatalogo) {
        this.nomCatalogo = nomCatalogo;
    }

    public void setDniPromotor(String dniPromotor) {
        this.dniPromotor = dniPromotor;
    }

    public String getNombrepromotor() {
        return nombrepromotor;
    }

    public void setNombrepromotor(String nombrepromotor) {
        this.nombrepromotor = nombrepromotor;
    }

    public String getApepromotor() {
        return apepromotor;
    }

    public void setApepromotor(String apepromotor) {
        this.apepromotor = apepromotor;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }
}