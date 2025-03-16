package PoGpt.Gpt.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "faturas")
public class Faturas {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idfaturas;

    @Column(nullable = false)
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "idclientes")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "idvendedores")
    private Vendedores vendedor;
}

