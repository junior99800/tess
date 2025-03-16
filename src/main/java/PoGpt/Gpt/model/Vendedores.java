package PoGpt.Gpt.model;


import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "vendedores")
public class Vendedores {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idvendedores;

    @Column(length = 45, nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate datacontrato;

    @Column(nullable = false)
    private BigDecimal salario;

    @Column(nullable = false)
    private BigDecimal comissao;
}

