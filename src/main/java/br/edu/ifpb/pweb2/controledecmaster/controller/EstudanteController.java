package br.edu.ifpb.pweb2.controledecmaster.controller;

import br.edu.ifpb.pweb2.controledecmaster.model.Estudante;
import br.edu.ifpb.pweb2.controledecmaster.repository.DeclaracaoRepository;
import br.edu.ifpb.pweb2.controledecmaster.repository.EstudanteRepository;
import br.edu.ifpb.pweb2.controledecmaster.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    EstudanteRepository estudanteRepository;

    @Autowired
    DeclaracaoRepository declaracaoRepository;

    @Autowired
    InstituicaoRepository instituicaoRepository;


    @RequestMapping()
    public ModelAndView getCadastroEstudantes(ModelAndView mv) {
        mv.addObject("estudante", new Estudante());
        mv.setViewName("estudantes/estudantes");
        return mv;
    }

    @RequestMapping()
    public ModelAndView listAll(ModelAndView mv) {
        mv.setViewName("estudantes/list");
        mv.addObject("estudantes", estudanteRepository.findAll());
        return mv;
    }

    @RequestMapping()
    @Transactional
    public ModelAndView save(Estudante estudante, ModelAndView mv, RedirectAttributes attr) {
        estudanteRepository.save(estudante);
        mv.setViewName("redirect:estudantes");
        attr.addFlashAttribute("mensagem", estudante.getNome() + " cadastrado com sucesso!");
        attr.addFlashAttribute("estudante", estudante);
        return mv;
    }

    @RequestMapping()
    public ModelAndView deleteById(@PathVariable(value = "id") Long id, ModelAndView mav, RedirectAttributes attr) {
        estudanteRepository.deleteById(id);
        attr.addFlashAttribute("mensagem", "Estudante removido com sucesso!");
        mav.setViewName("redirect:/estudantes");
        return mav;
    }

}