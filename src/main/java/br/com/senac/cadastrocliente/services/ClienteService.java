package br.com.senac.cadastrocliente.services;

import br.com.senac.cadastrocliente.db.ConexaoDataBase;
import br.com.senac.cadastrocliente.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private static ConexaoDataBase conexao = new ConexaoDataBase();

    public static List<Cliente> carregarClientes(){
        List<Cliente> out = new ArrayList<>();

        try {
            Connection conn = conexao.getConexao();

            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("Select * from public.clientes;");

            while (rs.next()){
                Cliente cli = new Cliente(rs.getInt("id"), rs.getInt("documento"), rs.getString("nome"), rs.getInt("rg"), rs.getString("email"), rs.getInt("telefone"));

                out.add(cli);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;

    }

    public static void inserirCliente(Cliente cliente){

        try {
            Connection conn = conexao.getConexao();

            String sqlInsert = "Insert into public.clientes (documento, nome, rg, email, telefone) values( ?, ?, ?, ?, ?)";

            PreparedStatement pre = conn.prepareStatement(sqlInsert);
            pre.setInt(1, cliente.getDocumentoCliente());
            pre.setString(2, cliente.getNomeCliente());
            pre.setInt(3, cliente.getRgCliente());
            pre.setString(4, cliente.getEmailCliente());
            pre.setInt(5, cliente.getTelefoneCliente());

            pre.execute();

            pre.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Boolean deletarClientes(int idCliente) {

        try {
            Connection conn = conexao.getConexao();

            String deleteSql = "delete from public.clientes where id = ?;";

            PreparedStatement ps = conn.prepareStatement(deleteSql);
            ps.setInt(1, idCliente);

            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean atualizarCliente(int idCliente, Cliente cli){
        try {
            Connection conn = conexao.getConexao();

            String updateSql = "update clientes set documento = ?, set nome = ?, rg = ?, email = ?, telefone = ?, where id = ?";
            PreparedStatement ps = conn.prepareStatement(updateSql);
            ps.setInt(1, cli.getDocumentoCliente());
            ps.setString(2, cli.getNomeCliente());
            ps.setInt(3, cli.getRgCliente());
            ps.setString(4, cli.getEmailCliente());
            ps.setInt(5, cli.getTelefoneCliente());
            ps.setInt(6, idCliente);

            return ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Boolean buscarClienteByDocumento(Integer documentoCliente){
        try {
            Connection conn = conexao.getConexao();

            String selectSql = "select id from clientes where documento = '" + documentoCliente +"'";

            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(selectSql);

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
