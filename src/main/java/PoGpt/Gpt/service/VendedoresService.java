package PoGpt.Gpt.service;

import PoGpt.Gpt.model.Vendedores;
import PoGpt.Gpt.model.dtos.VendedoresDto;
import PoGpt.Gpt.repository.VendedoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class VendedoresService {

    private final VendedoresRepository repository;

    public Vendedores saveVendedor(VendedoresDto dto) {
        Vendedores vendedor = new Vendedores();
        BeanUtils.copyProperties(dto, vendedor);
        return repository.save(vendedor);
    }

    public List<Vendedores> getAllVendedores() {
        return repository.findAll();
    }

    public Optional<Vendedores> getVendedorById(UUID id) {
        return repository.findById(id);
    }

    public void atualizar(UUID id, VendedoresDto dto) {
        var vendedorEntity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendedor não encontrado"));

        if (dto.nome() != null) vendedorEntity.setNome(dto.nome());
        if (dto.datacontrato() != null) vendedorEntity.setDatacontrato(dto.datacontrato());
        if (dto.salario() != null) vendedorEntity.setSalario(dto.salario());
        if (dto.comissao() != null) vendedorEntity.setComissao(dto.comissao());

        repository.save(vendedorEntity);
    }

    public boolean deletar(UUID id) {
        Optional<Vendedores> vendedorOptional = repository.findById(id);
        if (vendedorOptional.isPresent()) {
            repository.delete(vendedorOptional.get());
            return true;
        }
        return false;
    }
}
