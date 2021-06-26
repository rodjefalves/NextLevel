package desafio.api.service;

import desafio.api.entity.Empresa;
import desafio.api.exception.EmpresaNaoEncontradaException;
import desafio.api.repository.EmpresaRepository;
import desafio.api.rest.dto.EmpresaDTO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> buscarTodasEmpresas(Empresa filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);

        return empresaRepository.findAll(example);
    }

    public EmpresaDTO buscarUmaEmpresa(Integer id){

        return empresaRepository.findById(id)
                .map(empresa -> EmpresaDTO
                        .builder()
                        .id(empresa.getId())
                        .nome(empresa.getNome())
                        .email(empresa.getEmail())
                        .build())
                .orElseThrow(() -> new EmpresaNaoEncontradaException(id));
    }
}
