package br.edu.ifpb.pweb2.controledecmaster.model;

import lombok.Data;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
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
    private LocalDate inicio;

    private LocalDate fim;

    //@OneToMany
    //private List<Declaracao> declaracoes;


}
