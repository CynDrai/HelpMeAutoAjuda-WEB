package br.uniparTADS.HelpMeAutoAjudaWEB.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.postgresql.util.PSQLException;

public class ConnectionFactory {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        
        try{
            Class.forName("org.postgresql.Driver");
            
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/dbHMAA",
                    "postgres",
                    ""
            );
        } catch(PSQLException ex) {
            System.out.println("Erro no banco de dados : " + ex.getMessage());
        }
        
        return null;
    }
    
}
