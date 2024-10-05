package co.edu.uniquindio.bookYourStay.modelo;

import co.edu.uniquindio.bookYourStay.modelo.enums.Rol;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
    private String cedula, nombre, correo, telefono, contrasena, id;
    private Rol rol;
    private boolean primerLogin;
}
