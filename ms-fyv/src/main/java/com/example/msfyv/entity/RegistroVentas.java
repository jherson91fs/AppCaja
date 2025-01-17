package com.example.msfyv.entity;

import com.example.msfyv.dto.PersonalDto;
import com.example.msfyv.dto.ProductoDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "registro_ventas")
public class RegistroVentas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Date fecha_hora;
    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;
    private Integer personalId;

    public RegistroVentas() {
    }
    @PrePersist
    protected void onCreate() {
        fecha_hora = new Date();
    }
    @Transient
    private PersonalDto personalDto;
}
