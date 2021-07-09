package cassuz.examples.com.DTO;

public class UsuarioDTO {
    private String nomUsuario;
    private String apeUsuario;
    private String telefUsuario;
    private String usuarioUsuario;
    private String contraUsuario;
    private String rolUsuario;

    public UsuarioDTO(String usuarioUsuario, String contraUsuario) {
        this.usuarioUsuario = usuarioUsuario;
        this.contraUsuario = contraUsuario;
    }

    public String getUsuarioUsuario() {
        return usuarioUsuario;
    }

    public String getContraUsuario() {
        return contraUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getApeUsuario() {
        return apeUsuario;
    }

    public void setApeUsuario(String apeUsuario) {
        this.apeUsuario = apeUsuario;
    }

    public String getTelefUsuario() {
        return telefUsuario;
    }

    public void setTelefUsuario(String telefUsuario) {
        this.telefUsuario = telefUsuario;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
    public void Imprimir() {
        System.out.println(getNomUsuario());
        System.out.println(getApeUsuario());
        System.out.println(getTelefUsuario());
        System.out.println(getUsuarioUsuario());
        System.out.println(getContraUsuario());
        System.out.println(getRolUsuario());
    }
}
