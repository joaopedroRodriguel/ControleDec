package br.edu.ifpb.pweb2.controledecmaster.service;

import br.edu.ifpb.pweb2.controledecmaster.model.Declaracao;
import br.edu.ifpb.pweb2.controledecmaster.model.Estudante;
import br.edu.ifpb.pweb2.controledecmaster.model.PeriodoLetivo;
import br.edu.ifpb.pweb2.controledecmaster.repository.DeclaracaoRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DeclaracaoService {

    @Autowired
    DeclaracaoRepository declaracaoRepository;

    @Autowired
    EstudanteService estudanteService;

    @Autowired
    PeriodoLetivoService periodoLetivoService;

    public Declaracao insert(Declaracao declaracao){
        return declaracaoRepository.save(declaracao);
    }

    public List<Declaracao> listar() {
        return declaracaoRepository.findAll();
    }


    public Declaracao buscarDeclaracaoPorEstudante(Long idEstudante) {
        Declaracao declaracao = new Declaracao();
        Optional<Estudante> estudante = estudanteService.search(idEstudante);
        PeriodoLetivo periodoLetivo = periodoLetivoService.periodoAtual();
        declaracao.setId(1L);
        declaracao.setNome_Estudante(estudante.get().getNome());
        declaracao.setMatricula(estudante.get().getMatricula());
        declaracao.setPeriodoLetivo((List<PeriodoLetivo>) periodoLetivo);
        declaracao.setObservacao("Test");
        declaracao.setDataRecebimento(LocalDateTime.now());
        return declaracao;
    }
    public List<Declaracao> declaracaosVencidas() {
        return declaracaoRepository.buscarDeclaracaoVencidas();
    }

}
