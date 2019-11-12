package validation;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erik-
 */
public class validar2 {
    public void validarSoloLetras(JTextField campo){
    campo.addKeyListener(new KeyAdapter() {
      public void keyTyped(KeyEvent e){
          char c = e.getKeyChar();
          int k=(int)e.getKeyChar();
          if(Character.isDigit(c) || k==32){ // el 32 signfica en el codigo ascii el espacio
          e.consume();
           System.out.println("car: "+c); 
          }
      }
    
    });
    }
    
    public void validarEspacios(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent e){
              char c = e.getKeyChar();
              int k=(int)e.getKeyChar();
              if(k==32){ // el 32 signfica en el codigo ascii el espacio
              e.consume();
               System.out.println("car: "+c); 
              }
          }

        });
    }
    
    public void validarSoloNumeros(JTextField campo){
    campo.addKeyListener(new KeyAdapter() {
      public void keyTyped(KeyEvent e){
          char c = e.getKeyChar();
          
          if(!Character.isDigit(c)){
          e.consume();
           System.out.println("car: "+c);
          }
      }
    
    });
    }
        
    public void limitarCaracteres(JTextField campo, int cantidad){
    campo.addKeyListener(new KeyAdapter() {
      public void keyTyped(KeyEvent e){
          char c = e.getKeyChar();
          int tam=campo.getText().length();
          if(tam>=cantidad){
          e.consume();
          System.out.println("car: "+c);
          }
      }
    
    });
    }

  
    
}
