package br.com.senac.cadastrocliente.model;

public class Cliente {
    private int id;
    private int documentoCliente;
    private String nomeCliente;
    private int rgCliente;
    private String emailCliente;
    private int telefoneCliente;

    public Cliente() {

    }

    public Cliente(int id, int documentoCliente, String nomeCliente, int rgCliente, String emailCliente, int telefoneCliente) {
        this.id = id;
        this.documentoCliente = documentoCliente;
        this.nomeCliente = nomeCliente;
        this.rgCliente = rgCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(int documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getRgCliente() {
        return rgCliente;
    }

    public void setRgCliente(int rgCliente) {
        this.rgCliente = rgCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public int getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(int telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
}
