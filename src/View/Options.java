/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Helper.ExecCommand;
import Helper.GitWrapper;
import Helper.SavedVariables;

/**
 *
 * @author mbrebion
 */
public class Options extends javax.swing.JPanel {

    /**
     * Creates new form Options
     */
    protected MainWindow mw;

    public Options() {
        initComponents();

    }

    public void setMw(MainWindow mw) {
        this.mw = mw;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        pdflatexInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        openInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        gitFolderInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        templatesFolderInput = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        outputDirInput = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        commitButton = new javax.swing.JButton();
        pushButton = new javax.swing.JButton();
        pullButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        statusButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputView = new javax.swing.JTextArea();
        jCheckBox2 = new javax.swing.JCheckBox();

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel3.setText("Options");

        jLabel1.setText("pdflatex");

        pdflatexInput.setText(SavedVariables.getPdflatexCmd()
        );
        pdflatexInput.setToolTipText("Chemin d'acces (absolu) vers l'executable pdflatex");
        pdflatexInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdflatexInputActionPerformed(evt);
            }
        });

        jLabel2.setText("open");

        openInput.setText(SavedVariables.getOpenCmd());
        openInput.setToolTipText("Chemin d'acces (absolu) vers la commande open");
        openInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openInputActionPerformed(evt);
            }
        });

        jLabel4.setText("dossier git");

        gitFolderInput.setText(SavedVariables.getMainGitDir());
        gitFolderInput.setToolTipText("Chemin d'acces (absolu) vers le dossier contenant le repository git local");
        gitFolderInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gitFolderInputActionPerformed(evt);
            }
        });

        jLabel5.setText("dossier modèles");

        templatesFolderInput.setText(SavedVariables.getTexModelsPaths());
        templatesFolderInput.setToolTipText("<html>\nChemin d'acces (absolu) vers le dossier contenant les templates latex :\n<ul>\n    <li> DSModel.tex  </li>\n    <li> DMModel.tex  </li>\n    <li> ColleModel.tex  </li>\n    <li> TDModel.tex  </li>\n</ul>\nCes documents servent de template pour l'unclusion des exercices et doivent inclure le fichier fichiers_utiles/raccourcis_communs.sty et contenir une ligne : <br>\n****\n<br> \nqui sera remplacée par l'import des exercice lors de l'édition d'une composition.\n<br>\n<br>\nUn exemple de fichier se trouve dans le répertoire path/To/Git/Dir/fichiers_utiles/defaultLatexTemplates\n</html>");
        templatesFolderInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                templatesFolderInputActionPerformed(evt);
            }
        });

        jCheckBox1.setSelected(SavedVariables.getAutoSave());
        jCheckBox1.setText("Sauvegarde auto");
        jCheckBox1.setToolTipText("<html>\nLes fichiers sont <em>automatiquement</em> sauvegardés quand les onglets sont cachés.\n<br>\nCela peut être utile lorsque vous selectionnez un nouvel exercice (l'ancien disparait).\n</html>");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel6.setText("dossier d'export");

        outputDirInput.setText(SavedVariables.getOutputDir());
        outputDirInput.setToolTipText("<html>\nChemin d'acces (absolu) vers le dossier contenant vos DS/DM de l'année en cours. <br>\nCe dossier doit contenir un sous dossier nommé DM et un autre nommé DS. <br>\nAinsi, une composition type DS exportée sera placé dans le sous dossier DS de manière incrémentielle (exemple DS5 si un dossier DS4 est déjà présent).\n</html>");
        outputDirInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputDirInputActionPerformed(evt);
            }
        });

        commitButton.setText("Commit");
        commitButton.setToolTipText("Réalise un commit du repo git. Les fichiers existant et modifiés sont automatiqument ajoutés.");
        commitButton.setEnabled(false);
        commitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commitButtonActionPerformed(evt);
            }
        });

        pushButton.setText("Push");
        pushButton.setToolTipText("<html>\nEnvoie le dernier commit sur le serveur. \n<br>\nLes conflits n'étant pas gérés à partir de l'interface graphique. Il faudra dans ce cas utiliser un logiciel dédié ou bien le terminal.\n</html>");
        pushButton.setEnabled(false);
        pushButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pushButtonActionPerformed(evt);
            }
        });

        pullButton.setText("Pull");
        pullButton.setToolTipText("Réccupère les nouvelles données depuis le serveur.");
        pullButton.setEnabled(false);
        pullButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pullButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        jLabel7.setText("Git :");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        jLabel8.setText("Chemins d'accès :");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        jLabel9.setText("Actions :");

        statusButton.setText("Status");
        statusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusButtonActionPerformed(evt);
            }
        });

        outputView.setEditable(false);
        outputView.setBackground(javax.swing.UIManager.getDefaults().getColor("ProgressBar.background"));
        outputView.setColumns(16);
        outputView.setRows(5);
        outputView.setTabSize(4);
        outputView.setText("click on status to update");
        jScrollPane1.setViewportView(outputView);

        jCheckBox2.setSelected(SavedVariables.getMultiEdit());
        jCheckBox2.setText("multi-edition");
        jCheckBox2.setToolTipText("<html> Permet d'activer le mode <em>multi-edition</em> <br> \nqui permet de modifier simultanément plusieurs exercices <br>\n(find and replace) sur les mots clefs ou bien des expressions présentes <br>\ndans les fichiers sujet.tex\n</html>");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(statusButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 23, Short.MAX_VALUE)
                                .addComponent(commitButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 23, Short.MAX_VALUE)
                                .addComponent(pushButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 35, Short.MAX_VALUE)
                        .addComponent(pullButton)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(templatesFolderInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(gitFolderInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(openInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pdflatexInput, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(7, 7, 7)
                                .addComponent(outputDirInput))
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jCheckBox1)
                                        .addGap(55, 55, 55)
                                        .addComponent(jCheckBox2)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(3, 3, 3))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pdflatexInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(openInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(gitFolderInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(templatesFolderInput, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputDirInput, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commitButton)
                    .addComponent(pushButton)
                    .addComponent(pullButton)
                    .addComponent(statusButton))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void templatesFolderInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_templatesFolderInputActionPerformed
        SavedVariables.setTexModelsPaths(templatesFolderInput.getText());
    }//GEN-LAST:event_templatesFolderInputActionPerformed

    private void pdflatexInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdflatexInputActionPerformed
        SavedVariables.setPdflatexCmd(pdflatexInput.getText());
    }//GEN-LAST:event_pdflatexInputActionPerformed

    private void gitFolderInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gitFolderInputActionPerformed
        SavedVariables.setMainGitDir(gitFolderInput.getText());
    }//GEN-LAST:event_gitFolderInputActionPerformed

    private void openInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openInputActionPerformed
        SavedVariables.setOpenCmd(openInput.getText());
    }//GEN-LAST:event_openInputActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        SavedVariables.setAutoSave(jCheckBox1.isSelected());
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void outputDirInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputDirInputActionPerformed
        SavedVariables.setOutputDir(outputDirInput.getText());
    }//GEN-LAST:event_outputDirInputActionPerformed

    private void pushButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pushButtonActionPerformed
        GitWrapper.push();
        this.outputView.setText("commit pushed to remote repository");
        String status=GitWrapper.status();
        this.checkStatus(status);
        this.outputView.append("\n - - - - - - -\n"+status);
    }//GEN-LAST:event_pushButtonActionPerformed

    private void commitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commitButtonActionPerformed
        String out = GitWrapper.commit();
        this.outputView.setText(out);
        String status=GitWrapper.status();
        this.checkStatus(status);
        this.outputView.append("\n - - - - - - -\n"+status);
        
    }//GEN-LAST:event_commitButtonActionPerformed

    private void pullButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pullButtonActionPerformed
        String out = GitWrapper.pull();
        if (out.contains("CONFLICT")){
            this.outputView.setText("Le même fichier à été modifié à la fois dans le répertoire local et sur le serveur (surement par un autre utlisateur). \n Ce cas n'est pas géré depuis l'interface graphique. \n Effectuez un git pull depuis le terminal, identifiez les conflit à l'aide de git diff, corrigez les, puis effectuez un git commit suivi d'un git push");
        }else{
            this.outputView.setText(out);
        }
        
        String status=GitWrapper.status();
        this.checkStatus(status);
        this.outputView.append("\n - - - - - - -\n \n"+status);
        
    }//GEN-LAST:event_pullButtonActionPerformed

    private void checkStatus(String in) {

        this.commitButton.setEnabled(false);
        this.pushButton.setEnabled(false);
        this.pullButton.setEnabled(false);
        
        if (in.contains("nothing to commit")) {

            if (in.contains("Your branch is behind")) {
                // we can push safely : 
                this.pullButton.setEnabled(true);
            } 
            if (in.contains("Your branch is ahead of")) {
                // we can push safely : 
                this.pushButton.setEnabled(true);
            }
            if (in.contains("have diverged,")){
                this.pullButton.setEnabled(true);
            }

        } else {
            // new changes are not commited, we must commit first
            this.commitButton.setEnabled(true);
            
        }

    }
    private void statusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusButtonActionPerformed
        String out = GitWrapper.status();
        this.outputView.setText(out);
        this.checkStatus(out);
    }//GEN-LAST:event_statusButtonActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        SavedVariables.setMultiEdit(jCheckBox2.isSelected());
        this.mw.updateGlobalMenuBarStatus();
    }//GEN-LAST:event_jCheckBox2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton commitButton;
    private javax.swing.JTextField gitFolderInput;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField openInput;
    private javax.swing.JTextField outputDirInput;
    private javax.swing.JTextArea outputView;
    private javax.swing.JTextField pdflatexInput;
    private javax.swing.JButton pullButton;
    private javax.swing.JButton pushButton;
    private javax.swing.JButton statusButton;
    private javax.swing.JTextField templatesFolderInput;
    // End of variables declaration//GEN-END:variables
}
