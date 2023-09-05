package com.unip.universidade.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unip.universidade.model.Aluno;
import com.unip.universidade.model.AlunoService;



@Controller
public class AlunoController {

    private final AlunoService alunoService; // Injete o serviço aqui

    // Construtor para injetar o serviço
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // Mapeia a URL "/listaAlunos" para listar os alunos
    @RequestMapping("/listaAlunos")
    public ModelAndView listarAlunos() {
        ModelAndView modelAndView = new ModelAndView("alunos"); // Cria um objeto ModelAndView para renderizar a página "alunos.jsp"

        // Obtém a lista de alunos do serviço e adiciona ao ModelAndView
        List<Aluno> listaDeAlunos = alunoService.listarAlunos();
        modelAndView.addObject("listaDeAlunos", listaDeAlunos);

        // Cria um objeto Aluno vazio para ser usado em um formulário de adição
        modelAndView.addObject("aluno", new Aluno());

        return modelAndView;
    }

    // Mapeia a URL "/aluno" para adicionar um novo aluno
    @PostMapping("/aluno")
    public String adicionarAluno(@ModelAttribute Aluno aluno) {
        // Chama o serviço para adicionar o novo aluno
        alunoService.adicionarAluno(aluno);
        // Redireciona o usuário de volta para a página de listagem de alunos
        return "redirect:/listaAlunos";
    }

    // Mapeia a URL "/removeAluno" para remover um aluno com base na matrícula
    @RequestMapping("/removeAluno")
    public String removeAluno(@RequestParam("id") int matricula) {
        // Encontra o aluno pelo serviço e remove-o da lista de alunos
        Aluno alunoTemp = alunoService.findAluno(matricula);
        if (alunoTemp != null) {
            int idAlunoTemp = alunoService.listarAlunos().indexOf(alunoTemp);
            alunoService.listarAlunos().remove(idAlunoTemp);
        }

        // Redireciona o usuário de volta para a página de listagem de alunos
        return "redirect:/listaAlunos";
    }

    // Mapeia a URL "/selecionaAluno" para selecionar um aluno com base na matrícula
    @RequestMapping("/selecionaAluno")
    public ModelAndView selecionarAlunos(@RequestParam("id") int matricula) {
        // Encontra o aluno pelo serviço
        Aluno aluno = alunoService.findAluno(matricula);
        ModelAndView modelAndView = new ModelAndView("alunos"); // Cria um ModelAndView para renderizar a página "alunos.jsp"

        // Adiciona a lista de alunos e o aluno selecionado ao ModelAndView
        modelAndView.addObject("listaDeAlunos", alunoService.listarAlunos());
        modelAndView.addObject("aluno", aluno);

        return modelAndView;
    }
}




