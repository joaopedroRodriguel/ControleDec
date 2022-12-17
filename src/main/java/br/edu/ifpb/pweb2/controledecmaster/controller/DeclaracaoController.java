package br.edu.ifpb.pweb2.controledecmaster.controller;

import br.edu.ifpb.pweb2.controledecmaster.model.Declaracao;
import br.edu.ifpb.pweb2.controledecmaster.service.DeclaracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/declaracao")
public class DeclaracaoController {

    @Autowired
    DeclaracaoService declaracaoService;

    @PostMapping("/insertdeclaracao")
    public ResponseEntity<?> insert(@RequestBody Declaracao declaracao) {
        return new ResponseEntity<>(declaracaoService.insert(declaracao), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(declaracaoService.listar(), HttpStatus.OK);
    }


    @GetMapping("/buscarEstudante/{id}")
    public ResponseEntity<?> search(Long id) {
        return new ResponseEntity<>(declaracaoService.buscarDeclaracaoPorEstudante(id), HttpStatus.OK);
    }

    @GetMapping("/declaracoesvencidas")
    public ResponseEntity<?> declaracoesvencidas() {
        return new ResponseEntity<>(declaracaoService.declaracaosVencidas(), HttpStatus.OK);
    }
}
