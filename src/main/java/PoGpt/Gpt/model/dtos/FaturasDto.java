package PoGpt.Gpt.model.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record FaturasDto(
        LocalDate data,
        UUID idCliente,
        UUID idVendedor
) {}
