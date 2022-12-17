package br.edu.ifpb.pweb2.controledecmaster.repository;

import br.edu.ifpb.pweb2.controledecmaster.model.Estudante;
import br.edu.ifpb.pweb2.controledecmaster.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

//    @Query(value = "SELECT  FROM ESTUDANTE_INSTITUICOES ORDER BY INSTITUICAO_ID DESC LIMIT 1", nativeQuery = true)
//    Instituicao buscaInstituicaoAtual();
}
