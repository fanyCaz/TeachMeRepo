/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teachme;

import Clases.Alumno;
import Clases.Asesor;
import Clases.Horario;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import Clases.Usuario;
import Clases.Materia;
import com.mysql.jdbc.Statement;
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
    
    public static ResultSet getTabla(String Query){
        Connection con = getConection();
        Statement st ;
        ResultSet datos = null;
        try{
            st = (Statement) con.createStatement();
            datos = st.executeQuery(Query);
        }catch(Exception e){
            System.out.println(e);
        }
        return datos;
    }
    
    public static int BuscarTipoUsuario(int id){
        int result;
        try{
            Connection con;
            PreparedStatement ps;
            ResultSet res;
            con = getConection();
            String query = "SELECT asesores.id FROM usuario INNER JOIN asesores ON usuario.id = asesores.id_usuario WHERE asesores.id_usuario = ?";
            //ps = (PreparedStatement) con.createStatement("");
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, id);
            res = ps.executeQuery();
            //Si trae datos, entonces es un asesor
            if(res.first()){
                result = 1;
            }//Si viene vacio entonces es un alumno
            else{
                result = 0;
            }
            res.close();
            ps.close();
            return result;
        }catch(SQLException e){
            System.out.println(e);
            return 0;
        }
    }
    
    public static Materia BuscarMateria(String nomMateria){
        String nombre; int id;
        Materia buscado = new Materia();
        try{
            Connection con;
            PreparedStatement ps;
            ResultSet res;
            con = getConection();
            String query = "SELECT * FROM materias WHERE nombre =?";
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, nomMateria);
            res = ps.executeQuery();
            if(res.next() == false){
                System.out.println("No existe");
                return null;
            }
            if(res.first()){
                id = res.getInt(1);
                nombre= res.getString(2);
                buscado.setNombre(nombre);
                buscado.setId(id);
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
    
    public static Horario BuscarHorario(String hora){
        String horadb; int id;
        Horario buscado = new Horario();
        try{
            Connection con;
            PreparedStatement ps;
            ResultSet res;
            con = getConection();
            String query = "SELECT * FROM horarios WHERE hora =?";
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, hora);
            res = ps.executeQuery();
            if(res.next() == false){
                System.out.println("No existe");
                return null;
            }
            if(res.first()){
                id = res.getInt(1);
                horadb= res.getString(2);
                buscado.setHora(horadb);
                buscado.setId(id);
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
    
    
    public static Asesor BuscarAsesor(int id){
        String pswDB="", nombreDB="", apellidoDB, apellidoMDB, usernameDB ;
        String contacto;
        int id_usuario,Id;
        Asesor buscado = new Asesor();
        try{
            Connection con;
            PreparedStatement ps;
            ResultSet res;
            con = getConection();
            String query = "SELECT asesores.id, asesores.contacto ,usuario.nombre, usuario.ap_paterno, usuario.ap_materno, usuario.username, usuario.id FROM usuario INNER JOIN asesores ON usuario.id = asesores.id_usuario WHERE  asesores.id_usuario = ?";
            //ps = (PreparedStatement) con.createStatement("");
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, id);
            res = ps.executeQuery();
            if(res.next() == false){
                System.out.println("No existe");
                return null;
            }
            if(res.first()){
                Id = res.getInt(1);
                contacto = res.getString(2);
                nombreDB= res.getString(3);
                apellidoDB = res.getString(4);
                apellidoMDB = res.getString(5);
                usernameDB = res.getString(6);
                id_usuario = res.getInt(7);
                buscado.setId(Id);
                buscado.setContacto(contacto);
                buscado.setNombre(nombreDB);
                buscado.setApPaterno(apellidoDB);
                buscado.setApMaterno(apellidoMDB);
                buscado.setUsername(usernameDB);
                buscado.setId_usuario(id_usuario);
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
    
    public static Alumno BuscarAlumno(int id){
        String pswDB="", nombreDB="", apellidoDB, apellidoMDB, usernameDB ;
        int semestre;
        Alumno buscado = new Alumno();
        try{
            Connection con;
            PreparedStatement ps;
            ResultSet res;
            con = getConection();
            String query = "SELECT alumnos.id, alumnos.semestre ,usuario.nombre, usuario.ap_paterno, usuario.ap_materno, usuario.username, usuario.id FROM usuario INNER JOIN alumnos ON usuario.id = alumnos.id_usuario WHERE alumnos.id_usuario = ?";
            //ps = (PreparedStatement) con.createStatement("");
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, id);
            res = ps.executeQuery();
            if(res.next() == false){
                System.out.println("No existe");
                return null;
            }
            if(res.first()){
                id = res.getInt(1);
                semestre = res.getInt(2);
                nombreDB= res.getString(3);
                apellidoDB = res.getString(4);
                apellidoMDB = res.getString(5);
                usernameDB = res.getString(6);
                buscado.setId(id);
                buscado.setSemestre(semestre);
                buscado.setNombre(nombreDB);
                buscado.setApPaterno(apellidoDB);
                buscado.setApMaterno(apellidoMDB);
                buscado.setUsername(usernameDB);
                buscado.setId_usuario(res.getInt(7));
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
    
    public static Usuario BuscarUsuario(String nom_usuario){
        String pswDB="", nombreDB="", apellidoDB, apellidoMDB, usernameDB;
        int id;
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
                id = res.getInt(1);
                nombreDB= res.getString(2);
                apellidoDB = res.getString(3);
                apellidoMDB = res.getString(4);
                usernameDB = res.getString(5);
                buscado.setNombre(nombreDB);
                buscado.setApPaterno(apellidoDB);
                buscado.setApMaterno(apellidoMDB);
                buscado.setUsername(usernameDB);
                buscado.setPassword(pswDB);
                buscado.setId(id);
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
