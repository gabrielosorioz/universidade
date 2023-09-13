package com.unip.universidade.controller;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
=======

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
>>>>>>> 871237a3f51f07d8f1ffb9a0153c63754057e353
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
<<<<<<< HEAD
import com.unip.universidade.model.Aluno;
import com.unip.universidade.model.bd.AlunoDAO;
=======

import com.unip.universidade.model.Aluno;
import com.unip.universidade.model.AlunoService;
>>>>>>> 871237a3f51f07d8f1ffb9a0153c63754057e353



@Controller
public class AlunoController {

<<<<<<< HEAD
   
    private AlunoDAO alunoDAO;
    
    @Autowired
    public AlunoController(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    @RequestMapping("/listaAlunos")
    public ModelAndView listarAlunos(@ModelAttribute("aluno") Aluno aluno){

        ModelAndView modelAndView = new ModelAndView("alunos");
        modelAndView.addObject("listaDeAlunos",alunoDAO.listarAlunos());
        modelAndView.addObject("aluno", new Aluno());
        return modelAndView;
    }
    

    
    @RequestMapping("/selecionaAluno")
    public ModelAndView selecionarAlunos(@RequestParam("id") int matricula) {
        System.out.println("buscando o aluno " + matricula);
        Aluno aluno = alunoDAO.pesquisarAluno(matricula);
        ModelAndView modelAndView = new ModelAndView("alunos");
        modelAndView.addObject("listaDeAlunos", alunoDAO.listarAlunos());
        modelAndView.addObject("aluno", aluno);
        return modelAndView;
    }
    @PostMapping("/salvaAluno")
    public String salvarAluno(@ModelAttribute("aluno") Aluno aluno){

        Aluno alunoTemp = alunoDAO.pesquisarAluno(aluno.getMatricula());
        if (alunoTemp != null) {
            //int idAlunoTemp =
            //alunoService.listarAlunos().indexOf(alunoTemp);
            //alunoService.listarAlunos().set(idAlunoTemp, aluno);
            alunoDAO.alterarAluno(aluno);
            } else
            //alunoService.listarAlunos().add(aluno);
            alunoDAO.incluirAluno(aluno);
            return "redirect:/listaAlunos";
    }

    @RequestMapping("removeAluno")
    public String removeAluno(@RequestParam ("id") int matricula){
        alunoDAO.excluirAluno(matricula);
        return "redirect:/listaAlunos";
    }


=======
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
>>>>>>> 871237a3f51f07d8f1ffb9a0153c63754057e353
}




