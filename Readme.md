# Aplicação de cadastro de clientes e endereços (Backend)
Descrição de javafx para cadastro de cliente
## Tecnologia
* Java 17
* Java Fx
* PostgresSQL
* DBeaver

## Instalação
Para iniciar a aplicação precisa ter o seguinte software instalado:
* IntelliJ

## Aplicação

Esse é o backend do projeto para cadastrar clientes e seus respectivos endereços, abaixo tem uma pequena parte da aplicação:
```Java
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
```
Também é possivel editar e excluir registros da parte do cliente.