package cassuz.examples.com.controladores;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import cassuz.examples.com.DAOFactory.DAOFactory;
import cassuz.examples.com.beans.*;
import cassuz.examples.com.interfaces.*;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.MouseEvent;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import javax.swing.*;

public class ControllerPrincipal implements Initializable {
    @FXML
    private ComboBox<String> cmbCatalogos;
    @FXML
    private TableView<Productos> tblPDatos;
    @FXML
    private TextField txtPPromotor;
    @FXML
    private TextField txtBProductos;
    @FXML
    private TableColumn<Productos,String> tcPCostoPromotor;
    @FXML
    private TableColumn<Productos,String> tcPCostoPublico;
    @FXML
    private TableColumn<Productos,String> tcPColor;
    @FXML
    private TableColumn<Productos,String> tcPEstilo;
    @FXML
    private TableColumn<Productos,String> tcPMarca;
    @FXML
    private TableColumn<Productos,String> tcPPagina;
    @FXML
    private TextField txtPMarca;
    @FXML
    private TextField txtPCostoPublico;
    @FXML
    private TextField txtPEstilo;
    @FXML
    private TextField txtPCostoPromotor;
    @FXML
    private TextField txtPColor;
    @FXML
    private TextField txtPPagina;
    @FXML
    private ComboBox<String> cmbBuscarUsuarios;
    @FXML
    private ComboBox<String> cmbRol;
    @FXML
    private TextField txtIdCatalogo;
    @FXML
    private TextField txtUApellido;
    @FXML
    private TextField txtUUsuario;
    @FXML
    private TextField txtUTelefono;
    @FXML
    private PasswordField txtUContraseña;
    @FXML
    private PasswordField txtURepiteContraseña;
    @FXML
    private TextField txtUBuscar;
    @FXML
    private TableColumn<Usuario, String> tcUNombre;
    @FXML
    private TableColumn<Usuario, String> tcUApellido;
    @FXML
    private TableColumn<Usuario, String> tcUTelefono;
    @FXML
    private TableColumn<Usuario, String> tcUUsuario;
    @FXML
    private TableColumn<Usuario, String> tcUContraseña;
    @FXML
    private TableColumn<Usuario, String> tcURol;
    @FXML
    private TableView<Usuario> tblUDatos;
    @FXML
    private TextField txtCTelefono;
    @FXML
    private TextField txtRepresentante;
    @FXML
    private TableColumn<Catalogo, String> tcCTelefono;
    @FXML
    private TableColumn<Catalogo, String> tcRepresentante;
    @FXML
    private TableColumn<Catalogo, String> tcCatalogo;
    @FXML
    private TableColumn<Catalogo, Integer> tcNumero;
    @FXML
    private TableView<Catalogo> tblDatosCatalogo;
    @FXML
    private TextField txtCBuscar;
    @FXML
    private TextField txtCatalogo;
    @FXML
    private TextField txtUNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtNombres;
    @FXML
    private Button btnRegistrar;
    @FXML
    private TextField txtDni;
    @FXML
    private TextField txtRecomendado;
    @FXML
    private TextField txtBuscar;
    @FXML
    private Button btMostrar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnBuscar;
    @FXML
    private TableColumn<Promotor, String> tcNombres;
    @FXML
    private TableColumn<Promotor, String> tcApellidos;
    @FXML
    private TableColumn<Promotor, String> tcDireccion;
    @FXML
    private TableColumn<Promotor, String> tcTelefono;
    @FXML
    private TableColumn<Promotor, String> tcCorreo;
    @FXML
    private TableColumn<Promotor, String> tcRecomendado;
    @FXML
    private TableColumn<Promotor, LocalDate> tcFecha;
    @FXML
    private TableColumn<Promotor, String> tcDni;
    @FXML
    private TableView<Promotor> tblDatos;
    @FXML
    private ObservableList<Promotor> lista;
    @FXML
    private ObservableList<Catalogo> listaCatalogo;
    @FXML
    private ObservableList<Usuario> listaUsuario;
    @FXML
    private ObservableList<Productos> listaProduto;
    @FXML
    private ObservableList<String> listaRol;
    @FXML
    private ObservableList<String> listaBuscarUsuario;
    @FXML
    private final DAOFactory factory = DAOFactory.getInstance();
    @FXML
    private final CatalogoInterface daoCatalogo = factory.getCatalogoDAO();
    @FXML
    private final PromotorInterface dao = factory.getPromotorDAO();
    @FXML
    private final UsuarioInterface usr= factory.getUsuarioDAO();
    @FXML
    private final RolInterface rol=factory.getRolDAO();
    @FXML
    private final ProductoInterface producto=factory.getProductoDAO();

