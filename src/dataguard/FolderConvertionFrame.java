package dataguard;

import crypto.CryptoConstants;
import crypto.CryptoTools;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Amir Aslan Aslani
 */
public class FolderConvertionFrame extends javax.swing.JFrame {

    /**
     * Creates new form FileConvertionFrame
     */
    public FolderConvertionFrame() {
        initComponents();
        
        ComboBoxModel<String> cbm = new DefaultComboBoxModel<>(CryptoConstants.CRYPTO);
        algorithm.setModel(cbm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        selectSourceFolder = new javax.swing.JButton();
        sourceText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        actionType = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        doAction = new javax.swing.JButton();
        cipherText = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        algorithm = new javax.swing.JComboBox<>();
        jProgressBar1 = new javax.swing.JProgressBar();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aslan File Convertion Tool :o");
        setMaximumSize(new java.awt.Dimension(2147483647, 145));
        setMinimumSize(new java.awt.Dimension(504, 145));
        setResizable(false);

        jLabel1.setText("Source Folder");

        selectSourceFolder.setText("Select Folders");
        selectSourceFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectSourceFolderActionPerformed(evt);
            }
        });

        sourceText.setEditable(false);

        jLabel6.setText("Personal Cipher");

        actionType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Encrypt", "Decrypt" }));

        jLabel7.setText("Action");

        doAction.setText("Run!");
        doAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doActionActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Algorithm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cipherText)
                    .addComponent(doAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sourceText)
                    .addComponent(actionType, javax.swing.GroupLayout.Alignment.TRAILING, 0, 308, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectSourceFolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(algorithm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectSourceFolder)
                    .addComponent(jLabel1)
                    .addComponent(sourceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(actionType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cipherText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doAction)
                    .addComponent(algorithm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("Aslan File Convertion Tool :o");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    JFileChooser fc = new JFileChooser();
    File sourceFile;
    private void selectSourceFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectSourceFolderActionPerformed
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.showOpenDialog(this);
        sourceFile = fc.getSelectedFile();
        
        if(sourceFile == null)
            return;
        
        sourceText.setText(sourceFile.getAbsolutePath());
    }//GEN-LAST:event_selectSourceFolderActionPerformed

    private void doActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doActionActionPerformed
        String cipher = cipherText.getText().trim();
        
        
        try{
        
            if(sourceFile == null || "".equals(sourceText.getText().trim())){
                JOptionPane.showMessageDialog(this, "Please select source folder!");
                return;
            }

            if(! sourceFile.isDirectory()){
                JOptionPane.showMessageDialog(this, "Please select correct source folder!");
                return;
            }
            
            if(cipher.length() <= 0){
                JOptionPane.showMessageDialog(this, "Please enter personal CIPHER!");
                return;
            }

            if(actionType.getSelectedIndex() == 0) // Encrypt
                doEncrypt(cipher);
            else if(actionType.getSelectedIndex() == 1) // Decrypt
                doDecrypt(cipher);

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_doActionActionPerformed

    private void doEncrypt(String key) throws FileNotFoundException, IOException, Exception{
        
        Stream<Path> paths = Files.walk(Paths.get(sourceText.getText().trim()));
        Stream<Path> filter = paths.filter(Files::isRegularFile);
                
        filter.forEach((path) -> {
            String sourceFile = path.toString();
            
            File sfile = new File(sourceFile);
            File dfile = new File(sourceFile);
            
            try {
                CryptoTools.fileEncrypt(algorithm.getSelectedIndex(), key, sfile, dfile);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
        
        JOptionPane.showMessageDialog(this, "Action was completed!");
    }
    
    private void doDecrypt(String key) throws FileNotFoundException, IOException, Exception{
        System.out.println("Decripted");
        Stream<Path> paths = Files.walk(Paths.get(sourceText.getText().trim()));
        Stream<Path> filter = paths.filter(Files::isRegularFile);
                
        filter.forEach((path) -> {
            String sourceFile = path.toString();
            
            File sfile = new File(sourceFile);
            File dfile = new File(sourceFile);
            
            try {
                CryptoTools.fileDecrypt(algorithm.getSelectedIndex(), key, sfile, dfile);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
        
        JOptionPane.showMessageDialog(this, "Action was completed!");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> actionType;
    private javax.swing.JComboBox<String> algorithm;
    private javax.swing.JPasswordField cipherText;
    private javax.swing.JButton doAction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JButton selectSourceFolder;
    private javax.swing.JTextField sourceText;
    // End of variables declaration//GEN-END:variables
}
