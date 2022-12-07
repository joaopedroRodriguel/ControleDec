package br.edu.ifpb.pweb2.controledecmaster.controller;



import br.edu.ifpb.pweb2.controledecmaster.model.Estudante;
import br.edu.ifpb.pweb2.controledecmaster.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.transaction.Transactional;
import java.util.Optional;


@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    EstudanteRepository estudanteRepository;






}