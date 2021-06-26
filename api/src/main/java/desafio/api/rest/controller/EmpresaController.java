package desafio.api.rest.controller;

import desafio.api.entity.Empresa;
import desafio.api.rest.dto.EmpresaDTO;
import desafio.api.service.EmpresaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api( tags = "Empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @CrossOrigin
    @ApiOperation(value = "Buscar todas as empresas")
    @GetMapping("/empresas")
    public List<Empresa> buscarTodosProdutos(Empresa filtro) {
        return empresaService.buscarTodasEmpresas(filtro);
    }


    @CrossOrigin
    @GetMapping("/empresas/{id}")
    @ApiOperation(value = "Endpoint de busca de empresa por id.")
    public EmpresaDTO buscarUmProfile(@PathVariable(value = "id") Integer id){
        return empresaService.buscarUmaEmpresa(id);
    }

}
