package br.edu.ifpb.pweb2.controledecmaster.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Campo obrigatório!")
    private String nome;

    @NotBlank(message="Campo obrigatório!")
    private String matricula;


    //Relacioanamentos

    @OneToMany
    private List<Declaracao> declaracaoAtual;

    @OneToMany
    private List<Instituicao> instituicaoAtual;

}
