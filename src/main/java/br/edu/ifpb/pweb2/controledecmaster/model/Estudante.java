package br.edu.ifpb.pweb2.controledecmaster.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank(message="Campo obrigatório")
    @Size(min=6, message = "Senha deve ter no mínimo 6 caracteres")
    private String senha;


    //Relacioanamentos

    @OneToOne
    private Declaracao declaracaoAtual;

    @OneToOne
    private Instituicao instituicaoAtual;

}
