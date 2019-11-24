/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teachme;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static teachme.TeachMe.getConection;
import validation.validar2;
/*CLASES*/
import Clases.Usuario;
import Clases.Asesor;
import Clases.Alumno;
import Clases.Materia;
import com.mysql.jdbc.Statement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import static teachme.TeachMe.BuscarMateria;
/**
 *
 * @author estef
 */
public class RegistrarseView extends javax.swing.JFrame {
    
    ChangeListener changeListener = new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent changEvent) {
       boolean selected = radioAlumno.isSelected();
       if(selected){
            txtSemestre.setVisible(true);
            cmbmaterias.setVisible(false);
            lblmat.setVisible(false);
            lblsem.setVisible(true);
        }
        else{
            txtSemestre.setVisible(false);
            cmbmaterias.setVisible(true);
            lblmat.setVisible(true);
            lblsem.setVisible(false);
        }
      }
    };
    
    public RegistrarseView() {
        initComponents();
        lblusuarioex.setVisible(false);
        validar2 v=new validar2();
        txtSemestre.setVisible(false);
        cmbmaterias.setVisible(false);
        lblmat.setVisible(false);
        lblsem.setVisible(false);
        radioAlumno.addChangeListener(changeListener); //Detectar si cambia el selected
        v.validarSoloLetras(txtNombre);
        v.validarSoloLetras(txtApPaterno);
        v.validarSoloLetras(txtApMaterno);
        v.validarEspacios(txtpsw);
        v.validarSoloNumeros(txtSemestre);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        radioAsesor = new javax.swing.JRadioButton();
        txtNombre = new javax.swing.JTextField();
        txtApPaterno = new javax.swing.JTextField();
        txtApMaterno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        txtNomUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        radioAlumno = new javax.swing.JRadioButton();
        lblError = new javax.swing.JLabel();
        txtpsw = new javax.swing.JTextField();
        txtSemestre = new javax.swing.JTextField();
        cmbmaterias = new javax.swing.JComboBox<>();
        lblsem = new javax.swing.JLabel();
        lblmat = new javax.swing.JLabel();
        lblusuarioex = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblerror = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(167, 167, 238));
        setLocation(new java.awt.Point(50, 50));
        setMinimumSize(new java.awt.Dimension(1000, 580));
        setPreferredSize(new java.awt.Dimension(1100, 580));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 224, 197));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        buttonGroup1.add(radioAsesor);
        radioAsesor.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        radioAsesor.setText("Soy Asesor");
        radioAsesor.setToolTipText("");
        radioAsesor.setName(""); // NOI18N

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApMaternoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setText("Apellido Paterno");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("Apellido Materno");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setText("Nombre de Usuario");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setText("Contraseña");

        buttonGroup1.add(radioAlumno);
        radioAlumno.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        radioAlumno.setText("Soy Alumno");
        radioAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAlumnoActionPerformed(evt);
            }
        });

        cmbmaterias.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cmbmaterias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sistemas Digitales", "Programacion Estructurada", "Fisica I", "Fisica II", "Fisica III", "Fisica IV", "Quimica General", "Matematicas I", "Matematicas II", "Matematicas III", "Matematicas IV" }));

        lblsem.setText("Semestre");

        lblmat.setText("Materia que impartes");

        lblusuarioex.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblusuarioex.setText("Este usuario ya existe");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmbmaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(398, 398, 398)
                        .addComponent(lblsem))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(761, 761, 761)
                        .addComponent(lblError))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(txtNomUser, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)))
                            .addGap(27, 27, 27)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtApMaterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(txtApPaterno, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lblmat))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioAsesor, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(153, 153, 153)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radioAlumno)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtpsw, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(lblusuarioex, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNomUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtpsw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioAlumno, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(radioAsesor, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsem)
                    .addComponent(lblmat, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbmaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblusuarioex, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblsem.getAccessibleContext().setAccessibleName("lblSemestre");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 530, 430));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asesor/imagenes/fondo1.png"))); // NOI18N
        jLabel9.setMaximumSize(new java.awt.Dimension(700, 800));
        jLabel9.setMinimumSize(new java.awt.Dimension(700, 800));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1140, 430));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel7.setText("REGISTRATE");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 165, 21));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asesor/imagenes/btnback.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 70));
        getContentPane().add(lblerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 616, 21));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioAlumnoActionPerformed

    private void txtApMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApMaternoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        String nombre="",ap_paterno="",ap_materno="",nom_usuario="",nombre_result, password="", materia="";
        String pswEncriptado;
        int idGuardado,semestre=0;
        nombre_result = null;
        int tipoUsuario;
        
        nombre = txtNombre.getText();
        ap_paterno = txtApPaterno.getText();
        ap_materno = txtApMaterno.getText();
        nom_usuario = txtNomUser.getText();
        password = txtpsw.getText();
        tipoUsuario = ( radioAsesor.isSelected() ) ? 1 : 2; //1 es Asesor, 2 es Alumno, este es un if ternario
        if(tipoUsuario == 2){
            semestre = Integer.parseInt(txtSemestre.getText());
        }
        else{
            materia = cmbmaterias.getSelectedItem().toString();
        }
        Usuario nuevoUser = new Usuario();
        nuevoUser.setNombre(nombre);
        nuevoUser.setApPaterno(ap_paterno);
        nuevoUser.setApMaterno(ap_materno);
        nuevoUser.setUsername(nom_usuario);
        nuevoUser.setPassword(password);
        
        try {
            Connection con = null;
            con = getConection();
            PreparedStatement ps;
            ResultSet res;
            String query;
            ResultSet verificacion = VerificarExistenciaUsuario(nom_usuario);
            if(verificacion != null){
                while(verificacion.next()){
                    nombre_result =verificacion.getString(5);
                }
            }
            if(nombre_result != null && nombre_result.equals(nom_usuario)){
                lblusuarioex.setVisible(true);
            }
            else{
                lblusuarioex.setVisible(false);
                pswEncriptado =TeachMe.encripta(nuevoUser.getPassword(), 2);
                query = "INSERT INTO usuario (nombre,ap_paterno,ap_materno,username, password) VALUES (?,?,?,?,?)";
                ps = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS); /* El nombre de la tabla*/
                ps.setString(1, nuevoUser.getNombre());
                ps.setString(2, nuevoUser.getApPaterno());
                ps.setString(3, nuevoUser.getApMaterno());
                ps.setString(4, nuevoUser.getUsername());
                ps.setString(5, pswEncriptado);
                ps.executeUpdate();
                ResultSet affected = ps.getGeneratedKeys(); //Para ver el id con el que se guardo este usuario
                if(affected.next()){
                    idGuardado = affected.getInt(1);
                    //Si el usuario es asesor
                    if(tipoUsuario == 1){
                        Asesor nuevoAsesor = new Asesor();
                        nuevoAsesor.setCalificacion(0);
                        nuevoAsesor.setId_usuario(idGuardado);
                        String q2 = "INSERT INTO asesores (id_usuario, calificacion) VALUES(?,?)";
                        ps = (PreparedStatement) con.prepareStatement(q2, Statement.RETURN_GENERATED_KEYS); /* El nombre de la tabla*/
                        ps.setInt(1, nuevoAsesor.getId_usuario());
                        ps.setDouble(2, nuevoAsesor.getCalificacion());
                        ps.executeUpdate();
                        ResultSet affectedAsesor = ps.getGeneratedKeys();
                        if(affectedAsesor.next()){
                            int idAsesor = affectedAsesor.getInt(1);
                            Materia materiaSeleccionada = BuscarMateria(materia);
                            q2 = "INSERT INTO materiasasesor (id_asesor, id_materia) VALUES(?,?)";
                            ps = (PreparedStatement) con.prepareStatement(q2, Statement.RETURN_GENERATED_KEYS); /* El nombre de la tabla*/
                            ps.setInt(1, idAsesor);
                            ps.setInt(2, materiaSeleccionada.getId());
                            ps.executeUpdate();
                        }
                    }
                    //Si el usuario es estudiante
                    else{
                        Alumno nuevoAlumno = new Alumno();
                        nuevoAlumno.setSemestre(semestre);
                        nuevoAlumno.setId_usuario(idGuardado);
                        String q2 = "INSERT INTO alumnos (id_usuario, semestre) VALUES(?,?)";
                        ps = (PreparedStatement) con.prepareStatement(q2, Statement.RETURN_GENERATED_KEYS); /* El nombre de la tabla*/
                        ps.setInt(1, nuevoAlumno.getId_usuario());
                        ps.setDouble(2, nuevoAlumno.getSemestre());
                        ps.execute();
                    }
                }

                
                Thread.sleep(1000);
                Index r = new Index();
                r.setVisible(true);
                this.setVisible(false);
            }
            
            System.out.println(nombre_result);

