package co.edu.uniquindio.bookYourStay.modelo;

import co.edu.uniquindio.bookYourStay.modelo.enums.Rol;
import co.edu.uniquindio.bookYourStay.servicio.CreacionAlojamiento;
import co.edu.uniquindio.bookYourStay.servicio.ServiciosBookYourStay;
import co.edu.uniquindio.bookYourStay.utils.EnvioEmail;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Setter
public class BookYourStay implements ServiciosBookYourStay {

    private ArrayList<Cliente> clientes;

    public BookYourStay() {
        this.clientes = new ArrayList<>();
        this.clientes.add(Cliente.builder()
                .rol(Rol.ADMIN)
                .correo("pepito")
                .contrasena("123")
                .build());
    }

    @Override
    public Cliente agregarCliente(String cedula, String nombre, String telefono, String correo,
                                  String contrasena) throws Exception {

        if (cedula.isBlank()) {
            throw new Exception("La cédula es obligatoria");
        }

        if (!cedula.matches("\\d+") || cedula.length() < 7 || cedula.length() > 10) {
            throw new Exception("Cédula inválida");
        }

        if (obtenerCliente(cedula) != null) {
            throw new Exception("Ya existe un usuario con la misma cédula");
        }

        if (nombre.isBlank()) {
            throw new Exception("El nombre es obligatorio");
        }

        if (telefono.isEmpty()){
            throw new Exception("El teléfono es obligatorio");
        }

        if (!telefono.matches("\\d+") || telefono.length() != 10 || telefono.charAt(0) != '3') {
            throw new Exception("El número de teléfono es inválido");
        }

        if (correo.isEmpty()) {
            throw new Exception("El correo es obligatorio");
        }

        if (obtenerClientePorCorreo(correo) != null){
            throw new Exception("Ya hay un usuario registrado con el mismo correo");
        }

        if (contrasena.length() < 6) {
            throw new Exception("La contraseña debe tener mínimo 6 caracteres");
        }

        Cliente cliente = Cliente.builder()
                .cedula(cedula)
                .nombre(nombre)
                .telefono(telefono)
                .correo(correo)
                .contrasena(contrasena)
                .primerLogin(true)
                .rol(Rol.CLIENTE)
                .id(generarCodigoRegistro())
                .build();

        clientes.add(cliente);
        return cliente;
    }

    public String generarCodigoRegistro() {
        StringBuilder codigoRegistro = new StringBuilder();


        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int numero = random.nextInt(8);
            codigoRegistro.append(numero);
        }

        return codigoRegistro.toString();
    }

    @Override
    public void EnviarCodigoRegistro(){
        for (Cliente cliente : clientes){
            if (cliente.getRol() == Rol.CLIENTE){
                String correo = cliente.getCorreo();
                String asunto = "Código de verificación cuenta BookYourStay" ;
                String mensaje = "Hola "+cliente.getNombre()+", Su código de verificación es: "+cliente.getId()+ " gracias por registrarse en nuestra app";
                EnvioEmail envioEmail = new EnvioEmail(correo, asunto, mensaje);
                envioEmail.enviarNotificacion();
            }

        }
    }


    @Override
    public void reenviarCodigoRegistro(){
        for (Cliente cliente : clientes){
            if (cliente.getRol() == Rol.CLIENTE){
                cliente.setId(generarCodigoRegistro());
                String correo = cliente.getCorreo();
                String asunto = "Nuevo código de verificación cuenta BookYourStay" ;
                String mensaje = "Su nuevo código de verificación es: "+cliente.getId()+", gracias por registrarse en nuestra app";
                EnvioEmail envioEmail = new EnvioEmail(correo, asunto, mensaje);
                envioEmail.enviarNotificacion();

            }
        }

    }


    public Cliente obtenerCliente(String cedula){
        for (Cliente cliente : clientes){
            if (cliente.getCedula() != null && cliente.getCedula().equals(cedula) && cliente.getRol() == Rol.CLIENTE){
                return cliente;
            }
        }
        return null;
    }

    public Cliente obtenerClientePorCorreo(String correo){
        for (Cliente cliente : clientes){
            if (cliente.getCorreo().equals(correo)){
                return cliente;
            }
        }
        return null;
    }


    @Override
    public Cliente validarCliente(String correo, String contrasena) throws Exception{
        Cliente cliente = obtenerClientePorCorreo(correo);
        if (cliente != null) {
            if (cliente.getContrasena().equals(contrasena)) {
                return cliente;
            }
        }
        throw new Exception("Los datos de ingreso son incorrectos");
    }



    @Override
    public boolean verificarCodigo(String codigo) throws Exception {
        for (Cliente cliente : clientes) {
            if (cliente.getRol() == Rol.CLIENTE && cliente.getId().equals(codigo)) {
                cliente.setPrimerLogin(false);
                return true;
            }
        }
        throw new Exception("El código es incorrecto");
    }

    public Alojamiento agregarAlojamiento(String nombre, String ciudad, String descripcion, int capacidadMaxima)throws Exception{

        CreacionAlojamiento creacionAlojamiento;


        return null;
    }
}
