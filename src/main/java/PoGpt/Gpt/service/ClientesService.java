package PoGpt.Gpt.service;

import PoGpt.Gpt.model.Clientes;
import PoGpt.Gpt.model.dtos.ClientesDto;
import PoGpt.Gpt.repository.ClientesRepository;
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
public class ClientesService {

    private final ClientesRepository repository;

    public Clientes saveClientes(ClientesDto dto) {
        Clientes clientes = new Clientes();
        BeanUtils.copyProperties(dto, clientes);
        return repository.save(clientes);
    }

    public List<Clientes> getAllClientes() {
        return repository.findAll();
    }

    public Optional<Clientes> getClientesById(UUID id){
        return repository.findById(id);
    }

    public void atualizar(UUID id, ClientesDto dto) {
        var clienteEntity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        if (dto.nome() != null) clienteEntity.setNome(dto.nome());
        if (dto.cep() != null) clienteEntity.setCep(dto.cep());
        if (dto.cidade() != null) clienteEntity.setCidade(dto.cidade());
        if (dto.endereco() != null) clienteEntity.setEndereco(dto.endereco());

        repository.save(clienteEntity);
    }

    public boolean deletar(UUID id) {
        Optional<Clientes> clientesOptional = repository.findById(id);
        if (clientesOptional.isPresent()) {
            repository.delete(clientesOptional.get());
            return true;
        }
        return false;
    }


}
