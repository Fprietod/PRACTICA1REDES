package Cliente;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ClienteAPP extends javax.swing.JFrame {   
    private String host = "192.168.0.2";
    private int puerto = 9000;
    private Socket sock;
    private DataOutputStream salida;
    private BufferedInputStream bis;
    private BufferedReader entrada;
    private BufferedOutputStream bos;
    private String mensajeRecibido;
    private File[] files;
    private int countArchivos;
    
    public void setHost(String host){
        this.host=host;
    }
    public void setPuerto(int puerto){
        this.puerto=puerto;
    }
    public ClienteAPP() {
        initComponents();
        enviarNombres.setEnabled(false);
        enviarArchivos.setEnabled(false);
        this.setLocationRelativeTo(null);
          jPuerto.setText("9000");
    }

    
    public void initClient(){
            setHost(JHost.getText());
           setPuerto(Integer.parseInt(jPuerto.getText()) );
        try{
            sock = new Socket(host, puerto); 
            salida = new DataOutputStream(sock.getOutputStream());
            entrada = new BufferedReader(new InputStreamReader(sock.getInputStream())); //lee mensaje del servidor
            //mensajeRecibido = 
            TextAreaCliente.append(entrada.readLine() + "\n");
            salida.writeUTF("*****LA CONEXIÓN CON EL SERVIDOR SE HA ESTABLECIDO***** \n");
            TextAreaCliente.append("-Ahora puede enviar archivos. \n");
            sock.close();
        }
        catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaCliente = new javax.swing.JTextArea();
        escogerArchivos = new javax.swing.JButton();
        archivosSelecionados = new javax.swing.JLabel();
        enviarNombres = new javax.swing.JButton();
        jPuerto = new javax.swing.JTextField();
        enviarArchivos = new javax.swing.JButton();
        lblArchivosSelecionados = new javax.swing.JLabel();
        lblElegir = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JHost = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interfáz de Usuario");
        setBackground(new java.awt.Color(102, 102, 102));
        setUndecorated(true);
        setResizable(false);

        TextAreaCliente.setColumns(20);
        TextAreaCliente.setRows(5);
        jScrollPane1.setViewportView(TextAreaCliente);

        escogerArchivos.setText("Seleccionar Archivos");
        escogerArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escogerArchivosActionPerformed(evt);
            }
        });

        archivosSelecionados.setBackground(new java.awt.Color(255, 255, 255));
        archivosSelecionados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        archivosSelecionados.setText("0");
        archivosSelecionados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        enviarNombres.setText("Enviar Nombres");
        enviarNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarNombresActionPerformed(evt);
            }
        });

        jPuerto.setText("9000");
        jPuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPuertoActionPerformed(evt);
            }
        });

        enviarArchivos.setText("Enviar Archivos");
        enviarArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarArchivosActionPerformed(evt);
            }
        });

        lblArchivosSelecionados.setText("Numero de Archivos");

        lblElegir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblElegir.setText("Selección archivos:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Puerto");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Cliente");

        jLabel3.setText("IP");

        jMenu1.setText("Iniciar Conexión");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cerrar Conexión");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblElegir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(escogerArchivos))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(lblArchivosSelecionados))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(enviarArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(archivosSelecionados, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JHost, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(enviarNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblElegir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(escogerArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(archivosSelecionados, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblArchivosSelecionados)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enviarNombres)
                    .addComponent(enviarArchivos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void escogerArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escogerArchivosActionPerformed
        try{
            escogerArchivos();
        } 
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_escogerArchivosActionPerformed

    public void escogerArchivos() throws IOException{
       JFileChooser fc = new JFileChooser();
       fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
       if (!fc.isMultiSelectionEnabled()){
          fc.setMultiSelectionEnabled(true);
       }
       int returnVal = fc.showOpenDialog(this);
       if (returnVal == JFileChooser.APPROVE_OPTION) {        
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            if (!fc.isMultiSelectionEnabled()){
                fc.setMultiSelectionEnabled(true);
            }  
            files = fc.getSelectedFiles();
            countArchivos = files.length;
            archivosSelecionados.setText(Integer.toString(countArchivos));
        }
       TextAreaCliente.append("________________________________________________________________\n");
       TextAreaCliente.append("Archivos seleccionados: " + files.length + "\n");
       for(int i=0; i<files.length;i++){
           TextAreaCliente.append("Archivo: " + files[i].getName() + " Tamaño: " + files[i].length() + " Bytes. \n");
       }
       TextAreaCliente.append("________________________________________________________________\n");
    }
    private void enviarNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarNombresActionPerformed
        enviarNombres.setEnabled(false);
        enviarArchivos.setEnabled(true);
        try {
            InputStream in = null;
            DataOutputStream out = null;
            sendNumFiles(files);
            TextAreaCliente.append("\nEnviando Nombres\n");
            TextAreaCliente.append("________________________________________________________________\n");
            for (int i = 0; i < files.length; i++){
                TextAreaCliente.append("Archivo "+(i+1)+": \n");
                files[i] = new File(files[i].getAbsolutePath());
                sendNames(files[i], 4096, out, in);
            }
            TextAreaCliente.append("________________________________________________________________\n");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_enviarNombresActionPerformed

    private void jPuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPuertoActionPerformed

    }//GEN-LAST:event_jPuertoActionPerformed

    private void enviarArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarArchivosActionPerformed

        enviarNombres.setEnabled(true);
        enviarArchivos.setEnabled(false);
        try {
            InputStream in = null;
            DataOutputStream out = null;
            sendNumFiles(files);
            TextAreaCliente.append("\nEnviando Archivos\n");
            TextAreaCliente.append("_________________________________________________________\n");
            int prom=100/files.length;
            int percent=0;
            for (int i = 0; i < files.length; i++){
                TextAreaCliente.append("Archivo"+(i+1)+":\n");
                files[i] = new File(files[i].getAbsolutePath());
                sendfiles(files[i], 4096, out, in);
                TextAreaCliente.append("ARCHIVO ENVIADO\n");
                TextAreaCliente.append("_________________________________________________________\n");
                percent+=prom;
            }
        } 
        catch (Exception e) {
        }
    }//GEN-LAST:event_enviarArchivosActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
       initClient();
       enviarArchivos.setEnabled(true);
       enviarNombres.setEnabled(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
TextAreaCliente.append("Cerrando conexión... \n");
        try 
        {
            sock.close();
            TextAreaCliente.append("Cerrada");
            
        } 
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            System.out.println(e.getMessage());
        } 
       System.exit(0);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed
    
    
    public int sendNames(File file, int bufferSize, DataOutputStream out, InputStream in){
        int count=0;
        int bytesSent = 0;
        long fileSize = 0;      
        byte[] byteBuffer = new byte[bufferSize];
        Socket socket;
        float porcentaje=0;float progreso=0;
        try{
            socket  = new Socket(host, puerto);
            out     = new DataOutputStream(socket.getOutputStream());
            in      = new FileInputStream(file);
            
            porcentaje=100/countArchivos;
            
            fileSize = file.length();
            TextAreaCliente.append("\tNombre: " +file.getName() +"\n");
            TextAreaCliente.append("\tTamaño: "+fileSize       +"\n");
            out.writeUTF(file.getName());
            out.writeLong(fileSize);
            count+=fileSize;
            socket.close();
            out.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    public int sendfiles(File file, int bufferSize, DataOutputStream out, InputStream in){
        int count=0;
        int bytesSent = 0;
        long fileSize = 0;      
        byte[] byteBuffer = new byte[bufferSize];
        Socket socket;
        float porcentaje=0;float progreso=0;
        try{
            socket  = new Socket(host, puerto);
            out     = new DataOutputStream(socket.getOutputStream());
            in      = new FileInputStream(file);
            
            porcentaje=100/countArchivos;
            
            fileSize = file.length();
            TextAreaCliente.append("\tNombre: " +file.getName() +"\n");
            TextAreaCliente.append("\tTamaño: "+fileSize       +"\n");
            TextAreaCliente.append("Enviando archivo...\n");
            out.writeUTF(file.getName());
            out.writeLong(fileSize);
            while ((bytesSent = in.read(byteBuffer)) > 0){
                out.write(byteBuffer, 0, bytesSent);
                progreso+=porcentaje;
            }
            TextAreaCliente.append("Se enviaron " + fileSize + " bytes.\n");
            count+=fileSize;
            socket.close();
            out.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    public void sendNumFiles(File[] files) throws IOException {
            Socket socket = new Socket(host, puerto);
            DataOutputStream out = null;
            out = new DataOutputStream(socket.getOutputStream());
            out.writeInt(files.length);
            out.close();
            socket.close();

    }
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
            java.util.logging.Logger.getLogger(ClienteAPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteAPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteAPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteAPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteAPP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JHost;
    private javax.swing.JTextArea TextAreaCliente;
    private javax.swing.JLabel archivosSelecionados;
    private javax.swing.JButton enviarArchivos;
    private javax.swing.JButton enviarNombres;
    private javax.swing.JButton escogerArchivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jPuerto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArchivosSelecionados;
    private javax.swing.JLabel lblElegir;
    // End of variables declaration//GEN-END:variables
}