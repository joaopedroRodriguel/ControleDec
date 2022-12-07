package br.edu.ifpb.pweb2.controledecmaster.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data

public class Declaracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataRecebimento;

    private String observacao;


    //Relacionamentos

    @OneToOne
    private Estudante estudante;

    @OneToOne
    private PeriodoLetivo periodoLetivo;


}
