package co.edu.uniquindio.bookYourStay.servicio;

import co.edu.uniquindio.bookYourStay.modelo.Cliente;

public interface ServiciosBookYourStay {


    Cliente agregarCliente(String cedula, String nombre, String telefono, String correo, String contrasena) throws Exception;

    void EnviarCodigoRegistro();

    void reenviarCodigoRegistro();

    Cliente validarCliente(String correo, String contrasena) throws Exception;

    Cliente validarAdmin(String correo, String contrasena) throws Exception;

    boolean verificarCodigo(String codigo) throws Exception;
}
