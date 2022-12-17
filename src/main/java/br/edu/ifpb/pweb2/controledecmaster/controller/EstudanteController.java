package br.edu.ifpb.pweb2.controledecmaster.controller;

import br.edu.ifpb.pweb2.controledecmaster.model.Estudante;
import br.edu.ifpb.pweb2.controledecmaster.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/estudante")
public class EstudanteController {

    @Autowired
    EstudanteService estudanteService;

    @GetMapping("/listestudantes")
    public ResponseEntity<?> list(){
        List<Estudante> estudantes = estudanteService.list();
        return new ResponseEntity<>(estudantes, HttpStatus.OK);
    }

    @GetMapping("/searchestudante/{id}")
    public ResponseEntity<?> search(Long id) {
        Optional<Estudante> estudante = estudanteService.search(id);
        return new ResponseEntity<>(estudante, HttpStatus.OK);
    }

    @PostMapping("/insertestudante")
    public ResponseEntity<?> insert(@RequestBody Estudante estudante) {
        return new ResponseEntity<>(estudanteService.insert(estudante), HttpStatus.CREATED);
    }

    @PutMapping("/updateestudante/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Estudante newEstudante){
        Estudante estudante = estudanteService.update(id, newEstudante);
        return new ResponseEntity<>(estudante, HttpStatus.OK);
    }

    @DeleteMapping("/deleteestudante/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        estudanteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}