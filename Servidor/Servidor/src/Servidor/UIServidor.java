package Servidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;
public class UIServidor extends javax.swing.JFrame {
    private int puerto = 9000;
    private Socket sc;
    private ServerSocket serversc;
    private DataOutputStream salida;
    private BufferedReader entrada;

    public void setPuerto(int puerto){
        this.puerto=puerto;
    }
    public UIServidor() {
        initComponents(); 
    }
    
    public void initServer(){    
        textAreaServer.setText("");
        try{
            setPuerto( Integer.parseInt(jPuerto.getText()) );
            serversc = new ServerSocket(puerto);
            sc=new Socket();
            sc = serversc.accept();
            salida = new DataOutputStream(sc.getOutputStream());
            entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            salida.writeUTF("*****LA CONEXIÓN CON EL CLIENTE SE HA ESTABLECIDO***** \n");
            textAreaServer.append(entrada.readLine() + "\n");
            textAreaServer.append("-Esperando archivos del cliente... \n"); 
            sc.close();
            serversc.close();
        }
        catch(Exception e ){
            JOptionPane.showMessageDialog( null, "Error: " + e.getMessage() );
            System.out.println(e.getMessage());
        }
    }

    public void recibirNombres(int pto){
        DataInputStream in= null;
        
        int bytesRcvd     = 0;     
        byte[] byteBuffer = null;   
        String fileName   = null;   
        long fileSize     = 0;     
        long count        = 0;      
        int numFiles      = 0;    
        float porcentaje  = 0;
        try{
            byteBuffer = new byte[4096];       
            serversc   = new ServerSocket(pto); 
            sc = new Socket();                    
            sc = serversc.accept();
            in = new DataInputStream(sc.getInputStream()); 
            numFiles = in.readInt();                       
            in.close();                                    
            sc.close();
            textAreaServer.append("_________________________________________________________\n");
            textAreaServer.append("Archivos a recibir: " + numFiles + " \n");
            textAreaServer.append("_________________________________________________________\n");
            porcentaje=(100/(numFiles) );

            for (int j = 0; j < numFiles; j++){
                sc = serversc.accept();
                in = new DataInputStream(sc.getInputStream());
                fileName = in.readUTF();
                fileSize = in.readLong();
                System.out.println("Extensión:"+getExt(fileName));
                textAreaServer.append("Archivo a Recibir: " 
                                    +fileName + "\n\tExtension: " + getExt(fileName)+ "\n\tTamaño: " +fileSize+ " Bytes.\n");
                in.close();
            }
            textAreaServer.append("_________________________________________________________\n");
            sc.close();
            serversc.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }    
    public String getExt(String n){
        String s="";
        for(int i=n.length()-1;i>=0;i--){
            if(n.charAt(i)=='.'){
                s=n.substring(i,n.length());
                break;
            }
        }
        return s;
    }
    public void recibirArchivos(int pto){
        DataInputStream in= null; 
        OutputStream  out = null; 
        int bytesRcvd     = 0;      
        byte[] byteBuffer = null;   
        String fileName   = null;   
        long fileSize     = 0;      
        long count        = 0;      
        int numFiles      = 0;      
        float porcentaje  = 0;
        int progreso=0;
        
        try{
            long cuenta=0;
            byteBuffer = new byte[4096];                  
            serversc   = new ServerSocket(pto);           
            sc = new Socket();                    
            sc = serversc.accept();
            in = new DataInputStream(sc.getInputStream());
            numFiles = in.readInt();                      
            in.close();                                  
            sc.close();
            textAreaServer.append("_________________________________________________________\n");           
            porcentaje=(100/(numFiles) );
            for (int j = 0; j < numFiles; j++){
                sc = serversc.accept();
                in = new DataInputStream(sc.getInputStream());
                fileName = in.readUTF();
                fileSize = in.readLong();
                textAreaServer.append("Recibiendo archivo: " +fileName+ "\n\t      Tamaño: " +fileSize+ " Bytes.\n");
                System.out.println("Recibiendo archivo: " +fileName+ "\n\t      Tamaño: " +fileSize+ " Bytes.\n");
                out = new FileOutputStream(fileName);
                textAreaServer.append("ARCHIVO RECIBIDO\n");
                progreso+=porcentaje;
                textAreaServer.append("Progreso:");
                recibirDatos(progreso, bytesRcvd, count, in, out,byteBuffer);
                textAreaServer.append("_________________________________________________________\n");
                out.close();
                in.close();
                cuenta+=cuenta+fileSize;
            }
            
            System.out.println("BytesF"+cuenta);
            System.out.println("porcentaje:"+progreso);
            textAreaServer.append("Se recibieron: " + cuenta + " bytes.\n");
            textAreaServer.append("_________________________________________________________\n\n");
            sc.close();
            serversc.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void recibirDatos(int progreso,int bytesRcvd,long count,DataInputStream in,OutputStream out,byte[] byteBuffer){
        try{
            while ( ( bytesRcvd = in.read(byteBuffer) ) != -1) {
                out.write(byteBuffer, 0, bytesRcvd);
                count += bytesRcvd;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        textAreaServer.append("\t"+progreso+"%\n");
        System.out.println("porcentaje:"+progreso);
        System.out.println("Bytes:"+count);
    }
    
    /*NetBeans*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaServer = new javax.swing.JTextArea();
        cerrarSocket = new javax.swing.JButton();
        recibirNombres = new javax.swing.JButton();
        recibirMas = new javax.swing.JButton();
        jPuerto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        recibirArchivos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interfáz Servidor");
        setUndecorated(true);

        textAreaServer.setColumns(20);
        textAreaServer.setRows(5);
        jScrollPane1.setViewportView(textAreaServer);
        textAreaServer.getAccessibleContext().setAccessibleName("");
        textAreaServer.getAccessibleContext().setAccessibleDescription("");

        cerrarSocket.setText("Cerrar Conexion");
        cerrarSocket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSocketActionPerformed(evt);
            }
        });

        recibirNombres.setText("Recibir Nombres");
        recibirNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recibirNombresActionPerformed(evt);
            }
        });

        recibirMas.setText("Recargar");
        recibirMas.setEnabled(false);
        recibirMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recibirMasActionPerformed(evt);
            }
        });

        jPuerto.setText("9000");
        jPuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPuertoActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Puerto de escucha");

        recibirArchivos.setText("Recibir Archivos");
        recibirArchivos.setEnabled(false);
        recibirArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recibirArchivosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Servidor");

        jMenu1.setText("Iniciar Conexión");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cerrar Programa");
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
                        .addGap(103, 103, 103)
                        .addComponent(cerrarSocket, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(recibirNombres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recibirArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(recibirMas, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recibirNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recibirArchivos)
                    .addComponent(recibirMas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(cerrarSocket)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarSocketActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_cerrarSocketActionPerformed
        textAreaServer.setText("");
        try{
            sc.close();
            textAreaServer.append("Cerrando conexión... \n");
            serversc.close();
            textAreaServer.append("Conexión cerrada. \n");
           
        }
        /*Mensaje de Error*/
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_cerrarSocketActionPerformed

    private void recibirNombresActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_recibirNombresActionPerformed

        recibirNombres(Integer.parseInt(jPuerto.getText()));
        recibirNombres.setEnabled(false);
        recibirArchivos.setEnabled(true);
        recibirMas.setEnabled(false);
    }//GEN-LAST:event_recibirNombresActionPerformed

    private void recibirMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recibirMasActionPerformed
        recibirNombres.setEnabled(true);
        recibirMas.setEnabled(false);
    }//GEN-LAST:event_recibirMasActionPerformed

    private void recibirArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recibirArchivosActionPerformed

        recibirArchivos(Integer.parseInt(jPuerto.getText()));
        recibirArchivos.setEnabled(false);
        recibirMas.setEnabled(true);
    }//GEN-LAST:event_recibirArchivosActionPerformed

    private void jPuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPuertoActionPerformed
        
    }//GEN-LAST:event_jPuertoActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        textAreaServer.append("Esperando una conexión: \n");
        initServer();
        recibirNombres.setVisible(true);
        recibirMas.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenu2MouseClicked

    /*Netbeans*/
    public static void main(String args[]){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try{
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if ("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch (ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(UIServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex){
            java.util.logging.Logger.getLogger(UIServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex){
            java.util.logging.Logger.getLogger(UIServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex){
            java.util.logging.Logger.getLogger(UIServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new UIServidor().setVisible(true);
            }
        });
    }
    private Timer timer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrarSocket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jPuerto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton recibirArchivos;
    private javax.swing.JButton recibirMas;
    private javax.swing.JButton recibirNombres;
    private javax.swing.JTextArea textAreaServer;
    // End of variables declaration//GEN-END:variables
}
