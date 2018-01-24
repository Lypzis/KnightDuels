package frames;

import Model.GameMessages;
import Model.Knight;
import images.SeletorImagens;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public final class Battle extends javax.swing.JFrame {

    /**
     * Creates new form Battle
     */
    private Knight knight; //cria os dois cavaleiros;
    private Knight knightRandom;
    private Random number = new Random(); //gerador de números aleatórios;
    private GameMessages gameMessages = new GameMessages();
    private SeletorImagens imagens = new SeletorImagens();
    private int knightHp; //configurar pontos de vida;
    private int knightRandomHp;
    private double damageKnight; //configurar danos;
    private double damageKnightRandom;
    private String nomeMovimentoA; //nome do golpe usados por cada um;
    private String nomeMovimentoB;
    private String logMessage; //define o texto final para verificar detalhes da batalha;
    private boolean cura;
    
    public Battle() {
        initComponents();
    }
    
    //construtor configurado;
    public Battle(Knight knight, Knight knightRandom, int imagem, int imagemAI){ //recebe 2 cavaleiros pré configurados;
        initComponents();
        
        //configura imagens;
        jlKnight.setIcon(imagens.determinaImagem(imagem));
        jlKnightAI.setIcon(imagens.determinaImagem(imagemAI));
        
        //configura os criados na instância;
        this.knight = knight; 
        this.knightRandom = knightRandom;
        
        //nome demonstrativos;
        this.jlNameCharacter2.setText(knightRandom.getNome());
        this.jlNameCharacter1.setText(knight.getNome()); 
        
        //configura o hp de cada um para 500;
        knightHp = 500;
        knightRandomHp = 500;
        
        //dá inicio ao jogo;
        iniciarBatalha();
    }
    
    //loop do jogo;
    public void iniciarBatalha(){   
        int count = 1; //rounds;
        
        do{  
            //gerador de números aleatórios de acordo com o round, quando atinge 5, libera o ataque especial;
            int moveA = randomGenerator(count); 
            int moveB = randomGenerator(count);
            
            //configura valor às variaveis de dano de acordo com o número(move) que cair;
            damageKnight = atribuiForça(moveA, knight);
            damageKnightRandom = atribuiForça(moveB, knightRandom);
            
            //requisito para comparar os valores(incrementos ou decrementos de dano), dando nome aos golpes;
            nomeMovimentoA = identificadorGolpe(moveA);
            nomeMovimentoB = identificadorGolpe(moveB);        
            
            //cria a mensagem do round para o log, início;
            jtaLogBatalha.append(gameMessages.round(count)+"\n"+
                    gameMessages.startingHealth(knightHp, knightRandomHp, knight, knightRandom)+"\n");
            
            //quanto de dano cada um fez ao outro no turno;
            causarDano(damageKnight, damageKnightRandom);
            
            //cria a mensagem do round para o log, fim;
            jtaLogBatalha.append(logMessage+"\n"
                    +gameMessages.ramainingHealt(knightHp, knightRandomHp, knight, knightRandom)+"\n\n");
            
            ++count;
        }while(knightHp > 0 && knightRandomHp > 0); //continua até alguem atingir 0 ou menos pontos de vida;
        
            //mostra quem venceu;
            if(knightHp > knightRandomHp)
                gameMessages.victoryAlert(true);
            else
                gameMessages.victoryAlert(false);
    }
    
    //gerador de aletórios;
    public int randomGenerator(int count){
        int randomN = number.nextInt(3)+1; //do 1 a 3;
    
        if (count>=5) //quando chegar no 5º round;
            randomN = number.nextInt(4)+1; //do 1 a 4;
        
        return randomN;
    }
    
    //configura o valor ataque, defesa, esquiva ou ataque especial;
    public double atribuiForça(int randomNumber, Knight knight){
        double value = 0;
        
        switch(randomNumber){       
            case 1:
                value = knight.getAtaque();
                break;
            case 2:
                value = knight.getDefesa();
                break;
            case 3:
                value = knight.getEsquiva();
                break;
            case 4:
                value = knight.getAtaqueEspecial();
                break;
        }
        
        return value;
    }
    
    //identifica um golpe para um cavaleiro;
    public String identificadorGolpe(int move){     
        switch(move){
            case 1:
                return  "ataque";              
            case 2:
                return "defesa";               
            case 3:
                return  "esquiva";              
            case 4:
                return  "ataque especial";              
        }
        
        return null;
    }
    
    public void causarDano(double knightV, double knightRandomV){
        double danoA = knightV;
        double danoB = knightRandomV;
        
        logMessage = "";
        
        //ataque X ataque;
        if(nomeMovimentoA.equals("ataque") && nomeMovimentoB.equals("ataque")){
            danoA = knightV; //danos permanecem com o mesmo valor;
            danoB = knightRandomV;
            logMessage = gameMessages.logLines(1, knight, knightRandom, danoA, danoB);
        }
        //ataque X defesa;
        else if(nomeMovimentoA.equals("ataque") && nomeMovimentoB.equals("defesa")){ 
            danoA = knightRandomV - knightV; //dano de A decrementado;
            danoA = damageAdjusted(danoA);
            danoB = knightRandomV; //dano de B permanece o mesmo;
            logMessage = gameMessages.logLines(2, knight, knightRandom, danoA, danoB);
        }
        //ataque X esquiva; 
        else if (nomeMovimentoA.equals("ataque") && nomeMovimentoB.equals("esquiva")){
            danoA = 0; //dano de A zera;
            danoB = knightRandomV - knightV; //dano de B decrementado;
            danoB = damageAdjusted(danoB);
            logMessage = gameMessages.logLines(3, knight, knightRandom, danoA, danoB);
        }
        //defesa X ataque;
        else if (nomeMovimentoA.equals("defesa") && nomeMovimentoB.equals("ataque")){
            danoA = knightRandomV; //dano de A permanece o mesmo;
            danoB = knightV - knightRandomV; //dano de B decrementado;
            danoB = damageAdjusted(danoB);
            logMessage = gameMessages.logLines(4, knight, knightRandom, danoA, danoB);
        }
        //defesa X defesa;
        else if(nomeMovimentoA.equals("defesa") && nomeMovimentoB.equals("defesa")){
            danoA = 0; 
            danoB = 0;
            logMessage = gameMessages.logLines(5, knight, knightRandom, danoA, danoB);
        }
        //defesa X esquiva;
        else if(nomeMovimentoA.equals("defesa") && nomeMovimentoB.equals("esquiva")){
            danoA = 0;
            danoB = 0;
            logMessage = gameMessages.logLines(6, knight, knightRandom, danoA, danoB);
        }
        //esquiva X ataque;
        else if(nomeMovimentoA.equals("esquiva") && nomeMovimentoB.equals("ataque")){
            danoB = 0;
            danoA = knightV - knightRandomV;
            danoA = damageAdjusted(danoA);
            logMessage = gameMessages.logLines(7, knight, knightRandom, danoA, danoB);           
        }
        //esquiva X defesa;
        else if(nomeMovimentoA.equals("esquiva") && nomeMovimentoB.equals("defesa")){
            danoB = 0;
            danoA = 0;
            logMessage = gameMessages.logLines(8, knight, knightRandom, danoA, danoB);
        }    
        //esquiva X esquiva;
        else if(nomeMovimentoA.equals("esquiva") && nomeMovimentoB.equals("esquiva")){
            danoB = 0;
            danoA = 0;
            logMessage = gameMessages.logLines(9, knight, knightRandom, danoA, danoB);
        }
        else if(nomeMovimentoA.equals("ataque especial")){
            danoA = ataqueEspecial(knight, 1);
            logMessage = gameMessages.specialAtackLogLine(1, nomeMovimentoB, knight, knightRandom, danoA, danoB);
            
            if(cura){
                danoB *= -1;
                danoA = 0;
            }
        }        
        else if(nomeMovimentoB.equals("ataque especial")){
            danoB = ataqueEspecial(knightRandom, 2);
            logMessage = gameMessages.specialAtackLogLine(2, nomeMovimentoA, knight, knightRandom, danoA, danoB);
            
            if(cura){
                danoA *= -1;
                danoB = 0;
            }
        }
       
        //resultados;
        knightHp -= danoB;
        knightRandomHp -=  danoA;
        
        cura = false;
    }
    
    //definição de valor do ataque especial, necessário identificação;
    public double ataqueEspecial(Knight knight, int aOuB){
        int id = knight.getIDKNIGHT();
        double dano = 0;
        int chance = number.nextInt(10)+1;
        
        
        //vindo do cavaleiro escolhido ou do aleatório;
        switch(aOuB){
                     
            case 1:
                //cada cavaleiro possui um ataque especial único que pode acabar usando a força do adversário;
            switch(id){
                case 1:
                    dano = knight.getAtaqueEspecial() + damageKnightRandom; //necessário saber o dano;
                    cura = true;
                    break;

                case 2:
                    dano = knight.getAtaqueEspecial();
                    if(chance >= 8){
                        dano = knight.getAtaqueEspecial() * 2;
                    }
                    break;

                case 3:
                    dano = knight.getAtaqueEspecial();
                    break;

                case 4:
                    dano = knight.getAtaqueEspecial() + damageKnightRandom * 3;
                    break;
            }
            break;
                
            case 2:
                switch(id){
                case 1:
                    dano = knight.getAtaqueEspecial() + damageKnight;
                    cura = true;
                    break;

                case 2:
                    dano = knight.getAtaqueEspecial();
                    if(chance >= 8){
                        dano = knight.getAtaqueEspecial() * 2;
                    }
                    break;

                case 3:
                    dano = knight.getAtaqueEspecial();
                    break;

                case 4:
                    dano = knight.getAtaqueEspecial() + damageKnight * 3;
                    break;
                }
        }
       return dano;
    }
    
    //resolver danos negativos indevidos;
    public double damageAdjusted(double damage){
        if(damage < 0)
            damage *= -1;
        
        return damage;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlPlayer1 = new javax.swing.JLabel();
        jlPlayer2 = new javax.swing.JLabel();
        jlNameCharacter2 = new javax.swing.JLabel();
        jlNameCharacter1 = new javax.swing.JLabel();
        jlBatalhaLog = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaLogBatalha = new javax.swing.JTextArea();
        jlKnightAI = new javax.swing.JLabel();
        jlKnight = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jlPlayer1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jlPlayer1.setText("jogador");

        jlPlayer2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jlPlayer2.setText("AI");

        jlNameCharacter2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jlNameCharacter2.setText("character 2");

        jlNameCharacter1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jlNameCharacter1.setText("character 1");

        jlBatalhaLog.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jlBatalhaLog.setText("Battle log:");

        jtaLogBatalha.setEditable(false);
        jtaLogBatalha.setColumns(20);
        jtaLogBatalha.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jtaLogBatalha.setRows(5);
        jScrollPane1.setViewportView(jtaLogBatalha);

        jlKnightAI.setText("jLabel1");

        jlKnight.setText("jLabel2");

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel1.setText("VS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jlBatalhaLog)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jlPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlNameCharacter1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(213, 213, 213)
                                .addComponent(jlNameCharacter2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlKnight, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(jlKnightAI, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlKnight, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlKnightAI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNameCharacter2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNameCharacter1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlBatalhaLog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
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
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Battle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlBatalhaLog;
    private javax.swing.JLabel jlKnight;
    private javax.swing.JLabel jlKnightAI;
    private javax.swing.JLabel jlNameCharacter1;
    private javax.swing.JLabel jlNameCharacter2;
    private javax.swing.JLabel jlPlayer1;
    private javax.swing.JLabel jlPlayer2;
    private javax.swing.JTextArea jtaLogBatalha;
    // End of variables declaration//GEN-END:variables
}
