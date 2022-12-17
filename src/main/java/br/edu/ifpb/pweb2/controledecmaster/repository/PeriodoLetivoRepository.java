package br.edu.ifpb.pweb2.controledecmaster.repository;

import br.edu.ifpb.pweb2.controledecmaster.model.PeriodoLetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoLetivoRepository extends JpaRepository<PeriodoLetivo, Long> {

    @Query(value = "SELECT * FROM PERIODO_LETIVO ORDER BY ID DESC LIMIT 1", nativeQuery = true)
    PeriodoLetivo buscarPeriodoAtual();
}
