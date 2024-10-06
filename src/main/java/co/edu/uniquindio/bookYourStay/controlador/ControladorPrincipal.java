package co.edu.uniquindio.bookYourStay.controlador;

import co.edu.uniquindio.bookYourStay.modelo.BookYourStay;
import co.edu.uniquindio.bookYourStay.modelo.Cliente;
import co.edu.uniquindio.bookYourStay.servicio.ServiciosBookYourStay;
import co.edu.uniquindio.bookYourStay.utils.Sesion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lombok.Getter;

@Getter
public class ControladorPrincipal implements ServiciosBookYourStay {

    private final BookYourStay bookYourStay;

    public static ControladorPrincipal INSTANCIA;

    public ControladorPrincipal(){bookYourStay = new BookYourStay();}

    public static ControladorPrincipal getInstancia(){
        if(INSTANCIA == null){
            INSTANCIA = new ControladorPrincipal();
        }
        return INSTANCIA;
    }

    public FXMLLoader navegarVentana(String nombreArchivoFxml, String tituloVentana) throws Exception {

        // Cargar la vista
        FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));
        Parent root = loader.load();

        // Crear la escena
        Scene scene = new Scene(root);

        // Crear un nuevo escenario (ventana)
        Stage stage = new Stage();
        stage.setScene(scene);
        //stage.setResizable(false);
        stage.setTitle(tituloVentana);

        // Mostrar la nueva ventana
        stage.show();

        return loader;
    }

    public void crearAlerta(String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


    public void cerrarVentana(Node node) {
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    @Override
    public Cliente agregarCliente(String cedula, String nombre, String telefono, String correo, String contrasena) throws Exception {
        return bookYourStay.agregarCliente(cedula, nombre, telefono, correo, contrasena);
    }

    @Override
    public void EnviarCodigoRegistro() {
        bookYourStay.EnviarCodigoRegistro();
    }

    @Override
    public void reenviarCodigoRegistro() {
        bookYourStay.reenviarCodigoRegistro();
    }

    @Override
    public Cliente validarCliente(String correo, String contrasena) throws Exception {
        return bookYourStay.validarCliente(correo, contrasena);
    }

    @Override
    public boolean verificarCodigo(String codigo) throws Exception {
        return bookYourStay.verificarCodigo(codigo);
    }

    public void guardarSesion(Cliente cliente){
        Sesion sesion = Sesion.getInstancia();
        sesion.asignarCliente(cliente);
    }

    public Cliente obtenerSesion(){
        return Sesion.getInstancia().obtenerCliente();
    }

    public void eliminarSesion(){
        Sesion.getInstancia().asignarCliente(null);
    }

}
