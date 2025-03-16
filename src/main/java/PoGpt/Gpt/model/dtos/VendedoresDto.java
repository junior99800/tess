package PoGpt.Gpt.model.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record VendedoresDto(
        String nome,
        LocalDate datacontrato,
        BigDecimal salario,
        BigDecimal comissao
) {
}
