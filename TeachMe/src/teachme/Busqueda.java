/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teachme;

import Clases.Alumno;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import Clases.Asesor;
import Clases.Horario;
import Clases.Materia;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static teachme.TeachMe.BuscarAsesor;
import static teachme.TeachMe.BuscarHorario;
import static teachme.TeachMe.getConection;
import static teachme.TeachMe.getTabla;
import static teachme.TeachMe.BuscarMateria;
/**
 *
 * @author estef
 */
public class Busqueda extends javax.swing.JFrame {
    Alumno alumnoBuscando = new Alumno();
    int clickTabla = 0;
    /**
     * Creates new form Busqueda
     * @param alumno
     */
    public Busqueda(Alumno alumno) {
        alumnoBuscando = alumno;
        initComponents();
    }

    private Busqueda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbMateria = new javax.swing.JComboBox<>();
        cmbHorario = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsesores = new javax.swing.JTable();
        lblError = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(50, 50));

        cmbMateria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona...", "Sistemas Digitales", "Programacion Estructurada", "Fisica I", "Fisica II", "Fisica III", "Fisica IV", "Quimica General", "Matematicas I", "Matematicas II", "Matematicas III", "Matematicas IV" }));

        cmbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona...", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00" }));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asesor/imagenes/btnbuscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Aquí aparecerán los asesores que se ajusten a tu búsqueda");

        tblAsesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAsesores.setCellSelectionEnabled(true);
        tblAsesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAsesoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAsesores);

        lblError.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblError.setText("Por favor, selecciona una materia");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asesor/imagenes/btnback.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(202, 202, 202))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbMateria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addComponent(cmbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblError)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbHorario, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(cmbMateria)))
                            .addComponent(btnBuscar)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nommateria = cmbMateria.getSelectedItem().toString();
        int idHora;
        if(cmbHorario.getSelectedItem().toString().equals("Selecciona...")){
            idHora = 0;
        }
        else{
            String hora = cmbHorario.getSelectedItem().toString();
            Horario horario = BuscarHorario(hora);
            idHora = horario.getId();
        }
        if( cmbMateria.getSelectedItem().toString().equals("Selecciona...")){
            lblError.setForeground(Color.red);
        }
        else{
            Materia materia = BuscarMateria(nommateria);
            BuscarAsesorPorMateria(materia.getId(),idHora);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        UserDashboard userDashboard = new UserDashboard(alumnoBuscando);
        userDashboard.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblAsesoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAsesoresMouseClicked
        // TODO add your handling code here:
        clickTabla = this.tblAsesores.rowAtPoint(evt.getPoint());
        int id = (int)tblAsesores.getValueAt(clickTabla, 0);
        String nombre = ""+tblAsesores.getValueAt(clickTabla, 1);
        String apellido = ""+tblAsesores.getValueAt(clickTabla, 2);
        
        
        int column = tblAsesores.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblAsesores.getRowHeight();
        
        if(row < tblAsesores.getRowCount() && row >= 0 && column < tblAsesores.getColumnCount() && column >= 0){
            Object value = tblAsesores.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                if(boton.getName().equals("q")){
                    int confirm = JOptionPane.showConfirmDialog(null, "Obtener más información", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                    if(JOptionPane.OK_OPTION == confirm){
                        System.out.println("confirmadoo");
                        Asesor asesor = BuscarAsesor(id);
                        Materia mat = BuscarMateria( cmbMateria.getSelectedItem().toString() );
                        creaSesion sesion = new creaSesion(asesor, alumnoBuscando, mat);
                        sesion.setVisible(true);
                        this.setVisible(false);
                    }
                    
                    //EVENTOS ELIMINAR
                }
            }
        }
    }//GEN-LAST:event_tblAsesoresMouseClicked
    
    
    private void BuscarAsesorPorMateria(int idMateria, int idHora){
        tblAsesores.setDefaultRenderer(Object.class, new Renderizar());
        JButton guardar = new JButton("Seleccionar");
        guardar.setName("q");
        DefaultTableModel modelo = new DefaultTableModel();
        Connection con;
        PreparedStatement ps;
        ResultSet res;
        con = getConection();
        String query = " SELECT DISTINCT(asesores.id_usuario), asesores.contacto, CONCAT(usuario.nombre, '  ',usuario.ap_paterno ) AS nombre FROM materiasasesor LEFT JOIN asesores ON materiasasesor.id_asesor = asesores.id INNER JOIN usuario ON asesores.id_usuario = usuario.id  LEFT JOIN horariosasesor ON horariosasesor.id_asesor = asesores.id ";
            query += " WHERE horariosasesor.disponible = 1 ";
        if(idHora > 0){
            query += " AND materiasasesor.id_materia =" + idMateria + "  AND horariosasesor.id_horario = "+idHora;
        }
        else{
            query += " AND materiasasesor.id_materia ="+ idMateria;
        }
        res = getTabla(query);
        modelo.setColumnIdentifiers(new Object[]{"No.","Contacto","Nombre", "Click"});
        try{
            if(res == null){
                modelo.addRow(new Object[]{"No hay usuarios con este servicio","Sin usau"});
            }
            else{
                while(res.next()){
                modelo.addRow(new Object[]{res.getInt(1),res.getString(2),res.getString(3), guardar});
                }
                tblAsesores.setModel(modelo);                
                tblAsesores.setPreferredScrollableViewportSize(tblAsesores.getPreferredSize());
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        //res = ps.executeQuery();
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
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Busqueda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cmbHorario;
    private javax.swing.JComboBox<String> cmbMateria;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JTable tblAsesores;
    // End of variables declaration//GEN-END:variables
}
