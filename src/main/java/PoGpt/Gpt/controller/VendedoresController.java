package PoGpt.Gpt.controller;

import PoGpt.Gpt.model.Vendedores;
import PoGpt.Gpt.model.dtos.VendedoresDto;
import PoGpt.Gpt.service.VendedoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vendedores")
public class VendedoresController {

    private final VendedoresService service;

    @PostMapping
    public ResponseEntity<Vendedores> saveVendedor(@RequestBody @Validated VendedoresDto dto) {
        Vendedores vendedor = service.saveVendedor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendedor);
    }

    @GetMapping
    public List<Vendedores> getAllVendedores() {
        return service.getAllVendedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedores> getVendedorById(@PathVariable("id") UUID id) {
        Optional<Vendedores> vendedor = service.getVendedorById(id);
        return vendedor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVendedorById(@PathVariable("id") UUID id,
                                                   @RequestBody VendedoresDto dto) {
        service.atualizar(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") UUID id) {
        boolean deletado = service.deletar(id);
        if (!deletado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
