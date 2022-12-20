package br.edu.ifpb.pweb2.controledecmaster.service;

import br.edu.ifpb.pweb2.controledecmaster.model.Estudante;
import br.edu.ifpb.pweb2.controledecmaster.model.Instituicao;
import br.edu.ifpb.pweb2.controledecmaster.model.PeriodoLetivo;
import br.edu.ifpb.pweb2.controledecmaster.repository.InstituicaoRepository;
import br.edu.ifpb.pweb2.controledecmaster.repository.PeriodoLetivoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstituicaoService {

    @Autowired
    InstituicaoRepository instituicaoRepository;

    PeriodoLetivoRepository periodoLetivoRepository;

    public List<Instituicao> list(){
        return instituicaoRepository.findAll();
    }

    public Optional<Instituicao> search(Long id){
        return instituicaoRepository.findById(id);
    }

//    public Optional<Instituicao> searchatual(Long id){
//        Optional<Instituicao> instituicao = instituicaoRepository.findById(id);
//        List<PeriodoLetivo> periodoLetivos = instituicao.get().getPeriodoLetivos();
//        instituicao.get().setPeriodoAtual((periodoLetivos.get(periodoLetivos.size() -1).getPeriodo()));
//        return instituicao;
//    }

    public Instituicao insert(Instituicao instituicao){
        return instituicaoRepository.save(instituicao);
    }

    public Instituicao update(Long id, Instituicao newInstituicao){
        Optional<Instituicao> oldInstituicao = instituicaoRepository.findById(id);
        Instituicao instituicao = oldInstituicao.get();
        BeanUtils.copyProperties(newInstituicao, instituicao, "id");
        return instituicaoRepository.save(instituicao);
    }

    public void delete(Long id) {
        instituicaoRepository.deleteById(id);
    }

}
