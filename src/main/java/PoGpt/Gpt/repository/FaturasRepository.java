package PoGpt.Gpt.repository;


import PoGpt.Gpt.model.Faturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface FaturasRepository extends JpaRepository<Faturas, UUID> {
}

