package com.unip.universidade.model;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
<<<<<<< HEAD

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricula;
    
    private String nome;

    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date dataNascimento;

    public Aluno(String nome, Date dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
=======
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

    
>>>>>>> 871237a3f51f07d8f1ffb9a0153c63754057e353
    
}