//            
//
//            if (res.next()) {
//                JOptionPane.showMessageDialog(null, res.getString("nombre")); /* los datos que deseas imprimir */
//
//            } else {
//                JOptionPane.showMessageDialog(null, "No Existen Datos.");
//            }
        } catch (Exception e) {
            System.out.println(e);
            lblError.setText("Hubo un error en la conexion a la base de datos");
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Index index = new Index();
        index.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public ResultSet VerificarExistenciaUsuario(String nom_usuario){
        try{
            Connection con = null;
            con = getConection();
            PreparedStatement ps;
            ResultSet res;
            String query = "SELECT * FROM usuario WHERE username = '" + nom_usuario + "'";
            ps = (PreparedStatement) con.prepareStatement(query);
            
            ResultSet result = ps.executeQuery();
            return result;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarseView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbmaterias;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblerror;
    private javax.swing.JLabel lblmat;
    private javax.swing.JLabel lblsem;
    private javax.swing.JLabel lblusuarioex;
    private javax.swing.JRadioButton radioAlumno;
    private javax.swing.JRadioButton radioAsesor;
    private javax.swing.JTextField txtApMaterno;
    private javax.swing.JTextField txtApPaterno;
    private javax.swing.JTextField txtNomUser;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSemestre;
    private javax.swing.JTextField txtpsw;
    // End of variables declaration//GEN-END:variables
}
