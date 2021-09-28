package controller;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    
    private static String url = "jdbc:postgresql://localhost:5432/Agendamento";
    private static String user = "postgres";
    private static String password = "1234";
    private static Connection con;
    
    public static void connection(){
        try {            
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Succesfully");
            
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed");
        }
    }

}
