package br.edu.ifpb.pweb2.controledecmaster.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Declaracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dataRecebimento;

    private String observacao;

    private String nome_Estudante;

    private String matricula;

    @ManyToMany
    private List<PeriodoLetivo> periodoLetivo;

    /*@ManyToMany
    private List<Estudante> estudantes;*/
}
