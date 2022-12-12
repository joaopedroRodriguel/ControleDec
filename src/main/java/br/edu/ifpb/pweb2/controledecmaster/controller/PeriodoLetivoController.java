package br.edu.ifpb.pweb2.controledecmaster.controller;


import br.edu.ifpb.pweb2.controledecmaster.model.PeriodoLetivo;
import br.edu.ifpb.pweb2.controledecmaster.repository.DeclaracaoRepository;
import br.edu.ifpb.pweb2.controledecmaster.repository.InstituicaoRepository;
import br.edu.ifpb.pweb2.controledecmaster.repository.PeriodoLetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;

@RestController
@RequestMapping("periodosletivos")
public class PeriodoLetivoController {

    @Autowired
    PeriodoLetivoRepository periodoLetivoRepository;

    @Autowired
    InstituicaoRepository instituicaoRepository;

    @Autowired
    DeclaracaoRepository declaracaoRepository;

    @RequestMapping()
    public ModelAndView getCadastroPeriodoLetivo(ModelAndView mv) {
        mv.addObject("periodosletivos", new PeriodoLetivo());
        mv.setViewName("periodosletivos/periodosletivos");
        return mv;
    }

    @RequestMapping()
    public ModelAndView listAll(ModelAndView mv) {
        mv.setViewName("periodosletivos/list");
        mv.addObject("periodosletivos", periodoLetivoRepository.findAll());
        return mv;
    }

    @RequestMapping()
    @Transactional
    public ModelAndView save(PeriodoLetivo periodoLetivo, ModelAndView mv, RedirectAttributes attr) {
        periodoLetivoRepository.save(periodoLetivo);
        mv.setViewName("redirect:periodosletivos");
        attr.addFlashAttribute("mensagem", periodoLetivo.getPeriodo() + " cadastrado com sucesso!");
        attr.addFlashAttribute("periodosletivos", periodoLetivo);
        return mv;
    }

    @RequestMapping()
    public ModelAndView deleteById(@PathVariable(value = "id") Long id, ModelAndView mv, RedirectAttributes attr) {
        periodoLetivoRepository.deleteById(id);
        attr.addFlashAttribute("mensagem", "Periodo-Letivo removido com sucesso!");
        mv.setViewName("redirect:/periodosletivos");
        return mv;
    }
}
