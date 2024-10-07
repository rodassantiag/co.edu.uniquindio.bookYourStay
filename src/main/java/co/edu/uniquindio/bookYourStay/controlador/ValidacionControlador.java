package co.edu.uniquindio.bookYourStay.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ValidacionControlador {

    ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();

    @FXML
    private TextField txtCodigoVerificacion;

    public void verificarCodigo(ActionEvent actionEvent) throws Exception {

        try {
            String codigoVerificacion = txtCodigoVerificacion.getText().trim();

            if (controladorPrincipal.verificarCodigo(codigoVerificacion)){
                controladorPrincipal.crearAlerta("Su cuenta se ha validado exitosamente", Alert.AlertType.INFORMATION);
                cerrarVentana();
                irPanelCliente();
            }
        } catch (Exception e) {
            e.printStackTrace();
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    public void nuevoCodigo(ActionEvent actionEvent) throws Exception {

        try {
            controladorPrincipal.crearAlerta("Se ha reenviado el codigo", Alert.AlertType.INFORMATION);
            controladorPrincipal.reenviarCodigoRegistro();

        }catch (Exception e){
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }




    public void irPanelCliente() throws Exception {
        controladorPrincipal.navegarVentana("/panelCliente.fxml", "Panel cliente");
    }


    public void cerrarVentana() throws Exception{
        controladorPrincipal.cerrarVentana(txtCodigoVerificacion);
    }

}

