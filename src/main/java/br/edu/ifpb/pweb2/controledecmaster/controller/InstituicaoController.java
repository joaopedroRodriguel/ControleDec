package br.edu.ifpb.pweb2.controledecmaster.controller;

import br.edu.ifpb.pweb2.controledecmaster.model.Instituicao;
import br.edu.ifpb.pweb2.controledecmaster.service.InstituicaoService;
import br.edu.ifpb.pweb2.controledecmaster.service.PeriodoLetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/instituicao")
public class InstituicaoController {

    @Autowired
    InstituicaoService instituicaoService;

    PeriodoLetivoService periodoLetivoService;

    @GetMapping("/listinstituicoes")
    public ResponseEntity<?> list(){
        List<Instituicao> instituicoes = instituicaoService.list();
        return new ResponseEntity<>(instituicoes, HttpStatus.OK);
    }

    @GetMapping("/searchinstituicao/{id}")
    public ResponseEntity<?> search(Long id) {
        Optional<Instituicao> instituicao = instituicaoService.search(id);
        return new ResponseEntity<>(instituicao, HttpStatus.OK);
    }

    @PostMapping("/insertinstituicao")
    public ResponseEntity<?> insert(@RequestBody Instituicao instituicao) {
        return new ResponseEntity<>(instituicaoService.insert(instituicao), HttpStatus.CREATED);
    }

    @PutMapping("/updateinstituicao/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Instituicao newInstituicao){
        Instituicao instituicao = instituicaoService.update(id, newInstituicao);
        return new ResponseEntity<>(instituicao, HttpStatus.OK);
    }

    @DeleteMapping("/deleteinstituicao/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        instituicaoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
