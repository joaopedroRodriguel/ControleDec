package br.edu.ifpb.pweb2.controledecmaster.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data

public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo Obrigatório")
    private String nome;

    @NotBlank(message = "Campo Obrigatório")
    private String sigla;

    @NotBlank(message = "Campo Obrigatório")
    private String fone;

/*    @ManyToOne
    private PeriodoLetivo periodoAtual;*/

    @ManyToMany
    private List<PeriodoLetivo> periodoLetivos;

    //private String periodoAtual;

}
