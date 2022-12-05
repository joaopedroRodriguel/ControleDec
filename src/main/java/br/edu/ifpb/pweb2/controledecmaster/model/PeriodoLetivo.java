package br.edu.ifpb.pweb2.controledecmaster.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data

public class PeriodoLetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo Obrigatório")
    private int ano;

    @NotBlank(message = "Campo Obrigatório")
    private  int periodo;

    @NotBlank(message = "Campo Obrigatório")
    private Date inicio;

    private  Date fim;


    //Relacionamentos

    @OneToMany
    private List<Declaracao> declaracoes;

    @ManyToOne
    private Instituicao instituicao;

}
