package br.edu.ifpb.pweb2.controledecmaster.service;

import br.edu.ifpb.pweb2.controledecmaster.model.PeriodoLetivo;
import br.edu.ifpb.pweb2.controledecmaster.repository.PeriodoLetivoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodoLetivoService {

    @Autowired
    PeriodoLetivoRepository periodoLetivoRepository;

    public List<PeriodoLetivo> list(){
        return periodoLetivoRepository.findAll();
    }

    public Optional<PeriodoLetivo> search(Long id){
        return periodoLetivoRepository.findById(id);
    }

    public PeriodoLetivo insert(PeriodoLetivo periodoLetivo){
        return periodoLetivoRepository.save(periodoLetivo);
    }

    public PeriodoLetivo update(Long id, PeriodoLetivo newPeriodoLetivo){
        Optional<PeriodoLetivo> oldPeriodoLetivo = periodoLetivoRepository.findById(id);
        PeriodoLetivo periodoLetivo = oldPeriodoLetivo.get();
        BeanUtils.copyProperties(newPeriodoLetivo, periodoLetivo, "id");
        return periodoLetivoRepository.save(periodoLetivo);
    }

    public void delete(Long id) {
        periodoLetivoRepository.deleteById(id);
    }

    public PeriodoLetivo periodoAtual() {
        PeriodoLetivo periodoLetivo = periodoLetivoRepository.buscarPeriodoAtual();
        return periodoLetivo;
    }
}
