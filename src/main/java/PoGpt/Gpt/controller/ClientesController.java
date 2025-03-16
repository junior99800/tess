package PoGpt.Gpt.controller;


import PoGpt.Gpt.model.Clientes;
import PoGpt.Gpt.model.dtos.ClientesDto;
import PoGpt.Gpt.service.ClientesService;
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
@RequestMapping("/clientes")
public class ClientesController {

    private final ClientesService service;


    @PostMapping
    public ResponseEntity<Clientes> savaClientes(@RequestBody @Validated ClientesDto dto) {
        Clientes clientes = service.saveClientes(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientes);
    }


    @GetMapping
    public List<Clientes> getAllClientes() {
        return service.getAllClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> getClientesById(@PathVariable("id") UUID id){
        Optional<Clientes> user = service.getClientesById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCLientesByid(@PathVariable("id") UUID id,
                                                   @RequestBody ClientesDto dto){
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

