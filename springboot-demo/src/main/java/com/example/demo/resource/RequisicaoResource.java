package com.example.demo.resource;
import com.example.demo.service.RequisicaoService;
import com.example.demo.domain.Dados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/requisicao")
public class RequisicaoResource {

    @Autowired
    private RequisicaoService requisicaoService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> retornarResultado(@RequestBody Dados dados) throws Exception {
        String resultado = requisicaoService.executarRequisicao(dados);
        return ResponseEntity.ok().body(resultado);
    }
}
