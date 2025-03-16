package PoGpt.Gpt.repository;


import PoGpt.Gpt.model.Vendedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface VendedoresRepository extends JpaRepository<Vendedores, UUID> {
}

