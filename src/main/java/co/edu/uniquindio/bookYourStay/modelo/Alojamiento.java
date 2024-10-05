package co.edu.uniquindio.bookYourStay.modelo;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Alojamiento {
    private String nombre, ciudad, descripcion;
    private double precioNoche;
    private int capacidadMaxima;

}
