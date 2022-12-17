package br.edu.ifpb.pweb2.controledecmaster.controller;



import br.edu.ifpb.pweb2.controledecmaster.model.PeriodoLetivo;
import br.edu.ifpb.pweb2.controledecmaster.service.PeriodoLetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/periodoletivo")
public class PeriodoLetivoController {

    @Autowired
    PeriodoLetivoService periodoLetivoService;

    @GetMapping("/listperiodosletivos")
    public ResponseEntity<?> list(){
        List<PeriodoLetivo> periodoLetivos = periodoLetivoService.list();
        return new ResponseEntity<>(periodoLetivos, HttpStatus.OK);
    }

    @GetMapping("/searchperiodoletivo/{id}")
    public ResponseEntity<?> search(Long id) {
        Optional<PeriodoLetivo> periodoLetivo = periodoLetivoService.search(id);
        return new ResponseEntity<>(periodoLetivo, HttpStatus.OK);
    }

    @PostMapping("/insertperiodoletivo")
    public ResponseEntity<?> insert(@RequestBody PeriodoLetivo periodoLetivo) {
        return new ResponseEntity<>(periodoLetivoService.insert(periodoLetivo), HttpStatus.CREATED);
    }

    @PutMapping("/updateperiodoletivo/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PeriodoLetivo newPeriodoLetivo){
        PeriodoLetivo periodoLetivo = periodoLetivoService.update(id, newPeriodoLetivo);
        return new ResponseEntity<>(periodoLetivo, HttpStatus.OK);
    }

    @DeleteMapping("/deleteperiodoletivo/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        periodoLetivoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/periodoAtual")
    public ResponseEntity<?> periodoLetivo() {
        PeriodoLetivo periodoLetivo = periodoLetivoService.periodoAtual();
        return new ResponseEntity<>(periodoLetivo, HttpStatus.OK);
    }
}
