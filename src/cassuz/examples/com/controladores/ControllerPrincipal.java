package cassuz.examples.com.controladores;


import cassuz.examples.com.DAOFactory.DAOFactory;
import cassuz.examples.com.DTO.*;
import cassuz.examples.com.interfaces.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerPrincipal extends Component implements Initializable {
    @FXML
    private Button btnImportarProducto;
    @FXML
    private TextField txtBProductos;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidoPagina;
    @FXML
    private Button btnMostrarPedidos;
    @FXML
    private TableColumn<PedidosDTO,String> tcPedidosTalla;
    @FXML
    private TextField txtNombrePromotorPedido;
    @FXML
    private TextField txtApellidoPromotorPedido;
    @FXML
    private ComboBox<String> cmbPromotorPedido;
    @FXML
    private TextField txtPMarca;
    @FXML
    private TextField txtBPedidos;
    @FXML
    private DatePicker dpFechaNacimiento;
    @FXML
    private TableColumn<CatalogoDTO,String> tcFechaIngresoCatalogo;
    @FXML
    private DatePicker dpFechaIngreso;
    @FXML
    private TableColumn<PedidosDTO, String> tcFechaPedido;
    @FXML
    private TableView<PedidosDTO> tblDatosPedidos;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidoID;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidoDni;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidoNombres;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosApellido;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosCatalogo;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosCodigo;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosMarca;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosColor;
    @FXML
    private TableColumn<PedidosDTO, String> tcPedidosPrecio;
    @FXML
    private Button btnModificarProductos;
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
    private JFileChooser fc;
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
    private TableColumn<UsuarioDTO, String> tcUNombre;
    @FXML
    private TableColumn<UsuarioDTO, String> tcUApellido;
    @FXML
    private TableColumn<UsuarioDTO, String> tcUTelefono;
    @FXML
    private TableColumn<UsuarioDTO, String> tcUUsuario;
    @FXML
    private TableColumn<UsuarioDTO, String> tcUContraseña;
    @FXML
    private TableColumn<UsuarioDTO, String> tcURol;
    @FXML
    private TableView<UsuarioDTO> tblUDatos;
    @FXML
    private TextField txtCTelefono;
    @FXML
    private TextField txtRepresentante;
    @FXML
    private TableColumn<CatalogoDTO, String> tcCTelefono;
    @FXML
    private TableColumn<CatalogoDTO, String> tcRepresentante;
    @FXML
    private TableColumn<CatalogoDTO, String> tcCatalogo;
    @FXML
    private TableColumn<CatalogoDTO, Integer> tcNumero;
    @FXML
    private TableView<CatalogoDTO> tblDatosCatalogo;
    @FXML
    private TextField txtCBuscar;
    @FXML
    private TextField txtCatalogo;
    @FXML
    private TextField txtUNombre;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtDni;
    @FXML
    private TextField txtRecomendado;
    @FXML
    private TextField txtBuscar;
    @FXML
    private TableColumn<PromotorDTO, String> tcNombres;
    @FXML
    private TableColumn<PromotorDTO, String> tcApellidos;
    @FXML
    private TableColumn<PromotorDTO, String> tcDireccion;
    @FXML
    private TableColumn<PromotorDTO, String> tcTelefono;
    @FXML
    private TableColumn<PromotorDTO, String> tcCorreo;
    @FXML
    private TableColumn<PromotorDTO, String> tcRecomendado;
    @FXML
    private TableColumn<PromotorDTO, LocalDate> tcFecha;
    @FXML
    private TableColumn<PromotorDTO, String> tcDni;
    @FXML
    private TableView<PromotorDTO> tblDatos;
    @FXML
    private ObservableList<PromotorDTO> lista;
    @FXML
    private ObservableList<CatalogoDTO> listaCatalogoDTOS;
    @FXML
    private ObservableList<UsuarioDTO> listaUsuarioDTO;
    @FXML
    private ObservableList<String> listaRol;
    @FXML
    private ObservableList<String> cmbcata;
    @FXML
    private ObservableList<String> cmbPromotor;
    @FXML
    private ObservableList<String> listaBuscarUsuario;
    @FXML
    private ObservableList<PedidosDTO> listaPedidos;
    @FXML
    private final CatalogoInterface daoCatalogo = DAOFactory.getCatalogoDAO();
    @FXML
    private final PromotorInterface dao = DAOFactory.getPromotorDAO();
    @FXML
    private final UsuarioInterface usr = DAOFactory.getUsuarioDAO();
    @FXML
    private final RolInterface rol = DAOFactory.getRolDAO();
    @FXML
    private final ListaPrecioInterface listaPre = DAOFactory.getListaPrecioDAO();
    @FXML
    private final PedidoInterface pedido = DAOFactory.getPedidoDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MostrarLista();
        MostrarListaCatalogo();
        mostrarUsuario();
        listaRol();
        listaBuscarUsuario();
        mostrarPedidos();
    }

    //Lista de roles
    private void listaRol() {
        List<RolDTO> listar = rol.listar();
        listaRol = FXCollections.observableArrayList();
        listar.forEach(a -> listaRol.addAll(a.getNomrol()));
        cmbRol.setItems(listaRol);
    }

    //Busca a los usuarios
    private void listaBuscarUsuario() {
        listaBuscarUsuario = FXCollections.observableArrayList("Nombre", "Apellidos", "Usuario");
        cmbBuscarUsuarios.setItems(listaBuscarUsuario);
    }

    //Muestra en la tabla la lista de promotor
    private void MostrarLista() {
        List<PromotorDTO> listar = dao.listar();
        lista = FXCollections.observableArrayList();
        tcDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        tcNombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcApellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tcDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tcTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tcCorreo.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        tcRecomendado.setCellValueFactory(new PropertyValueFactory<>("recomendado"));
        tcFecha.setCellValueFactory(new PropertyValueFactory<>("fechaInscripcion"));
        listar.forEach(a -> lista.addAll(a));
        tblDatos.setItems(lista);
    }

    //muestra en la tabla la lista de los catalogos
    private void MostrarListaCatalogo() {
        List<CatalogoDTO> listar = daoCatalogo.listar();
        listaCatalogoDTOS = FXCollections.observableArrayList();
        tcNumero.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcFechaIngresoCatalogo.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tcCatalogo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcRepresentante.setCellValueFactory(new PropertyValueFactory<>("representante"));
        tcCTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        listar.forEach(a -> listaCatalogoDTOS.addAll(a));
        tblDatosCatalogo.setItems(listaCatalogoDTOS);
    }

    //Muestra en la tabla la lista de usuarios
    public void mostrarUsuario() {
        List<UsuarioDTO> listar = usr.listar();
        listaUsuarioDTO = FXCollections.observableArrayList();
        tcUNombre.setCellValueFactory(new PropertyValueFactory<>("nomUsuario"));
        tcUApellido.setCellValueFactory(new PropertyValueFactory<>("apeUsuario"));
        tcUTelefono.setCellValueFactory(new PropertyValueFactory<>("telefUsuario"));
        tcUUsuario.setCellValueFactory(new PropertyValueFactory<>("usuarioUsuario"));
        tcUContraseña.setCellValueFactory(new PropertyValueFactory<>("contraUsuario"));
        tcURol.setCellValueFactory(new PropertyValueFactory<>("rolUsuario"));
        listar.forEach(a -> listaUsuarioDTO.addAll(a));
        tblUDatos.setItems(listaUsuarioDTO);
    }

    @FXML
    //Mostrar Datos de la tabla
    private void Mostrar(ActionEvent event) {
        MostrarLista();
    }

    //Registra al promotor
    @FXML
    private void Registrar(ActionEvent event) {
        PromotorDTO p = IngresarDatos();
        if (txtDni.getText().isEmpty() || txtNombres.getText().isEmpty() ||
                txtApellidos.getText().isEmpty() || txtDireccion.getText().isEmpty()
                || txtRecomendado.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
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
        txtApellidos.setText("");
        txtNombres.setText("");
    }

    //Ingresa datos del promotor
    private PromotorDTO IngresarDatos() {
        LocalDate fechaNacimiento=dpFechaNacimiento.getValue();
        String formato=fechaNacimiento.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        PromotorDTO p = new PromotorDTO(txtDni.getText(),
                txtNombres.getText(),
                txtApellidos.getText(),
                txtDireccion.getText(),
                txtTelefono.getText(),
                LocalDate.parse(formato),
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
        PromotorDTO p = IngresarDatos();
        if (txtDni.getText().isEmpty() || txtNombres.getText().isEmpty() ||
                txtApellidos.getText().isEmpty() || txtDireccion.getText().isEmpty() ||
                txtRecomendado.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
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
        PromotorDTO promotorDTO = tblDatos.getSelectionModel().getSelectedItem();
        if (promotorDTO == null) {
            MostrarLista();
        } else {
            txtDni.setText(promotorDTO.getDni());
            txtNombres.setText(promotorDTO.getNombre());
            txtApellidos.setText(promotorDTO.getApellido());
            txtDireccion.setText(promotorDTO.getDireccion());
            txtTelefono.setText(promotorDTO.getTelefono());
            txtRecomendado.setText(promotorDTO.getRecomendado());
        }

    }

    //Busca al promotor
    @FXML
    void buscar(MouseEvent mouseEvent) {
        FilteredList<PromotorDTO> filtrar = new FilteredList<>(lista, b -> true);
        txtBuscar.textProperty().addListener((ObservableList, oldValue, newValue) -> {
            filtrar.setPredicate(promotorDTO -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                //Filtrar Por DNI del Promotor
                return promotorDTO.getDni().toLowerCase().contains(lowerCaseFilter);
            });
        });
        SortedList<PromotorDTO> sorted = new SortedList<>(filtrar);
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
        UsuarioDTO u = DatosUsuario();
        if (txtUUsuario.getText().isEmpty() || txtUApellido.getText().isEmpty()
                || txtUNombre.getText().isEmpty() || txtUTelefono.getText().isEmpty() ||
                txtUContraseña.getText().isEmpty() || txtURepiteContraseña.getText().isEmpty()) {

            Error();

        } else {

            if (txtUUsuario.equals(u.getUsuarioUsuario())) {
                usr.grabar(u);
            } else {
                usr.grabar(u);
                JOptionPane.showMessageDialog(null, "Registro guardado", "Registro", 1);
            }
        }
        limpiarUsuario();
        mostrarUsuario();
    }

    //Ingresa datos de usuario
    private UsuarioDTO DatosUsuario() {
        UsuarioDTO u = new UsuarioDTO(txtUUsuario.getText(), txtUContraseña.getText());
        u.setNomUsuario(txtUNombre.getText());
        u.setApeUsuario(txtUApellido.getText());
        u.setTelefUsuario(txtUTelefono.getText());
        u.setRolUsuario(cmbRol.getValue());
        return u;
    }

    //Modifica datos al usuario
    @FXML
    private void ModificarUsuario(ActionEvent actionEvent) {
        UsuarioDTO u = DatosUsuario();
        if (txtUNombre.getText().isEmpty() || txtUApellido.getText().isEmpty() ||
                txtUTelefono.getText().isEmpty() || txtUUsuario.getText().isEmpty() ||
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
        String id = txtUUsuario.getText();
        usr.eliminar(id);
        mostrarUsuario();
        limpiarUsuario();
    }

    //manda los datos de la tabla a la caja de texto del usuario
    @FXML
    private void datosUsuario(MouseEvent mouseEvent) {
        UsuarioDTO usuarioDTO = tblUDatos.getSelectionModel().getSelectedItem();
        if (usuarioDTO == null) {
            MostrarLista();
        } else {
            txtUNombre.setText(usuarioDTO.getNomUsuario());
            txtUApellido.setText(usuarioDTO.getApeUsuario());
            txtUTelefono.setText(usuarioDTO.getTelefUsuario());
            txtUUsuario.setText(usuarioDTO.getUsuarioUsuario());
            txtUContraseña.setText(usuarioDTO.getContraUsuario());
            cmbRol.getSelectionModel().select(usuarioDTO.getRolUsuario());

        }
    }

    //Limpia el catalogo
    @FXML
    private void LimpiarCatalogo(ActionEvent actionEvent) {
        limpiarCatalogo();
    }

    //codigo para Limpiar el catalogo
    private void limpiarCatalogo() {
        txtIdCatalogo.setText("");
        txtCatalogo.setText("");
        txtRepresentante.setText("");
        txtCTelefono.setText("");
    }

    //Ingresa datos del catalogo
    private CatalogoDTO DatosCatalogo() {
        LocalDate fechaIngreso=dpFechaIngreso.getValue();
        String formato=fechaIngreso.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        CatalogoDTO c = new CatalogoDTO();
        c.setFecha(LocalDate.parse(formato));
        c.setNombre(txtCatalogo.getText());
        c.setRepresentante(txtRepresentante.getText());
        c.setTelefono(txtCTelefono.getText());
        return c;
    }

    //Codigo para mandar error
    private void Error() {
        JOptionPane.showMessageDialog(null, "Error. Datos Vacios", "Error", 1);
    }

    //Registra el catalogo
    @FXML
    private void RegistrarCatalogo(ActionEvent actionEvent) {
        CatalogoDTO c = DatosCatalogo();
        if (txtCatalogo.getText().isEmpty() || txtRepresentante.getText().isEmpty() ||
                txtCTelefono.getText().isEmpty()) {
            Error();
        } else {
            if (txtDni.equals(c.getNombre()))
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
        int id = Integer.parseInt(txtIdCatalogo.getText());
        daoCatalogo.eliminar(id);
        MostrarListaCatalogo();
        limpiarCatalogo();

    }

    //Modifica el catalogo
    @FXML
    private void ModificarCatalogo(ActionEvent actionEvent) {
        CatalogoDTO c = DatosCatalogo();
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
        FilteredList<CatalogoDTO> filtrar = new FilteredList<>(listaCatalogoDTOS, b -> true);
        txtCBuscar.textProperty().addListener((ObservableList, oldValue, newValue) -> {
            filtrar.setPredicate(catalogoDTO -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                //Filtrar Por Nombre del catalogo del Promotor
                return catalogoDTO.getNombre().toLowerCase().contains(lowerCaseFilter);
            });
        });
        SortedList<CatalogoDTO> sorted = new SortedList<>(filtrar);
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
        CatalogoDTO catalogoDTO = tblDatosCatalogo.getSelectionModel().getSelectedItem();
        if (catalogoDTO == null) {
            MostrarLista();
        } else {
            txtIdCatalogo.setText(String.valueOf(catalogoDTO.getId()));
            txtCatalogo.setText(catalogoDTO.getNombre());
            txtRepresentante.setText(catalogoDTO.getRepresentante());
            txtCTelefono.setText(catalogoDTO.getTelefono());

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
        FilteredList<UsuarioDTO> filtrar = new FilteredList<>(listaUsuarioDTO, b -> true);
        txtUBuscar.textProperty().addListener((ObservableList, oldValue, newValue) -> {
            filtrar.setPredicate(usuarioDTO -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (cmbBuscarUsuarios.getValue() != null) {
                    switch (cmbBuscarUsuarios.getValue()) {
                        //Filtrar Por Nombre del Usuario
                        case "Nombre": {
                            return usuarioDTO.getNomUsuario().toLowerCase().contains(lowerCaseFilter);
                        }
                        //Filtrar por apellido del Usuario
                        case "Apellidos": {
                            return usuarioDTO.getApeUsuario().toLowerCase().contains(lowerCaseFilter);
                        }
                        //Filtrar por Nombre de Usuario del Usuario
                        case "Usuario": {
                            return usuarioDTO.getUsuarioUsuario().toLowerCase().contains(lowerCaseFilter);
                        }
                    }
                } else {
                    //Muestra la lista de usuarios
                    mostrarUsuario();
                }
                return false;
            });
        });
        SortedList<UsuarioDTO> sorted = new SortedList<>(filtrar);
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


    //Importar Precios de los catalogos
    @FXML
    private void importarPrecios(ActionEvent actionEvent) {
        fc = new JFileChooser();
        String r = "";
        int seleccion = fc.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            r = listaPre.Importar(f);
            JOptionPane.showMessageDialog(null, r);
        }
    }

    //Muestra los catalogos en el combobox
    @FXML
    private void cmbmuestracata(MouseEvent mouseEvent) {
        List<CatalogoDTO> listar = daoCatalogo.listar();
        cmbcata = FXCollections.observableArrayList();
        listar.forEach(a -> cmbcata.addAll(a.getNombre()));
        cmbCatalogosP.setItems(cmbcata);
    }


    //Codigo de limpiar Productos
    private void limpiarProductos() {
        txtPPagina.setText("");
        txtPCodigo.setText("");
        txtPMarca.setText("");
        txtPColor.setText("");
        txtPTalla.setText("");
        txtPPrecio.setText("");
    }




    //Limpia las cajas de texto del producto

    @FXML
    private void ListaPrecios(MouseEvent mouseEvent) {
    }

    @FXML
    private void LimpiarPedidosProductos(ActionEvent actionEvent) {
    }

    private void mostrarPedidos() {
        List<PedidosDTO> listar = pedido.listar();
            listaPedidos = FXCollections.observableArrayList();
            tcPedidoID.setCellValueFactory(new PropertyValueFactory<>("idPedido"));
            tcPedidoDni.setCellValueFactory(new PropertyValueFactory<>("dniPromotor"));
            tcPedidoNombres.setCellValueFactory(new PropertyValueFactory<>("nombrepromotor"));
            tcPedidosApellido.setCellValueFactory(new PropertyValueFactory<>("apepromotor"));
            tcPedidosCatalogo.setCellValueFactory(new PropertyValueFactory<>("nomCatalogo"));
            tcPedidoPagina.setCellValueFactory(new PropertyValueFactory<>("pagina"));
            tcPedidosCodigo.setCellValueFactory(new PropertyValueFactory<>("codProducto"));
            tcPedidosMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
            tcPedidosColor.setCellValueFactory(new PropertyValueFactory<>("color"));
            tcPedidosTalla.setCellValueFactory(new PropertyValueFactory<>("talla"));
            tcPedidosPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
            tcFechaPedido.setCellValueFactory(new PropertyValueFactory<>("fechaPedido"));
            listar.forEach(a -> listaPedidos.addAll(a));
            tblDatosPedidos.setItems(listaPedidos);
    }

    @FXML
    private void RegistrarPedidos(ActionEvent actionEvent) {
    }

    @FXML
    private void ModificarPedidos(ActionEvent actionEvent) {
    }

    @FXML
    private void EliminarPedidos(ActionEvent actionEvent) {
    }

    @FXML
    private void mostrarPedidos(ActionEvent actionEvent) {
        btnMostrarPedidos.setOnAction(pedidos->{
            mostrarPedidos();
        });
    }

    @FXML
    private void ListaPedidos(MouseEvent mouseEvent) {
    }

    @FXML
    private void MostrarPrecios(ActionEvent actionEvent) {
    }

    @FXML
    private void LimpiarPedidos(ActionEvent actionEvent) {
    }

    @FXML
    private void muestraPromotorPedido(MouseEvent mouseEvent) {
        List<PromotorDTO> listar = dao.listar();
        cmbPromotor = FXCollections.observableArrayList();
        listar.forEach(a -> cmbPromotor.addAll(a.getDni()));
        cmbPromotorPedido.setItems(cmbPromotor);
    }
}
