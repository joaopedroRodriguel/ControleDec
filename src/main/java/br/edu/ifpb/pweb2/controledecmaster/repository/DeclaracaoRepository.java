package br.edu.ifpb.pweb2.controledecmaster.repository;

import br.edu.ifpb.pweb2.controledecmaster.model.Declaracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeclaracaoRepository extends JpaRepository<Declaracao, Long> {


    @Query(value = "SELECT * FROM DECLARACAO DEC JOIN DECLARACAO_PERIODO_LETIVO DPL ON DEC.ID = DPL.DECLARACAO_ID " +
            "JOIN PERIODO_LETIVO PL ON DPL.PERIODO_LETIVO_ID = PL.ID WHERE CURRENT_DATE > PL.FIM", nativeQuery = true)
    List<Declaracao> buscarDeclaracaoVencidas();

}

