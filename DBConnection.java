/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingGui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author CoOl
 */
public class DBConnection {
     public static Statement statementObject(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver loaded");
        }catch(Exception e){
            System.out.println("driver not loaded");
        }
        Connection con=null;
        
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electricitybilling","root","");
            System.out.println("database loaded");
        }catch(Exception e){
            System.out.println("database not loaded");
        }
        Statement st=null;
        try{
            st=con.createStatement();
            
        }catch(Exception e){
            System.out.println("error");
        }
        return st;
    }
}
