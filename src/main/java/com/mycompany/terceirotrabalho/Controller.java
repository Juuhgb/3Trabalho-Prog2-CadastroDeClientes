package com.mycompany.terceirotrabalho;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {
    @FXML
    private TextField cepField;
 
    @FXML
    private TextField estadoField;
    
    @FXML
    private TextField nomeField;
    
    @FXML
    private TextField numeroField;
    
    @FXML
    private TextField ruaField;
    
    @FXML
    private TextField cidadeField;
    
    @FXML
    private TextField telefoneField;
    
    private Buscador buscador = new Buscador();
    
    private List<Cliente> clientes = new ArrayList<>();

    @FXML
    public void cadastrarCliente() {
        try {
            String nome = nomeField.getText();
            String cep = cepField.getText();
            String telefone = telefoneField.getText();
            String rua = ruaField.getText();
            String cidade = cidadeField.getText();
            String numero = numeroField.getText();
            String estado = estadoField.getText();
            
            if(nome.isEmpty() || cep.isEmpty() || telefone.isEmpty() || cidade.isEmpty() || numero.isEmpty() || estado.isEmpty()){
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Todos os campos devem ser preenchidos!");
                alert.show(); 
                return;
            }
            
            Endereco novoEndereco = new Endereco(cep, rua, numero, cidade, estado);
            Cliente novoCliente = new Cliente(nome, novoEndereco, telefone);
            
            clientes.add(novoCliente);
             
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Cliente cadastrado com sucesso!");
            alert.show();
            
            limpar();
            
        }catch(Exception e){
            System.out.println("erro ao cadastrar cliente" + e.getMessage());
        }
        if(clientes.isEmpty()){
            System.out.println("Nenhum cliente cadastrado");
        }
        else{
            System.out.println("Clientes cadastrados:");
            for(Cliente c: clientes){
                System.out.println(c.getNome());
            }
        }
    }
              
    @FXML
    public void limpar(){
        nomeField.clear();
        cidadeField.clear();
        telefoneField.clear();
        cepField.clear();
        estadoField.clear();
        numeroField.clear();
        ruaField.clear();
    }
    
    @FXML
    public void buscarEndereco(){
        String cep = cepField.getText();
        
        try {
            Endereco endereco = buscador.buscar(cep);
            if(endereco != null){
                cidadeField.setText(endereco.getCidade());
                ruaField.setText(endereco.getRua());
                estadoField.setText(endereco.getEstado());
            }
            
        }catch(IllegalArgumentException e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("CEP não reconhecido");
            alert.show();       
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    

