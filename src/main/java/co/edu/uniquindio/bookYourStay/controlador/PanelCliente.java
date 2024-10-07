package co.edu.uniquindio.bookYourStay.controlador;

import co.edu.uniquindio.bookYourStay.modelo.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class PanelCliente implements Initializable {

//    private final Cliente cliente;
//    @FXML
//    private Text nombre;

    public PanelCliente(){
        ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();
//        this.cliente = controladorPrincipal.obtenerSesion();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        if(this.cliente != null){
//            this.nombre.setText(cliente.getNombre());
//        }else{
//            System.out.println("Es null");
//        }

    }
}
