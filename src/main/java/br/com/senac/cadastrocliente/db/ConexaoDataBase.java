package br.com.senac.cadastrocliente.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDataBase {
    private Connection conn = null;

    public synchronized Connection getConexao() throws SQLException{
        if (conn == null){
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cadastro", "postgres", "postgres");

        }
        return conn;
    }
}
