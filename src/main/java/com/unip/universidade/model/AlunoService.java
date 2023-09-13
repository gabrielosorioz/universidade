package com.unip.universidade.model; // Declaração do pacote onde a classe AlunoService está localizada

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.stereotype.Component; // Importação de classes necessárias do Spring Framework

@Component // Anotação que indica que esta classe é um componente gerenciado pelo Spring

public class AlunoService { // Declaração da classe AlunoService

    private List<Aluno> lista; // Declaração de uma lista de objetos do tipo Aluno
    
    public AlunoService() { // Construtor da classe AlunoService
        lista = new ArrayList<Aluno>(); // Inicializa a lista como uma ArrayList vazia

        // Adiciona três objetos Aluno à lista, simulando dados de alunos
        lista.add(new Aluno(1, "Maria Silva", (new GregorianCalendar(2000, 10, 12).getTime())));
        lista.add(new Aluno(2, "Jose Pereira", (new GregorianCalendar(1999, 07, 01).getTime())));
        lista.add(new Aluno(3, "Pedro Souza", (new GregorianCalendar(2005, 03, 15).getTime())));
    }

    // Método que retorna a lista de alunos
    public List<Aluno> listarAlunos() {
        return lista;
    }

    // Método que adiciona um aluno à lista
    public void adicionarAluno(Aluno aluno) {
        lista.add(aluno);
    }

    // Método que busca um aluno na lista com base na matrícula
    public Aluno findAluno(int matricula){
        for (Aluno aluno : lista ){
            if (aluno.getMatricula() == matricula ){
                return aluno;
            }
        }
        return null; // Retorna null caso o aluno com a matrícula não seja encontrado
    }
}