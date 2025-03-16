package PoGpt.Gpt.service;

import PoGpt.Gpt.model.Faturas;
import PoGpt.Gpt.model.dtos.FaturasDto;
import PoGpt.Gpt.repository.FaturasRepository;
import PoGpt.Gpt.repository.ClientesRepository;
import PoGpt.Gpt.repository.VendedoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FaturasService {

    private final FaturasRepository repository;
    private final ClientesRepository clientesRepository;
    private final VendedoresRepository vendedoresRepository;

    public Faturas salvarFatura(FaturasDto dto) {
        var cliente = clientesRepository.findById(dto.idCliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        var vendedor = vendedoresRepository.findById(dto.idVendedor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendedor não encontrado"));

        Faturas fatura = new Faturas();
        fatura.setData(dto.data());
        fatura.setCliente(cliente);
        fatura.setVendedor(vendedor);

        return repository.save(fatura);
    }

    public List<Faturas> listarFaturas() {
        return repository.findAll();
    }

    public Optional<Faturas> buscarFaturaPorId(UUID id) {
        return repository.findById(id);
    }

    public void atualizarFatura(UUID id, FaturasDto dto) {
        var fatura = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fatura não encontrada"));

        var cliente = clientesRepository.findById(dto.idCliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        var vendedor = vendedoresRepository.findById(dto.idVendedor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendedor não encontrado"));

        fatura.setData(dto.data());
        fatura.setCliente(cliente);
        fatura.setVendedor(vendedor);

        repository.save(fatura);
    }

    public boolean deletarFatura(UUID id) {
        Optional<Faturas> faturaOptional = repository.findById(id);
        if (faturaOptional.isPresent()) {
            repository.delete(faturaOptional.get());
            return true;
        }
        return false;
    }
}
