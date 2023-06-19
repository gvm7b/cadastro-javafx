package br.com.senac.cadastrocliente.controller;

import br.com.senac.cadastrocliente.model.Cliente;
import br.com.senac.cadastrocliente.model.Endereco;
import br.com.senac.cadastrocliente.services.ClienteService;
import br.com.senac.cadastrocliente.services.EnderecoService;
import ch.qos.logback.core.net.server.Client;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;


@Component
@FxmlView("/main-cadastro.fxml")
public class ClienteController {

    @FXML
    private TextField documentoCliente;

    @FXML
    private TextField nomeCliente;

    @FXML
    private TextField rgCliente;

    @FXML
    private TextField emailCliente;

    @FXML
    private TextField telefoneCliente;

    @FXML
    private TableView<Cliente> tabelaClientes;

    @FXML
    private TableView<Endereco> tabelaEnderecos;

    @FXML
    private TableColumn<Cliente, Integer> colunaDocumentoClientes;

    @FXML
    private TableColumn<Cliente, String> colunaNomeClientes;

    @FXML
    private TableColumn<Cliente, Integer> colunaRgClientes;

    @FXML
    private TableColumn<Cliente, String> colunaEmailClientes;

    @FXML
    private TableColumn<Cliente, Integer> colunaTelefoneClientes;


    @FXML
    private TextField codigoClienteEnd;

    @FXML
    private TextField cepEnd;

    @FXML
    private TextField bairroEnd;

    @FXML
    private TextField ruaEnd;

    @FXML
    private TextField numeroEnd;

    @FXML
    private TextField cidadeEnd;

    @FXML
    private TextField estadoEnd;

    @FXML
    private TableColumn<Endereco, Integer> colunaCodClienteEnd;

    @FXML
    private TableColumn<Endereco, Integer> colunaCepEnd;

    @FXML
    private TableColumn<Endereco, String> colunaBairroEnd;

    @FXML
    private TableColumn<Endereco, String> colunaRuaEnd;

    @FXML
    private TableColumn<Endereco, Integer> colunaNumeroEnd;

    @FXML
    private TableColumn<Endereco, String> colunaCidadeEnd;

    @FXML
    private TableColumn<Endereco, String> colunaEstadoEnd;


    private int index = -1;


    @FXML
    public void initialize() {
        colunaDocumentoClientes.setCellValueFactory(new PropertyValueFactory<>("documentoCliente"));
        colunaNomeClientes.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));
        colunaRgClientes.setCellValueFactory(new PropertyValueFactory<>("rgCliente"));
        colunaEmailClientes.setCellValueFactory(new PropertyValueFactory<>("emailCliente"));
        colunaTelefoneClientes.setCellValueFactory(new PropertyValueFactory<>("telefoneCliente"));

        colunaCodClienteEnd.setCellValueFactory(new PropertyValueFactory<>("codigoClienteEnd"));
        colunaCepEnd.setCellValueFactory(new PropertyValueFactory<>("cepEnd"));
        colunaBairroEnd.setCellValueFactory(new PropertyValueFactory<>("bairroEnd"));
        colunaRuaEnd.setCellValueFactory(new PropertyValueFactory<>("ruaEnd"));
        colunaNumeroEnd.setCellValueFactory(new PropertyValueFactory<>("numeroEnd"));
        colunaCidadeEnd.setCellValueFactory(new PropertyValueFactory<>("cidadeEnd"));
        colunaEstadoEnd.setCellValueFactory(new PropertyValueFactory<>("estadoEnd"));

        this.carregarListaClientes();

        tabelaClientes.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if(evt.getClickCount() == 2){
                    Cliente cli = tabelaClientes.getSelectionModel().getSelectedItem();
                    documentoCliente.setText(String.valueOf(cli.getDocumentoCliente()));
                    nomeCliente.setText(cli.getNomeCliente());
                    rgCliente.setText(String.valueOf(cli.getRgCliente()));
                    emailCliente.setText(cli.getEmailCliente());
                    telefoneCliente.setText(String.valueOf(cli.getTelefoneCliente()));

                    index = cli.getId();

                }
            }
        });


    }

    public void executarSalvarCliente() {



        Cliente cli = new Cliente();
        cli.setDocumentoCliente(Integer.parseInt(documentoCliente.getText()));
        cli.setNomeCliente(nomeCliente.getText());
        cli.setRgCliente(Integer.parseInt(rgCliente.getText()));
        cli.setEmailCliente(emailCliente.getText());
        cli.setTelefoneCliente(Integer.parseInt(telefoneCliente.getText()));



        if(index > -1){
            ClienteService.atualizarCliente(index, cli);
            index = -1;
        }else {
            if(ClienteService.buscarClienteByDocumento(cli.getDocumentoCliente())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alerta");
                alert.setHeaderText("Documento: " + documentoCliente.getText() + " já existe na base!");
                alert.show();
            }else {
                ClienteService.inserirCliente(cli);
            }
        }
        this.carregarListaClientes();

        this.limparCampos();
    }

    public void executarExcluirCliente(){
        if(index > -1){

            ClienteService.deletarClientes(index);
            this.carregarListaClientes();
            index = -1;
            this.limparCampos();
        }
    }

    public void limparCampos(){
        documentoCliente.setText("");
        nomeCliente.setText("");
        rgCliente.setText("");
        emailCliente.setText("");
        telefoneCliente.setText("");
    }

    public void carregarListaClientes(){

        tabelaClientes.getItems().remove(0, tabelaClientes.getItems().size());

        List<Cliente> cliList = ClienteService.carregarClientes();

        tabelaClientes.getItems().addAll(cliList);
    }

    public void executarSalvarEnd(){


        Endereco end = new Endereco();

        end.setCodigoClienteEnd(Integer.parseInt(codigoClienteEnd.getText()));
        end.setCepEnd(Integer.parseInt(cepEnd.getText()));
        end.setBairroEnd(bairroEnd.getText());
        end.setRuaEnd(ruaEnd.getText());
        end.setNumeroEnd(Integer.parseInt(numeroEnd.getText()));
        end.setCidadeEnd(cidadeEnd.getText());
        end.setEstadoEnd(estadoEnd.getText());


        if(index > -1){
            EnderecoService.atualizarEndereco(index, end);
            index = -1;
        }

        this.carregarListaEnderecos();

        this.limparCampos();
    }



    public void carregarListaEnderecos(){

        tabelaEnderecos.getItems().remove(0, tabelaEnderecos.getItems().size());

        List<Endereco> endList = EnderecoService.carregarEnderecos();

        tabelaEnderecos.getItems().addAll(endList);

    }

    public void limparCamposEnd(){
        cepEnd.setText("");
        bairroEnd.setText("");
        ruaEnd.setText("");
        numeroEnd.setText("");
        cidadeEnd.setText("");
        estadoEnd.setText("");
    }

    public void executarExcluirEnd(){
        if(index > -1){

            EnderecoService.deletarEndereco(index);
            this.carregarListaEnderecos();
            index = -1;
            this.limparCamposEnd();
        }

    }


}