    private HSSFWorkbook wb;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MostrarLista();
        MostrarListaCatalogo();
        mostrarUsuario();
        listaRol();
        listaBuscarUsuario();
        mostrardatosProducto();
    }

    private void listaRol(){
        List<Rol> listar=rol.listar();
        listaRol=FXCollections.observableArrayList();
        listar.stream().forEach(a->listaRol.addAll(a.getNomrol()));
        cmbRol.setItems(listaRol);
    }

    private void listaBuscarUsuario(){
        listaBuscarUsuario=FXCollections.observableArrayList("Nombre","Apellidos","Usuario");
        cmbBuscarUsuarios.setItems(listaBuscarUsuario);
    }
    @FXML
    //Ingresar datos a la tabla
    private void MostrarLista() {
        List<Promotor> listar = dao.listar();
        lista = FXCollections.observableArrayList();
        tcDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        tcNombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcApellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tcDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tcTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tcCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        tcRecomendado.setCellValueFactory(new PropertyValueFactory<>("recomendado"));
        tcFecha.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        listar.forEach(a -> lista.addAll(a));
        tblDatos.setItems(lista);
    }

    private void MostrarListaCatalogo() {
        List<Catalogo> listar=daoCatalogo.listar();
        listaCatalogo = FXCollections.observableArrayList();
        tcNumero.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcCatalogo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcRepresentante.setCellValueFactory(new PropertyValueFactory<>("representante"));
        tcCTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        listar.forEach(a->listaCatalogo.addAll(a));
        tblDatosCatalogo.setItems(listaCatalogo);
    }

    public void mostrarUsuario(){
        List<Usuario> listar=usr.listar();
        listaUsuario=FXCollections.observableArrayList();
        tcUNombre.setCellValueFactory(new PropertyValueFactory<>("nomUsuario"));
        tcUApellido.setCellValueFactory(new PropertyValueFactory<>("apeUsuario"));
        tcUTelefono.setCellValueFactory(new PropertyValueFactory<>("telefUsuario"));
        tcUUsuario.setCellValueFactory(new PropertyValueFactory<>("usuarioUsuario"));
        tcUContraseña.setCellValueFactory(new PropertyValueFactory<>("contraUsuario"));
        tcURol.setCellValueFactory(new PropertyValueFactory<>("rolUsuario"));
        listar.forEach(a->listaUsuario.addAll(a));
        tblUDatos.setItems(listaUsuario);
    }
    @FXML
    //Mostrar Datos de la tabla
    private void Mostrar(ActionEvent event) {
        MostrarLista();
    }


    @FXML
    private void Registrar(ActionEvent event) {
        Promotor p = IngresarDatos();
        if (txtDni.getText().isEmpty() || txtNombres.getText().isEmpty() ||
                txtApellidos.getText().isEmpty() || txtCorreo.getText().isEmpty()
                || txtDireccion.getText().isEmpty() || txtRecomendado.getText().isEmpty() ||
                txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error. Datos Vacios", "Error", 1);
        } else {
            if (txtDni.equals(p.getDni()))
                dao.grabar(p);
            else {
                dao.grabar(p);

            }
        }
        vaciarTexto();
        MostrarLista();
    }

    private void vaciarTexto() {
        txtDni.setText("");
        txtTelefono.setText("");
        txtRecomendado.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
    }

    private Promotor IngresarDatos() {
        Promotor p = new Promotor(txtDni.getText(),
                txtNombres.getText(),
                txtApellidos.getText(),
                txtDireccion.getText(),
                txtTelefono.getText(),
                txtCorreo.getText(),
                txtRecomendado.getText(),
                LocalDate.now());
        return p;
    }

    @FXML
    private void Eliminar(ActionEvent event) {
        String id = txtDni.getText();
        dao.eliminar(id);
        vaciarTexto();
        MostrarLista();
    }

    //Modificar registro
    @FXML
    private void Modificar(ActionEvent event) {
        Promotor p = IngresarDatos();
        if (txtDni.getText().isEmpty() || txtNombres.getText().isEmpty() ||
                txtApellidos.getText().isEmpty() || txtCorreo.getText().isEmpty()
                || txtDireccion.getText().isEmpty() || txtRecomendado.getText().isEmpty() ||
                txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error. Datos Vacios", "Error", 1);
        } else {
            int i = JOptionPane.showOptionDialog(null, "Seguro que desea modificar el registro", "Modificar",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (i == 0) {
                dao.modificar(p);
            }
        }
        vaciarTexto();
        MostrarLista();
    }

    @FXML
    private void datos(MouseEvent mouseEvent) {
        Promotor promotor = tblDatos.getSelectionModel().getSelectedItem();
        if(promotor==null){
            MostrarLista();
        }else{
            txtDni.setText(promotor.getDni());
            txtNombres.setText(promotor.getNombre());
            txtApellidos.setText(promotor.getApellido());
            txtCorreo.setText(promotor.getCorreo());
            txtDireccion.setText(promotor.getDireccion());
            txtTelefono.setText(promotor.getTelefono());
            txtRecomendado.setText(promotor.getRecomendado());
        }

    }

    private void Buscar(){
      mostrarUsuario();
        FilteredList<Promotor> filtrar = new FilteredList<>(lista, b -> true);
        txtBuscar.textProperty().addListener((ObservableList, oldValue, newValue) -> {
            filtrar.setPredicate(promotor -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                //Filtrar Por DNI del Promotor
                return promotor.getDni().toLowerCase().contains(lowerCaseFilter);
            });
        });
        SortedList<Promotor> sorted = new SortedList<>(filtrar);
        sorted.comparatorProperty().bind(tblDatos.comparatorProperty());
        tblDatos.setItems(sorted);
    }
    @FXML
    void buscar(MouseEvent mouseEvent) {
        Buscar();
    }

    @FXML
    private void Limpiar(ActionEvent actionEvent) {
        vaciarTexto();
    }

    @FXML
    private void RegistrarUsuario(ActionEvent actionEvent) {
        Usuario u=DatosUsuario();
        if(txtUUsuario.getText().isEmpty() || txtUApellido.getText().isEmpty()
            ||txtUNombre.getText().isEmpty() || txtUTelefono.getText().isEmpty() ||
            txtUContraseña.getText().isEmpty() || txtURepiteContraseña.getText().isEmpty()){

            Error();

        }else{
            usr.grabar(u);
            JOptionPane.showMessageDialog(null,"Registro Guardado...","guardado",1);
        }
        limpiarUsuario();
        mostrarUsuario();
    }

    private Usuario DatosUsuario(){
        Usuario u=new Usuario(txtUUsuario.getText(),txtUContraseña.getText());
        u.setNomUsuario(txtUNombre.getText());
        u.setApeUsuario(txtUApellido.getText());
        u.setTelefUsuario(txtUTelefono.getText());
        u.setRolUsuario(cmbRol.getValue());
        return u;
    }

    @FXML
    private void ModificarUsuario(ActionEvent actionEvent) {
        Usuario u=DatosUsuario();
        if (txtUNombre.getText().isEmpty() || txtUApellido.getText().isEmpty() ||
                txtUTelefono.getText().isEmpty()||txtUUsuario.getText().isEmpty() ||
                txtUContraseña.getText().isEmpty()) {
            Error();
        } else {
            int i = JOptionPane.showOptionDialog(null, "Seguro que desea modificar el registro", "Modificar",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (i == 0) {
                usr.modificar(u);
            }
        }
        limpiarUsuario();
        mostrarUsuario();
    }
    private void limpiarUsuario() {
        txtUNombre.setText("");
        txtUApellido.setText("");
        txtUTelefono.setText("");
        txtUUsuario.setText("");
        txtUContraseña.setText("");
        txtURepiteContraseña.setText("");
    }
    @FXML
    private void EliminarUsuario(ActionEvent actionEvent) {
        String id=txtUUsuario.getText();
        usr.eliminar(id);
        mostrarUsuario();
        limpiarUsuario();
    }

    @FXML
    private void datosUsuario(MouseEvent mouseEvent) {
        Usuario usuario = tblUDatos.getSelectionModel().getSelectedItem();
        if(usuario==null){
            MostrarLista();
        }else{
            txtUNombre.setText(usuario.getNomUsuario());
            txtUApellido.setText(usuario.getApeUsuario());
            txtUTelefono.setText(usuario.getTelefUsuario());
            txtUUsuario.setText(usuario.getUsuarioUsuario());
            txtUContraseña.setText(usuario.getContraUsuario());
            cmbRol.getSelectionModel().select(usuario.getRolUsuario());

        }
    }

    @FXML
    private void LimpiarCatalogo(ActionEvent actionEvent) {
        limpiarCatalogo();
    }

    private void limpiarCatalogo(){
        txtIdCatalogo.setText("");
        txtCatalogo.setText("");
        txtRepresentante.setText("");
        txtCTelefono.setText("");
    }

    private Catalogo DatosCatalogo() {
        Catalogo c = new Catalogo();
        c.setNombre(txtCatalogo.getText());
        c.setRepresentante(txtRepresentante.getText());
        c.setTelefono(txtCTelefono.getText());
        return c;
    }

    private void Error(){
        JOptionPane.showMessageDialog(null, "Error. Datos Vacios", "Error", 1);
    }

    @FXML
    private void RegistrarCatalogo(ActionEvent actionEvent) {
        Catalogo c=DatosCatalogo();
        if (txtCatalogo.getText().isEmpty() || txtRepresentante.getText().isEmpty() ||
                txtCTelefono.getText().isEmpty()) {
            Error();
        } else {
            if(txtDni.equals(c.getNombre()))
                daoCatalogo.grabar(c);
            else
                daoCatalogo.grabar(c);
        }
        limpiarCatalogo();
        MostrarListaCatalogo();
    }

    @FXML
    private void EliminarCatalogo(ActionEvent actionEvent) {
        String id=txtCatalogo.getText();
        daoCatalogo.eliminar(id);
        MostrarListaCatalogo();
        limpiarCatalogo();
    }

    @FXML
    private void ModificarCatalogo(ActionEvent actionEvent) {
        Catalogo c=DatosCatalogo();
        c.setId(Integer.parseInt(txtIdCatalogo.getText()));
        if (txtCatalogo.getText().isEmpty() || txtRepresentante.getText().isEmpty() ||
                txtCTelefono.getText().isEmpty()) {
            Error();
        } else {
            int i = JOptionPane.showOptionDialog(null, "Seguro que desea modificar el registro", "Modificar",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (i == 0) {
                daoCatalogo.modificar(c);
            }
        }
        limpiarCatalogo();
        MostrarListaCatalogo();
    }

    @FXML
    private void BuscarCatalogo(MouseEvent mouseEvent) {
        MostrarListaCatalogo();
        FilteredList<Catalogo> filtrar = new FilteredList<>(listaCatalogo, b -> true);
        txtCBuscar.textProperty().addListener((ObservableList, oldValue, newValue) -> {
            filtrar.setPredicate(catalogo -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                //Filtrar Por Nombre del catalogo del Promotor
                return catalogo.getNombre().toLowerCase().contains(lowerCaseFilter);
            });
        });
        SortedList<Catalogo> sorted = new SortedList<>(filtrar);
        sorted.comparatorProperty().bind(tblDatosCatalogo.comparatorProperty());
        tblDatosCatalogo.setItems(sorted);
    }

    @FXML
    private void MostrarCatalogo(ActionEvent actionEvent) {
        MostrarListaCatalogo();
    }

    @FXML
    private void datosCatalogo(MouseEvent mouseEvent) {
        Catalogo catalogo = tblDatosCatalogo.getSelectionModel().getSelectedItem();
        if(catalogo==null){
            MostrarLista();
        }else{
            txtIdCatalogo.setText(String.valueOf(catalogo.getId()));
            txtCatalogo.setText(catalogo.getNombre());
            txtRepresentante.setText(catalogo.getRepresentante());
            txtCTelefono.setText(catalogo.getTelefono());

        }
    }

    @FXML
    private void MostrarUsuario(ActionEvent actionEvent) {
        mostrarUsuario();
    }

    @FXML
    private void BuscarUsuario(MouseEvent mouseEvent) {
        mostrarUsuario();
        FilteredList<Usuario> filtrar = new FilteredList<>(listaUsuario, b -> true);
        txtUBuscar.textProperty().addListener((ObservableList, oldValue, newValue) -> {
            filtrar.setPredicate(usuario -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if(cmbBuscarUsuarios.getValue()!=null){
                    switch(cmbBuscarUsuarios.getValue()){
                        //Filtrar Por Nombre del Usuario
                        case "Nombre": {
                            return usuario.getNomUsuario().toLowerCase().contains(lowerCaseFilter);
                        }
                        //Filtrar por apellido del Usuario
                        case "Apellidos":{
                            return usuario.getApeUsuario().toLowerCase().contains(lowerCaseFilter);
                        }
                        //Filtrar por Nombre de Usuario del Usuario
                        case "Usuario":{
                            return usuario.getUsuarioUsuario().toLowerCase().contains(lowerCaseFilter);
                        }
                    }
                }else{
                    //Muestra la lista de usuarios
                    mostrarUsuario();
                }
                return false;
            });
        });
        SortedList<Usuario> sorted = new SortedList<>(filtrar);
        sorted.comparatorProperty().bind(tblUDatos.comparatorProperty());
        tblUDatos.setItems(sorted);
    }

    @FXML
    private void LimpiarUsuario(ActionEvent actionEvent) {
        limpiarUsuario();
    }

    @FXML
    private void LimpiarProductos(ActionEvent actionEvent) {
    }

    private void mostrardatosProducto(){
        List<Productos> listar=producto.listar();
        listaProduto=FXCollections.observableArrayList();
        tcPPagina.setCellValueFactory(new PropertyValueFactory<>("pagina"));
        tcPMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tcPEstilo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tcPColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        tcPCostoPublico.setCellValueFactory(new PropertyValueFactory<>("preciopublico"));
        tcPCostoPromotor.setCellValueFactory(new PropertyValueFactory<>("preciopromotor"));
        listar.forEach(a->listaProduto.addAll(a));
        tblPDatos.setItems(listaProduto);
    }

    @FXML
    private void MostrarProductos(ActionEvent actionEvent) {
        mostrardatosProducto();
    }

    @FXML
    private void EliminarProductos(ActionEvent actionEvent) {
    }

    @FXML
    private void ModificarProductos(ActionEvent actionEvent) {
    }

    @FXML
    private void RegistrarProductos(ActionEvent actionEvent) {
    }

    @FXML
    private void buscarProductos(MouseEvent mouseEvent) {
    }

    @FXML
    private void datosProducto(MouseEvent mouseEvent) {
    }
    public void ImportarProductos(File archivo,TableView tblPProductos) {

    }

    public void importarProductos(ActionEvent actionEvent){

    }
}
