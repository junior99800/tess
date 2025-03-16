package PoGpt.Gpt.controller;

import PoGpt.Gpt.model.Faturas;
import PoGpt.Gpt.model.dtos.FaturasDto;
import PoGpt.Gpt.service.FaturasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/faturas")
public class FaturasController {

    private final FaturasService service;

    @PostMapping
    public ResponseEntity<Faturas> salvarFatura(@RequestBody FaturasDto dto) {
        Faturas fatura = service.salvarFatura(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(fatura);
    }

    @GetMapping
    public List<Faturas> listarFaturas() {
        return service.listarFaturas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faturas> buscarFaturaPorId(@PathVariable("id") UUID id) {
        Optional<Faturas> fatura = service.buscarFaturaPorId(id);
        return fatura.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarFatura(@PathVariable("id") UUID id, @RequestBody FaturasDto dto) {
        service.atualizarFatura(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFatura(@PathVariable("id") UUID id) {
        boolean deletado = service.deletarFatura(id);
        if (!deletado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
