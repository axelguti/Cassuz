package cassuz.examples.com.controladores;



import java.awt.*;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;

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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.MouseEvent;


import javax.swing.*;

public class ControllerPrincipal extends Component implements Initializable {
    @FXML
    private TableView<Pedidos> tblDatosPedidos;
    @FXML
    private TableColumn<Pedidos,String> tcPedidoID;
    @FXML
    private TableColumn<Pedidos,String> tcPedidoDni;
    @FXML
    private TableColumn<Pedidos,String> tcPedidoNombres;
    @FXML
    private TableColumn<Pedidos,String> tcPedidosApellido;
    @FXML
    private TableColumn<Pedidos,String> tcPedidosCatalogo;
    @FXML
    private TableColumn<Pedidos,String> tcPedidosCodigo;
    @FXML
    private TableColumn<Pedidos,String> tcPedidosMarca;
    @FXML
    private TableColumn<Pedidos,String> tcPedidosColor;
    @FXML
    private TableColumn<Pedidos,String> tcPedidosPrecio;
    @FXML
    private TextField txtBPedido;
    @FXML
    private TextField txtPedidoNombrePromotor;
    @FXML
    private ComboBox cmbPedidoDniPromotor;
    @FXML
    private TextField txtPedidoApellidoPromotor;
    @FXML
    private Button btnModificarProductos;
    @FXML
    private TableColumn<Productos, String> tcPCatalogo;
    @FXML
    private TableView<Productos> tblProductos;
    @FXML
    private TableColumn<Productos,String> tcPDescripcion;
    @FXML
    private TableColumn<Productos,String>  tcPTalla;
    @FXML
    private TableColumn<Productos,String>  tcPPrecio;
    @FXML
    private TableColumn<Productos,String>  tcPCodigo;
    @FXML
    private TextField txtPTalla;
    @FXML
    private TextField txtPCodigo;
    @FXML
    private TextField txtPColor;
    @FXML
    private ComboBox<String> cmbCatalogosP;
    @FXML
    private TextField txtPPrecio;
    @FXML
    private TextField txtPDescripcion;
    @FXML
    private Button btnRegistrarCatalogo;
    private JFileChooser fc;
    @FXML
    private ComboBox<String> cmbCatalogos;
    @FXML
    private TableView<ListaPrecios> tblPDatos;
    @FXML
    private TextField txtPPromotor;
    @FXML
    private TextField txtBProductos;
    @FXML
    private TableColumn<ListaPrecios,String> tcPCostoPromotor;
    @FXML
    private TableColumn<ListaPrecios,String> tcPCostoPublico;
    @FXML
    private TableColumn<Productos,String> tcPColor;
    @FXML
    private TableColumn<ListaPrecios,String> tcPEstilo;
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
    private ObservableList<ListaPrecios> listaPrecio;
    @FXML
    private  ObservableList<Productos> listaProducto;
    @FXML
    private ObservableList<String> listaRol;
    @FXML
    private ObservableList<String> cmbcata;
    @FXML
    private ObservableList<String> listaBuscarUsuario;
    @FXML
    private final CatalogoInterface daoCatalogo = DAOFactory.getCatalogoDAO();
    @FXML
    private final PromotorInterface dao = DAOFactory.getPromotorDAO();
    @FXML
    private final UsuarioInterface usr= DAOFactory.getUsuarioDAO();
    @FXML
    private final RolInterface rol= DAOFactory.getRolDAO();
    @FXML
    private final ListaPrecioInterface listaPre= DAOFactory.getListaPrecioDAO();
    @FXML
    private final ProductoInterface producto= DAOFactory.getProductoDAO();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MostrarLista();
        MostrarListaCatalogo();
        mostrarUsuario();
        listaRol();
        listaBuscarUsuario();
        mostrardatosProducto();
        ModificaProducto();

    }

    //Lista de roles
    private void listaRol(){
        List<Rol> listar=rol.listar();
        listaRol=FXCollections.observableArrayList();
        listar.forEach(a->listaRol.addAll(a.getNomrol()));
        cmbRol.setItems(listaRol);
    }

    //Busca a los usuarios
    private void listaBuscarUsuario(){
        listaBuscarUsuario=FXCollections.observableArrayList("Nombre","Apellidos","Usuario");
        cmbBuscarUsuarios.setItems(listaBuscarUsuario);
    }

    //Muestra en la tabla la lista de promotor
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

    //muestra en la tabla la lista de los catalogos
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

    //Muestra en la tabla la lista de usuarios
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

    //Registra al promotor
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
            else
                dao.grabar(p);
        }
        vaciarTexto();
        MostrarLista();
    }

    //limpia las cajas de texto del promotor
    private void vaciarTexto() {
        txtDni.setText("");
        txtTelefono.setText("");
        txtRecomendado.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
    }

    //Ingresa datos del promotor
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

    //Elimina datos del promotor
    @FXML
    private void Eliminar(ActionEvent event) {
        String id = txtDni.getText();
        dao.eliminar(id);
        vaciarTexto();
        MostrarLista();
    }

    //Modificar datos del promotor
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

    //Mandar datos de la tabla a las cajas de texto
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

    //Busca al promotor
    @FXML
    void buscar(MouseEvent mouseEvent) {
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
    private void Limpiar(ActionEvent actionEvent) {
        vaciarTexto();
    }

    //Registra al usuario
    @FXML
    private void RegistrarUsuario(ActionEvent actionEvent) {
        Usuario u=DatosUsuario();
        if(txtUUsuario.getText().isEmpty() || txtUApellido.getText().isEmpty()
            ||txtUNombre.getText().isEmpty() || txtUTelefono.getText().isEmpty() ||
            txtUContraseña.getText().isEmpty() || txtURepiteContraseña.getText().isEmpty()){

            Error();

        }else{

            if(txtUUsuario.equals(u.getUsuarioUsuario())){
                usr.grabar(u);
            }else{
                usr.grabar(u);
                JOptionPane.showMessageDialog(null,"Registro guardado","Registro",1);
            }
        }
        limpiarUsuario();
        mostrarUsuario();
    }

    //Ingresa datos de usuario
    private Usuario DatosUsuario(){
        Usuario u=new Usuario(txtUUsuario.getText(),txtUContraseña.getText());
        u.setNomUsuario(txtUNombre.getText());
        u.setApeUsuario(txtUApellido.getText());
        u.setTelefUsuario(txtUTelefono.getText());
        u.setRolUsuario(cmbRol.getValue());
        return u;
    }

    //Modifica datos al usuario
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

    //limpia las cajas de texto del usuario
    private void limpiarUsuario() {
        txtUNombre.setText("");
        txtUApellido.setText("");
        txtUTelefono.setText("");
        txtUUsuario.setText("");
        txtUContraseña.setText("");
        txtURepiteContraseña.setText("");
    }

    //Elimina al usuario
    @FXML
    private void EliminarUsuario(ActionEvent actionEvent) {
        String id=txtUUsuario.getText();
        usr.eliminar(id);
        mostrarUsuario();
        limpiarUsuario();
    }

    //manda los datos de la tabla a la caja de texto del usuario
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

    //Limpia el catalogo
    @FXML
    private void LimpiarCatalogo(ActionEvent actionEvent) {
        limpiarCatalogo();
    }

    //codigo para Limpiar el catalogo
    private void limpiarCatalogo(){
        txtIdCatalogo.setText("");
        txtCatalogo.setText("");
        txtRepresentante.setText("");
        txtCTelefono.setText("");
    }

    //Ingresa datos del catalogo
    private Catalogo DatosCatalogo() {
        Catalogo c = new Catalogo();
        c.setNombre(txtCatalogo.getText());
        c.setRepresentante(txtRepresentante.getText());
        c.setTelefono(txtCTelefono.getText());
        return c;
    }

    //Codigo para mandar error
    private void Error(){
        JOptionPane.showMessageDialog(null, "Error. Datos Vacios", "Error", 1);
    }

    //Registra el catalogo
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

    //Elimina el catalogo
    @FXML
    private void EliminarCatalogo(ActionEvent actionEvent) {
        int id= Integer.parseInt(txtIdCatalogo.getText());
        daoCatalogo.eliminar(id);
        MostrarListaCatalogo();
        limpiarCatalogo();

    }

    //Modifica el catalogo
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

    //Busca catalogo
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

    //Muestra el catalogo
    @FXML
    private void MostrarCatalogo(ActionEvent actionEvent) {
        MostrarListaCatalogo();
    }

    //Manda los datos de la tabla a la caja de texto del catalogo
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

    //Muestra los datos en la tabla del usuario
    @FXML
    private void MostrarUsuario(ActionEvent actionEvent) {
        mostrarUsuario();
    }

    //Busca al usuario
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

    //Limpia las cajas de texto
    @FXML
    private void LimpiarUsuario(ActionEvent actionEvent) {
        limpiarUsuario();
    }

    @FXML
    private void LimpiarListaPrecios(ActionEvent actionEvent) {
    }

    //Codigo para mostrar datos del producto
    private void mostrardatosProducto(){
        List<Productos> listar=producto.listar();
        listaProducto=FXCollections.observableArrayList();
        tcPCatalogo.setCellValueFactory(new PropertyValueFactory<>("catalogo"));
        tcPPagina.setCellValueFactory(new PropertyValueFactory<>("pagina"));
        tcPCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tcPMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tcPColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        tcPDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tcPTalla.setCellValueFactory(new PropertyValueFactory<>("talla"));
        tcPPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        listar.forEach(a->listaProducto.addAll(a));
        tblProductos.setItems(listaProducto);
    }
    //Muestra los precios
    @FXML
    private void MostrarPrecios(ActionEvent actionEvent) {
        mostrardatosProducto();
    }

    //Elimina precios
    @FXML
    private void EliminarPrecios(ActionEvent actionEvent) {
    }

    //Modifica Precios
    @FXML
    private void ModificarPrecios(ActionEvent actionEvent) {
    }

    //Registra Precios
    @FXML
    private void RegistrarPrecios(ActionEvent actionEvent) {
    }

    //busca productos
    @FXML
    private void buscarProductos(MouseEvent mouseEvent) {
    }

    //Manda los datos de la tabla a las cajas de texto
    @FXML
    private void datosProducto(MouseEvent mouseEvent) {
        Productos productos = tblProductos.getSelectionModel().getSelectedItem();
        if(productos==null){
            MostrarLista();
        }else{
            cmbCatalogosP.getSelectionModel().select(productos.getCatalogo());
            txtPPagina.setText(String.valueOf(productos.getPagina()));
            txtPCodigo.setText(productos.getCodigo());
            txtPMarca.setText(productos.getMarca());
            txtPColor.setText(productos.getColor());
            txtPDescripcion.setText(productos.getDescripcion());
            txtPTalla.setText(productos.getTalla());
            txtPPrecio.setText(String.valueOf(productos.getPrecio()));
        }
    }
    //Importar Precios de los catalogos
    @FXML
    private void importarPrecios(ActionEvent actionEvent){
        fc=new JFileChooser();
        String r="";
        int seleccion=fc.showOpenDialog(this);
        if(seleccion==JFileChooser.APPROVE_OPTION){
            File f=fc.getSelectedFile();
            r= listaPre.Importar(f);
            JOptionPane.showMessageDialog(null,r);
        }
        mostrardatosProducto();
    }
    //Muestra los catalogos en el combobox
    @FXML
    private void cmbmuestracata(MouseEvent mouseEvent) {
        List<Catalogo> listar=daoCatalogo.listar();
        cmbcata=FXCollections.observableArrayList();
        listar.forEach(a->cmbcata.add(a.getNombre()));
        cmbCatalogos.setItems(cmbcata);
        cmbCatalogosP.setItems(cmbcata);
    }

    //Registra al Producto
    @FXML
    private void RegistrarProductos(ActionEvent actionEvent) {
        Productos p=IngresarProductos();
        if(txtPPagina.getText().isEmpty() || txtPCodigo.getText().isEmpty() ||
            txtPMarca.getText().isEmpty() || txtPColor.getText().isEmpty() ||
            txtPPrecio.getText().isEmpty() || txtPDescripcion.getText().isEmpty() ||
            txtPTalla.getText().isEmpty()){
        }else{
            producto.grabar(p);
            JOptionPane.showMessageDialog(null,"Producto Registrado","Registro",1);
        }
        limpiarProductos();
        mostrardatosProducto();
    }

    //Ingresa datos del producto
    private Productos IngresarProductos(){
        Productos p=new Productos();

        p.setCatalogo(String.valueOf(cmbCatalogosP.getValue()));
        p.setPagina(Integer.parseInt(txtPPagina.getText()));
        p.setCodigo(txtPCodigo.getText());
        p.setMarca(txtPMarca.getText());
        p.setColor(txtPColor.getText());
        p.setDescripcion(txtPDescripcion.getText());
        p.setTalla(txtPTalla.getText());
        p.setPrecio(Double.parseDouble(txtPPrecio.getText()));

        return p;
    }

    //Codigo de limpiar Productos
    private void limpiarProductos() {
        txtPPagina.setText("");
        txtPCodigo.setText("");
        txtPMarca.setText("");
        txtPColor.setText("");
        txtPDescripcion.setText("");
        txtPTalla.setText("");
        txtPPrecio.setText("");
    }

    //Codigo de modificar producto con expresiones lambda
    private void ModificaProducto(){

        btnModificarProductos.setOnAction(a->{
            Productos p=IngresarProductos();
            if(txtPPagina.getText().isEmpty() || txtPCodigo.getText().isEmpty() ||
                    txtPMarca.getText().isEmpty() || txtPColor.getText().isEmpty() ||
                    txtPPrecio.getText().isEmpty() || txtPDescripcion.getText().isEmpty() ||
                    txtPTalla.getText().isEmpty()){
            }else{
                producto.modificar(p);
                JOptionPane.showMessageDialog(null,"Producto Modificado","Registro",1);
            }
            limpiarProductos();
            mostrardatosProducto();
        });

    }

    //Modifica Producto
    @FXML
    private void ModificarProductos(ActionEvent actionEvent) {
    }

    //
    @FXML
    private void importarProductos(ActionEvent actionEvent) {
    }

    //Elimina al Producto
    @FXML
    private void EliminarProductos(ActionEvent actionEvent) {
        String codigo=txtPCodigo.getText();
        String eliminar=producto.eliminar(codigo);
        JOptionPane.showMessageDialog(null,eliminar,"Eliminar",1);
        limpiarProductos();
        mostrardatosProducto();
    }

    //Muestra en la tabla los datos de los productos
    @FXML
    private void MostrarProductos(ActionEvent actionEvent) {
        mostrardatosProducto();
    }

    //Limpia las cajas de texto del producto
    @FXML
    private void LimpiarProductos(ActionEvent actionEvent) {
        limpiarProductos();
    }

    @FXML
    private void ListaPrecios(MouseEvent mouseEvent) {
    }

    public void LimpiarPedidosProductos(ActionEvent actionEvent) {
    }

    public void RegistrarPedidos(ActionEvent actionEvent) {
    }

    public void ModificarPedidos(ActionEvent actionEvent) {
    }

    public void EliminarPedidos(ActionEvent actionEvent) {
    }

    public void MostrarPedidos(ActionEvent actionEvent) {
    }
}
