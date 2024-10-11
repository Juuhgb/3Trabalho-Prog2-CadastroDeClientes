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
    public void handleCadastrarCliente() {
        String nome = nomeField.getText();
        String cidade = cidadeField.getText();
        String telefone = telefoneField.getText();

        Endereco novoEndereco = new Endereco("","", "", "", "");
        Cliente novoCliente = new Cliente(nome, novoEndereco, telefone);

        clientes.add(novoCliente);
    }
    
    @FXML
    public void limpar(){
        nomeField.clear();
        cidadeField.clear();
        telefoneField.clear();
    }
    
    @FXML
    public void buscarEndereco(){
        String cep = cepField.getText();
        
        if(cep.isEmpty()){
            return;
        }
        
        try {
            Endereco endereco = buscador.buscar(cep);
            if(endereco != null){
                cidadeField.setText(endereco.getCidade());
                numeroField.setText(endereco.getNumero());
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
    
    

