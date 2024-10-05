package co.edu.uniquindio.bookYourStay.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioControlador {

    @FXML
    private Button btnIniciarSesion;
    @FXML
    private Button btnRegistrarse;

    private final ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();

    public void irInicioSesion(ActionEvent actionEvent) throws Exception {
        controladorPrincipal.navegarVentana("/login.fxml", "Inicio de sesión");
        controladorPrincipal.cerrarVentana(btnIniciarSesion);
    }

    public void irRegistro(ActionEvent actionEvent) throws Exception {
        controladorPrincipal.cerrarVentana(btnRegistrarse);
        controladorPrincipal.navegarVentana("/registro.fxml", "Registro de usuario");

    }
}
