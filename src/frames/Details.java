/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Model.GameMessages;
import Model.Knight;
import images.SeletorImagens;

/**
 *
 * @author Victor
 */
public class Details extends javax.swing.JFrame {

    private SeletorImagens imagem = new SeletorImagens();
    private GameMessages mensagem = new GameMessages();
    
    public Details() {
        initComponents();
    }
    
    public Details(Knight knight, int escolha){
        initComponents();
        
        jlKImagem.setIcon(imagem.determinaImagem(escolha));
        
        this.jlCharacter.setText(""+knight.getNome());
        this.jlAtaque.setText("Ataque: "+knight.getAtaque());
        this.jlDefesa.setText("Defesa: "+knight.getDefesa());
        this.jlEsquiva.setText("Esquiva: "+knight.getEsquiva());
        this.jlAtaqueEspecial.setText("Ataque Especial: "+knight.getNomeAtaqueEspecial());
        this.jtaDesc.append(mensagem.descricao(escolha));     
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlCharacter = new javax.swing.JLabel();
        jlAtaque = new javax.swing.JLabel();
        jlDefesa = new javax.swing.JLabel();
        jlEsquiva = new javax.swing.JLabel();
        jlAtaqueEspecial = new javax.swing.JLabel();
        jlDesc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDesc = new javax.swing.JTextArea();
        jlKImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jlCharacter.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jlCharacter.setText("#caracter");

        jlAtaque.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jlAtaque.setText("Ataque :");

        jlDefesa.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jlDefesa.setText("Defesa: ");

        jlEsquiva.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jlEsquiva.setText("Esquiva :");

        jlAtaqueEspecial.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jlAtaqueEspecial.setText("Ataque Especial :");

        jlDesc.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jlDesc.setText("Descrição :");

        jtaDesc.setEditable(false);
        jtaDesc.setColumns(20);
        jtaDesc.setFont(new java.awt.Font("Tempus Sans ITC", 0, 13)); // NOI18N
        jtaDesc.setRows(5);
        jScrollPane1.setViewportView(jtaDesc);

        jlKImagem.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlAtaque))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlDefesa))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlEsquiva))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlAtaqueEspecial))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlDesc))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jlCharacter)))
                        .addGap(0, 124, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jlKImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlCharacter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlKImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlAtaque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDefesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlEsquiva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlAtaqueEspecial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlAtaque;
    private javax.swing.JLabel jlAtaqueEspecial;
    private javax.swing.JLabel jlCharacter;
    private javax.swing.JLabel jlDefesa;
    private javax.swing.JLabel jlDesc;
    private javax.swing.JLabel jlEsquiva;
    private javax.swing.JLabel jlKImagem;
    private javax.swing.JTextArea jtaDesc;
    // End of variables declaration//GEN-END:variables
}
