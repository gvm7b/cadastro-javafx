package br.com.senac.cadastrocliente.services;

import br.com.senac.cadastrocliente.db.ConexaoDataBase;
import br.com.senac.cadastrocliente.model.Endereco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoService {
     private static ConexaoDataBase conexao = new ConexaoDataBase();
     public static List<Endereco> carregarEnderecos(){
         List<Endereco> out = new ArrayList<>();

         try {
             Connection conn = conexao.getConexao();

             Statement sta = conn.createStatement();
             ResultSet rs = sta.executeQuery("Select * from public.enderecos;");

             while (rs.next()){
                 Endereco end = new Endereco(rs.getInt("id"), rs.getInt("idCliente"), rs.getInt("cep"), rs.getString("bairro"), rs.getString("rua"), rs.getInt("numero"), rs.getString("cidade"), rs.getString("estado"));

                 out.add(end);
             }
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         return out;
     }

     public static void inserirEndereco(Endereco endereco){

         try {
             Connection conn = conexao.getConexao();

             String sqlInsert = "Insert into public.enderecos (cep, bairro, rua, numero, cidade, estado) values( ?, ?, ?, ?, ?, ?)";

             PreparedStatement pre = conn.prepareStatement(sqlInsert);
             pre.setInt(1, endereco.getCepEnd());
             pre.setString(2, endereco.getBairroEnd());
             pre.setString(3, endereco.getRuaEnd());
             pre.setInt(4, endereco.getNumeroEnd());
             pre.setString(5, endereco.getCidadeEnd());
             pre.setString(6, endereco.getEstadoEnd());

             pre.execute();

             pre.close();

         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }
     public static Boolean deletarEndereco(int idEndereco){
         try {
             Connection conn = conexao.getConexao();

             String deleteSql = "delete from public.endereco where id = ?;";

             PreparedStatement ps = conn.prepareStatement(deleteSql);
             ps.setInt(1, idEndereco);

             return ps.execute();
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }
     public static Boolean atualizarEndereco(int idEndereco, Endereco end){
         try {
             Connection conn = conexao.getConexao();

             String updateSql = "update enderecos set cep = ?, set bairro = ?, rua = ?, numero = ?, cidade = ?, estado = ?, where id = ?";

             PreparedStatement ps = conn.prepareStatement(updateSql);
             ps.setInt(1, end.getCepEnd());
             ps.setString(2, end.getBairroEnd());
             ps.setString(3, end.getRuaEnd());
             ps.setInt(4, end.getNumeroEnd());
             ps.setString(5, end.getCidadeEnd());
             ps.setString(6, end.getEstadoEnd());
             ps.setInt(7, idEndereco);

             return ps.execute();
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }
}
