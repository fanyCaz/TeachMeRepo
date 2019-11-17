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
import Clases.Usuario;
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
    
    public static ResultSet BuscarUsuarioId(int id){
        try{
            Connection con = null;
            con = getConection();
            PreparedStatement ps;
            ResultSet res;
            String query = "SELECT * FROM usuario WHERE id = " + id;
            ps = (PreparedStatement) con.prepareStatement(query);
            
            ResultSet result = ps.executeQuery();
            return result;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    
    public static Usuario BuscarUsuario(String nom_usuario){
        String pswDB="", nombreDB="", apellidoDB, apellidoMDB, usernameDB;
        Usuario buscado = new Usuario();
        try{
            Connection con;
            PreparedStatement ps;
            ResultSet res;
            con = getConection();
            String query = "SELECT * FROM usuario WHERE username =?";
            //ps = (PreparedStatement) con.createStatement("");
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario WHERE username =?");
            ps.setString(1, nom_usuario);
            res = ps.executeQuery();
            if(res.next() == false){
                System.out.println("No existe");
                return null;
            }
            if(res.first()){
                pswDB = res.getString(6);
                nombreDB= res.getString(2);
                apellidoDB = res.getString(3);
                apellidoMDB = res.getString(4);
                usernameDB = res.getString(5);
                buscado.setNombre(nombreDB);
                buscado.setApPaterno(apellidoDB);
                buscado.setApMaterno(apellidoMDB);
                buscado.setUsername(usernameDB);
                buscado.setPassword(pswDB);
            }
            //System.out.println(buscado.getApPaterno() + "paterno");
            res.close();
            ps.close();
            return buscado;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
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
