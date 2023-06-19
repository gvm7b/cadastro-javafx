package br.com.senac.cadastrocliente.model;

public class Endereco {
    private int id;
    private  int codigoClienteEnd;
    private int cepEnd;
    private String bairroEnd;
    private String ruaEnd;
    private int numeroEnd;
    private String cidadeEnd;
    private String estadoEnd;

    public Endereco() {
    }

    public Endereco(int id, int codigoClienteEnd, int cepEnd, String bairroEnd, String ruaEnd, int numeroEnd, String cidadeEnd, String estadoEnd) {
        this.id = id;
        this.codigoClienteEnd = codigoClienteEnd;
        this.cepEnd = cepEnd;
        this.bairroEnd = bairroEnd;
        this.ruaEnd = ruaEnd;
        this.numeroEnd = numeroEnd;
        this.cidadeEnd = cidadeEnd;
        this.estadoEnd = estadoEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoClienteEnd() {
        return codigoClienteEnd;
    }

    public void setCodigoClienteEnd(int codigoClienteEnd) {
        this.codigoClienteEnd = codigoClienteEnd;
    }

    public int getCepEnd() {
        return cepEnd;
    }

    public void setCepEnd(int cepEnd) {
        this.cepEnd = cepEnd;
    }

    public String getBairroEnd() {
        return bairroEnd;
    }

    public void setBairroEnd(String bairroEnd) {
        this.bairroEnd = bairroEnd;
    }

    public String getRuaEnd() {
        return ruaEnd;
    }

    public void setRuaEnd(String ruaEnd) {
        this.ruaEnd = ruaEnd;
    }

    public int getNumeroEnd() {
        return numeroEnd;
    }

    public void setNumeroEnd(int numeroEnd) {
        this.numeroEnd = numeroEnd;
    }

    public String getCidadeEnd() {
        return cidadeEnd;
    }

    public void setCidadeEnd(String cidadeEnd) {
        this.cidadeEnd = cidadeEnd;
    }

    public String getEstadoEnd() {
        return estadoEnd;
    }

    public void setEstadoEnd(String estadoEnd) {
        this.estadoEnd = estadoEnd;
    }
}