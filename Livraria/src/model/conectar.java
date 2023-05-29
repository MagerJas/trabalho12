package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class conectar {
    public Connection conectar(){
    Connection con = null;
    System.out.println("Conectando ao banco...");
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/livros", "root", "");
        System.out.println("Conectado");
    }
    catch(Exception e){
        System.out.println("falha na conexão");
        System.out.println(e.getMessage());
    }
    return con;
}
}
