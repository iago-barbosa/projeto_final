/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe para gerenciar a conexão com o banco de dados.
 * Esta classe utiliza o driver JDBC do MySQL para estabelecer a conexão.
 * 
 * @author Senai
 */
public class Conexao {
    // URL de conexão com o banco de dados MySQL
    private static final String url = "jdbc:mysql://db4free.net:3306/senai_ecom_iago?useSSL=false";
    // Nome de usuário do banco de dados
    private static final String user = "senai_iago_b";
    // Senha de acesso ao banco de dados
    private static final String password = "root1234";
    // Driver JDBC para o MySQL
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    
    /**
     * Estabelece uma conexão com o banco de dados.
     * 
     * @return A conexão estabelecida.
     */
    public static Connection conectar() {
        Connection con = null;
        try {
            // Carrega o driver JDBC
            Class.forName(driver);
            // Estabelece a conexão com o banco de dados usando as informações fornecidas
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            // Em caso de erro, imprime a exceção ocorrida
            System.out.println(e);
        }
        return con;
    }
}
