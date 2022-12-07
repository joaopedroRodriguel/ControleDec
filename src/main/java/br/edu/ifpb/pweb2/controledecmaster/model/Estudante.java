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




    //Relacioanamentos

    /*@OneToOne
    private Declaracao declaracaoAtual;

    @OneToOne
    private Instituicao instituicaoAtual;*/

}
