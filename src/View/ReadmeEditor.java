/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import exerciceexplorer.Exercice;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JMenuBar;

/**
 *
 * @author mbrebion
 */
public class ReadmeEditor extends javax.swing.JPanel implements Observer {

    /**
     * Creates new form SubjectEditor
     */
    protected Exercice ex;

    public ReadmeEditor() {
        initComponents();
    }

    public ReadmeEditor(Exercice ex) {
        initComponents();
        this.ex = ex;
        this.textEditorBinded1.bindToFile(ex.getReadmePath());
        this.textEditorBinded1.addObserver(this);
        
        this.countLabel.setText("" + ex.getCountGiven());
        this.dateLabel.setText(ex.getLastEntry());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textEditorBinded1 = new View.TextEditorBinded();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        countLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());
        add(textEditorBinded1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Dernière fois :");
        jPanel1.add(jLabel1);

        dateLabel.setText("N.A.");
        jPanel1.add(dateLabel);

        jLabel3.setText("           ");
        jPanel1.add(jLabel3);

        jLabel4.setText("En tout :");
        jPanel1.add(jLabel4);

        countLabel.setText("0 ");
        jPanel1.add(countLabel);

        jLabel6.setText("fois");
        jPanel1.add(jLabel6);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private View.TextEditorBinded textEditorBinded1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        ex.NotifyReadmeChanged();
    }

    public void saveFile() {
        this.textEditorBinded1.saveFile();
    }

    public boolean needSaving() {
        return this.textEditorBinded1.hasChanged();
    }

    public void setMenuBar(JMenuBar jmb) {
        this.textEditorBinded1.setMenuBar(jmb);
    }

    public void updateMenuBarView() {
        this.textEditorBinded1.updateMenuBarView();
    }

}
