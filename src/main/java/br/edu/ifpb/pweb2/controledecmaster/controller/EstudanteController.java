package br.edu.ifpb.pweb2.controledecmaster.controller;

import br.edu.ifpb.pweb2.controledecmaster.auxiliar.SenhaAuxiliar;
import br.edu.ifpb.pweb2.controledecmaster.model.Estudante;
import br.edu.ifpb.pweb2.controledecmaster.repository.EstudanteRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    EstudanteRepository estudanteRepository;

    @GetMapping("/listar")
    public String listar() {
        return "TESTE";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCadastroEstudantes(ModelAndView mv) {
        mv.addObject("estudante", new Estudante());
        mv.setViewName("estudantes/estudantes");
        return mv;
    }

    @RequestMapping(value = "/novoEstudante", method = RequestMethod.GET)
    public String getEstudanteForm() { return "estudanteForm"; }

    @PostMapping()
    public ModelAndView  cadastrarEstudante(@Valid Estudante estudante, BindingResult result, ModelAndView mv, RedirectAttributes attr) {
        if (result.hasErrors()) {
            mv.addObject("estudante", estudante);
            mv.setViewName("/estudantes/estudantes");
            return mv;
        }
        estudante.setSenha(SenhaAuxiliar.hashSenha(estudante.getSenha()));
        estudanteRepository.save(estudante);
        attr.addFlashAttribute("estudanteCadastrado", estudante);
        mv.setViewName("redirect:/estudantes/estudanteCadastroSucesso");
        return mv;
    }

    @RequestMapping("/{id}/delete")
    public ModelAndView deleteById(@PathVariable(value = "id") Long id, ModelAndView mv, RedirectAttributes attr) {
        estudanteRepository.deleteById(id);
        attr.addFlashAttribute("mensagem", "matricula removida com sucesso!");
        mv.setViewName("redirect:/estudantes");
        return mv;
    }

    @GetMapping(value = "/estudanteCadastroSucesso")
    public ModelAndView redirectSucesso(ModelAndView mv){
        mv.setViewName("estudante/estudanteCadastroSucesso");
        return mv;
    }

    @RequestMapping("/sair")
    public String sair(HttpSession session) {
        System.out.println("saindo");
        session.invalidate();
        return "redirect:/login";
    }
}
