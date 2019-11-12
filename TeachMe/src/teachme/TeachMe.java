/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teachme;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author estef
 */
public class TeachMe {
    public static final String URL = "jdbc:mysql://localhost:3306/asesorias"; /* La ruta de tu base de datos */
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        encripta("mtqn",1);
        try {
            Connection con = null;
            con = getConection();
            PreparedStatement ps;
            ResultSet res;
            
            //ps = (PreparedStatement) con.prepareStatement("SELECT * FROM materias"); /* El nombre de la tabla*/
            //res = ps.executeQuery();
            /*if (res.next()) {
                JOptionPane.showMessageDialog(null, res.getString("nombre")); // los datos que deseas imprimir 
            } else {
                JOptionPane.showMessageDialog(null, "No Existen Datos.");
            }
            */
            //VALIDACION DE BASE DE DATOS ANTES DE INICIAR TODO
            Index in = new Index();
            in.setVisible(true);
        
        } catch (Exception e) {
            System.out.println(e);
        }
    
    
        
    }

    public static Connection getConection() {
            Connection con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
                //JOptionPane.showMessageDialog(null, "Conexion Exitosa");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
            return con;
        }
    
        public static String encripta(String psw, int desencripta){
            String resultadoEncript;
            //desencripta el mensaje
            if(desencripta == 1){
                //encriptado = "mtqn";
                char arrayD[] = psw.toCharArray();
                for(int i=0; i< arrayD.length; i++){
                        arrayD[i] = (char)(arrayD[i] - (char)5);
                }
                String desencriptado = String.valueOf(arrayD);
                System.out.println(desencriptado);
                return desencriptado;
            }
            //encripta el mensaje
            else{
                String mensaje = psw;
                char array[] = psw.toCharArray();
                for(int i=0; i< array.length; i++){
                        array[i] = (char)(array[i] + (char)5);
                }

                String encriptado = String.valueOf(array);
                System.out.println(encriptado);
                return encriptado;
                //
            }
        }

}
