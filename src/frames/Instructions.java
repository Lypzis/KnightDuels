/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

/**
 *
 * @author Victor
 */
public class Instructions extends javax.swing.JFrame {

    /**
     * Creates new form Instructions
     */
    public Instructions() {
        initComponents();
        
        jtaInstructions.append("Bem vindo a Knights's Duels!\n\n"
                + "Clique em 'Iniciar' e escolha com a\n"
                + "caixa a direita uma das opções de cavaleiro,\n"
                + "você pode verificar o status de sua escolha\n"
                + "clicando em 'Detalhes' como: ataque(dano normal),\n"               
                + " defesa(baseia-se na força do adversário), \n"
                + "esquiva(quem usou recebe 0 de dano) e o ataque especial\n"
                + "disponível no turno 5, quem usa primeiro possui vantagem\n"
                + "e ele não sofre penalidade por efeitos descritos acima.\n "
                + "Após isso, clique em 'Iniciar Batalha'.\n"
                + "Logo aparece uma mensagem dizendo se você \n "
                + "ganhou ou perdeu e poderá verificar os\n "
                + "detalhes no 'log de batalha'.\n"
                + "No log aparecem os golpes usados, seu dano\n "
                + "e a vida restante dos cavaleiros em cada turno.\n");
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
        jlInstructions = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaInstructions = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jlInstructions.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jlInstructions.setText("Instruções:");

        jtaInstructions.setEditable(false);
        jtaInstructions.setColumns(20);
        jtaInstructions.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jtaInstructions.setRows(5);
        jScrollPane1.setViewportView(jtaInstructions);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Instructions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Instructions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Instructions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Instructions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Instructions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlInstructions;
    private javax.swing.JTextArea jtaInstructions;
    // End of variables declaration//GEN-END:variables
}