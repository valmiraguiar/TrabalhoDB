package model;

import controller.DBConnection;

public class PacienteDAO {

    private DBConnection con;
    
    public void insertPaciente(Paciente p) {
        //con  = new DBConnection();
        
        System.out.println(p.toString());
    }
    
}
