/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jflexproy1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author CiPp9
 */
public class pantalla_jflex extends javax.swing.JFrame {

    /**
     * Creates new form pantalla_jflex
     */
    public pantalla_jflex() {
        initComponents();
    }

    public String AbrirArchivo(File direccion){
        
        String txt="";
        
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            
            while((bfRead = bf.readLine())!= null){
                temp += bfRead + "\n";
            }
            
            txt = temp;
            
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return txt;
    }
    
    public void expresionRegular(String regex, String string){
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(string);
        String resultado = "";
        
        while (matcher.find()) {
            
            resultado += matcher.group(0) + "\n";
            for (int i = 1; i <= matcher.groupCount(); i++) {
                resultado += "Group " + i + ": " + matcher.group(i) + "\n";
            }
        }
        txta_ResultadoConsola.setText(resultado);
    }
    
    public void guardarArchivo(String consola) throws IOException{
        
        
        FileWriter archivo = new FileWriter("C:/Users/CiPp9/Documents/Compiladores/Resultado.txt");
        archivo.write(consola);
        archivo.close();
        JOptionPane.showMessageDialog(null, "Se ha guardado el archivo.");
    }
    
    public void guardarComo(String cadena){

        JFileChooser guardar = new JFileChooser();
        guardar.showSaveDialog(null);
        guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        File archivo = guardar.getSelectedFile();
    
        FileWriter escribir;
        try {

            escribir = new FileWriter(archivo, true);
            escribir.write(cadena);
            escribir.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, en la salida");
        }

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_PRINCIPAL = new javax.swing.JPanel();
        text_Cargar = new javax.swing.JTextField();
        text_ExpresionRegular = new javax.swing.JTextField();
        btn_Archivo = new javax.swing.JButton();
        btn_Guardar = new javax.swing.JButton();
        btn_Validar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        texta_ArchivoCargado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txta_ResultadoConsola = new javax.swing.JTextArea();
        btnAnalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        text_ExpresionRegular.setToolTipText("");

        btn_Archivo.setText("Archivo");
        btn_Archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ArchivoActionPerformed(evt);
            }
        });

        btn_Guardar.setText("Guardar");
        btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuardarActionPerformed(evt);
            }
        });

        btn_Validar.setText("Validar RegEx");
        btn_Validar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ValidarActionPerformed(evt);
            }
        });

        texta_ArchivoCargado.setColumns(20);
        texta_ArchivoCargado.setRows(5);
        jScrollPane1.setViewportView(texta_ArchivoCargado);

        txta_ResultadoConsola.setColumns(20);
        txta_ResultadoConsola.setRows(5);
        jScrollPane2.setViewportView(txta_ResultadoConsola);

        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_PRINCIPALLayout = new javax.swing.GroupLayout(Panel_PRINCIPAL);
        Panel_PRINCIPAL.setLayout(Panel_PRINCIPALLayout);
        Panel_PRINCIPALLayout.setHorizontalGroup(
            Panel_PRINCIPALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PRINCIPALLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_PRINCIPALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(Panel_PRINCIPALLayout.createSequentialGroup()
                        .addGroup(Panel_PRINCIPALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(text_Cargar)
                            .addComponent(text_ExpresionRegular, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(Panel_PRINCIPALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Validar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Panel_PRINCIPALLayout.createSequentialGroup()
                                .addComponent(btn_Archivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Guardar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        Panel_PRINCIPALLayout.setVerticalGroup(
            Panel_PRINCIPALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PRINCIPALLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_PRINCIPALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Archivo)
                    .addComponent(btn_Guardar))
                .addGap(18, 18, 18)
                .addGroup(Panel_PRINCIPALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_ExpresionRegular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Validar))
                .addGap(4, 4, 4)
                .addComponent(btnAnalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Panel_PRINCIPAL, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Panel_PRINCIPAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ArchivoActionPerformed
        JFileChooser jfc = new JFileChooser();

        if(jfc.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            File archivo=jfc.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("txt")){
                    text_Cargar.setText(archivo.getAbsolutePath());
                    String documento = AbrirArchivo(archivo);
                    texta_ArchivoCargado.setText(documento);
                }else{
                    JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                }
            }
        }
    }//GEN-LAST:event_btn_ArchivoActionPerformed

    private void btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarActionPerformed
        String resultado = txta_ResultadoConsola.getText();
        guardarComo(resultado);
    }//GEN-LAST:event_btn_GuardarActionPerformed

    private void btn_ValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ValidarActionPerformed
        String expReg = text_ExpresionRegular.getText();
        String texto = texta_ArchivoCargado.getText();
        if(expReg.equals("")){
            JOptionPane.showMessageDialog(null, "No ha ingresado una expresión regular");
        }else{
            expresionRegular(expReg,texto);
        }
    }//GEN-LAST:event_btn_ValidarActionPerformed

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        File archivo = new File("archivo.txt");
PrintWriter escribir;
try {
escribir = new PrintWriter(archivo);
escribir.print(texta_ArchivoCargado.getText());
escribir.close();
} catch (FileNotFoundException ex) {
// Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
java.util.logging.Logger.getLogger(pantalla_jflex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}
// try {
Reader lector;
try {
lector = new BufferedReader(new FileReader("archivo.txt"));
Lexer lexer = new Lexer(lector);
String resultado = "";
while (true) {
Tokens tokens = lexer.yylex();
if (tokens == null) {
resultado += "FIN";
txta_ResultadoConsola.setText(resultado);
return;
}
switch (tokens) {
case ERROR:
resultado += "Símbolo no definido\n";
break;
case Identificador: case Numero: case Reservadas:
resultado += lexer.lexeme + ": Es un " + tokens + "\n";
break;
default:
resultado += "Token: " + tokens + "\n";
break;
}
}
} catch (FileNotFoundException ex) {
// Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
java.util.logging.Logger.getLogger(pantalla_jflex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (IOException ex) {
// Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
java.util.logging.Logger.getLogger(pantalla_jflex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}
    }//GEN-LAST:event_btnAnalizarActionPerformed

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
            java.util.logging.Logger.getLogger(pantalla_jflex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantalla_jflex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantalla_jflex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantalla_jflex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantalla_jflex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_PRINCIPAL;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btn_Archivo;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JButton btn_Validar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField text_Cargar;
    private javax.swing.JTextField text_ExpresionRegular;
    private javax.swing.JTextArea texta_ArchivoCargado;
    private javax.swing.JTextArea txta_ResultadoConsola;
    // End of variables declaration//GEN-END:variables
}
