package com.mycompany.terceirotrabalho;

public class Cliente{
    private static int contador = 0;
    private String nome;
    private Integer codigo;
    private Endereco endereco;
    private String telefone;
    
    public Cliente(String nome, Endereco endereco, String telefone){
        this.codigo = ++contador;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public Endereco getEndereco(){
        return endereco;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}
