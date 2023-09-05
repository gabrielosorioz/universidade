package com.unip.universidade.model;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno {

    //Atributos da classe
    private int matricula; 
    private String nome;
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date dataNascimento;
    
    //Construtor da classe
    public Aluno (int matricula, String nome, Date dataNascimento){
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;

    }
    public Aluno(){

    }

    
    
}