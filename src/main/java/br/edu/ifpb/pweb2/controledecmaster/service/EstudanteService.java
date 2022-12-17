package br.edu.ifpb.pweb2.controledecmaster.service;

import br.edu.ifpb.pweb2.controledecmaster.model.Estudante;
import br.edu.ifpb.pweb2.controledecmaster.model.Instituicao;
import br.edu.ifpb.pweb2.controledecmaster.repository.EstudanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    EstudanteRepository estudanteRepository;

    public List<Estudante> list(){
        return estudanteRepository.findAll();
    }

    public Optional<Estudante> search(Long id){
        Optional<Estudante> estudante = estudanteRepository.findById(id);
        List<Instituicao> instituicaos = estudante.get().getInstituicoes();
        estudante.get().setInstituicaoAtual(instituicaos.get(instituicaos.size() -1).getNome());
        return estudante;
    }

    public Estudante insert(Estudante estudante){
        return estudanteRepository.save(estudante);
    }

    public Estudante update(Long id, Estudante newEstudante){
        Optional<Estudante> oldEstudante = estudanteRepository.findById(id);
        Estudante estudante = oldEstudante.get();
        BeanUtils.copyProperties(newEstudante, estudante, "id");
        return estudanteRepository.save(estudante);
    }

    public void delete(Long id) {
        estudanteRepository.deleteById(id);
    }


}
