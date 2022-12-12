package br.edu.ifpb.pweb2.controledecmaster.controller;


import br.edu.ifpb.pweb2.controledecmaster.model.Instituicao;
import br.edu.ifpb.pweb2.controledecmaster.repository.EstudanteRepository;
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
@RequestMapping("instituicoes")
public class InstituicaoController {

    @Autowired
    InstituicaoRepository instituicaoRepository;

    @Autowired
    EstudanteRepository estudanteRepository;

    @Autowired
    PeriodoLetivoRepository periodoLetivoRepository;

    @RequestMapping()
    public ModelAndView getCadastroInstituicoes(ModelAndView mv) {
        mv.addObject("instituicao", new Instituicao());
        mv.setViewName("instituicoes/instituicoes");
        return mv;
    }

    @RequestMapping()
    public ModelAndView listAll(ModelAndView mv) {
        mv.setViewName("instituicoes/list");
        mv.addObject("instituicoes", instituicaoRepository.findAll());
        return mv;
    }

    @RequestMapping()
    @Transactional
    public ModelAndView save(Instituicao instituicao, ModelAndView mv, RedirectAttributes attr) {
        instituicaoRepository.save(instituicao);
        mv.setViewName("redirect:instituicoes");
        attr.addFlashAttribute("mensagem", instituicao.getNome() + " cadastrado com sucesso!");
        attr.addFlashAttribute("instituicao", instituicao);
        return mv;
    }

    @RequestMapping()
    public ModelAndView deleteById(@PathVariable(value = "id") Long id, ModelAndView mv, RedirectAttributes attr) {
        instituicaoRepository.deleteById(id);
        attr.addFlashAttribute("mensagem", "Instituicao removida com sucesso!");
        mv.setViewName("redirect:/instituicoes");
        return mv;
    }

}
