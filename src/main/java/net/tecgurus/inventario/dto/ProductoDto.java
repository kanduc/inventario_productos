package net.tecgurus.inventario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductoDto {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String nombre;

    @JsonProperty
    private double precio;

}
