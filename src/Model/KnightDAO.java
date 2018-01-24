/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KnightDAO {
    
    private final String URL = "jdbc:postgresql://localhost:5432/Knight";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "postgres"; 

    private Connection connection = null; //gerencia conexão;   
    private PreparedStatement selectKnight = null;
    
    public KnightDAO(){

        try{
            connection = DriverManager.getConnection(this.URL, this.USERNAME, this.PASSWORD);
            
            selectKnight = connection.prepareStatement("select * from Knight where idKnight = ?");
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            System.exit(1);
        }
    }
    
    //retorna um knight;
    public List<Knight> getKnightById(int id){
        List<Knight> results = null;
        ResultSet resultSet = null;
        
        try {
           selectKnight.setInt(1, id); //especifica o id;
            
            //executeQuery retorna que contém entradas correspondentes;
            resultSet = selectKnight.executeQuery();
            
            results = new ArrayList<>();
            
            while(resultSet.next()){
                results.add(new Knight(
                    resultSet.getInt("idKnight"),
                    resultSet.getString("nome"),
                    resultSet.getDouble("ataque"),
                    resultSet.getDouble("defesa"),
                    resultSet.getDouble("esquiva"),
                    resultSet.getDouble("ataqueEspecial"),
                    resultSet.getString("nomeAtaqueEspecial"))
                );
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
        finally{
            try{
                resultSet.close();
            }catch(SQLException sqlException){
                sqlException.printStackTrace();
                close();
            }
        }
     
        return results;
    }
    
    //este também;
    public void close(){
        try{
            connection.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
}
