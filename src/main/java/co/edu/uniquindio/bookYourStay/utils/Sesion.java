package co.edu.uniquindio.bookYourStay.utils;

import co.edu.uniquindio.bookYourStay.controlador.ControladorPrincipal;
import co.edu.uniquindio.bookYourStay.modelo.Cliente;
import lombok.Getter;
import lombok.Setter;

public class Sesion {

    @Getter
    @Setter
    private Cliente cliente;
    private static Sesion INSTANCIA;

    private Sesion(){}

    public static Sesion getInstancia(){
        if(INSTANCIA == null){
            INSTANCIA = new Sesion();
        }
        return INSTANCIA;
    }

    public void asignarCliente(Cliente cliente){
        INSTANCIA.setCliente(cliente);
    }

    public Cliente obtenerCliente(){
        return INSTANCIA.getCliente();
    }


}
