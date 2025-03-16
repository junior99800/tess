package PoGpt.Gpt.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idclientes;

    @Column(length = 45, nullable = false)
    private String nome;

    @Column(length = 45, nullable = false)
    private String endereco;

    @Column(length = 45, nullable = false)
    private String cidade;

    @Column(length = 45)
    private String cep;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Faturas> faturas;
}

