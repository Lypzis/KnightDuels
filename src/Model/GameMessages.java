package Model;

import javax.swing.JOptionPane;

public class GameMessages {
    
    //alerta de validação;
    public void alerts(){     
        JOptionPane.showMessageDialog(null, "Faça uma escolha válida!");
    }
    
    public String round(int count){
        return "Turno "+count+":";
    }
    
    //alerta de vitória ou derrota;
    public void victoryAlert(boolean vencer){
        if(vencer)
            JOptionPane.showMessageDialog(null, "Parabéns! Você venceu!\n\nVerifique o log para detalhes da batalha.");
        else
            JOptionPane.showMessageDialog(null, "Você perdeu. Tente novamente!\n\nVerifique o log para detalhes da batalha.");
    }
    
    public String logLines(int escolha, Knight knight1, Knight knight2, double dano1, double dano2){
        String mensagem = "";
        
        switch(escolha){
            case 1:
                mensagem+= knight1.getNome()+" atacou causando "+dano1+" e "+knight2.getNome()+" atacou "
                        + " causando "+dano2;
                break;
            case 2:
                mensagem+= knight1.getNome()+" atacou causando "+dano1+" e "+knight2.getNome()+" defendeu "
                        + "causando "+dano2;
                break;
            case 3:
                mensagem+= knight1.getNome()+" atacou causando "+dano1+" e "+knight2.getNome()+" esquivou "
                        + "causando "+dano2;
                break;
            case 4:
                mensagem+= knight1.getNome()+" defendeu causando "+dano1+" e "+knight2.getNome()+" atacou "
                        + "causando "+dano2;
                break;
            case 5:
                mensagem+= knight1.getNome()+" defendeu causando "+dano1+" e "+knight2.getNome()+" defendeu "
                        + "causando "+dano2;
                break;
            case 6:
                mensagem+= knight1.getNome()+" defendeu causando "+dano1+" e "+knight2.getNome()+" esquivou "
                        + "causando "+dano2;
                break;
            case 7:
                mensagem+= knight1.getNome()+" esquivou causando "+dano1+" e "+knight2.getNome()+" atacou "
                        + "causando "+dano2;
                break;
            case 8:
                mensagem+= knight1.getNome()+" esquivou causando "+dano1+" e "+knight2.getNome()+" defendeu "
                        + "causando "+dano2;
                break;
            case 9:
                mensagem+= knight1.getNome()+" esquivou causando "+dano1+" e "+knight2.getNome()+" esquivou "
                        + "causando "+dano2;
                break;          
        }
        
        return mensagem;
    }
    
    public String specialAtackLogLine(int escolha, String movimento, Knight knight1, Knight knight2, double dano1, double dano2){
        String mensagem = "";
        
        switch(escolha){
            case 1:
                mensagem+= knight1.getNome()+" usou "+knight1.getNomeAtaqueEspecial()+" "
                        + "causando "+dano1+" e "+knight2.getNome()+" usou "+movimento+" causando "+dano2;
                break;
            case 2:
                mensagem+= knight2.getNome()+" usou "+knight2.getNomeAtaqueEspecial()+" "
                        + "causando "+dano2+" e "+knight1.getNome()+" usou "+movimento+" causando "+dano1;
                break;
        }
            
        return mensagem;
    }
    
    public String ramainingHealt(int health, int health2, Knight knight1, Knight knight2){
        String mensagem = "";
        
        mensagem+="Fim do Turno: "+knight1.getNome()+" possui vida = "+health+" e "+knight2.getNome()+""
                + " possui vida = "+health2;
        
        return mensagem;
    }
    
    public String startingHealth(int health, int health2, Knight knight1, Knight knight2){
        String mensagem = "";
        
        mensagem+="Início do Turno: "+knight1.getNome()+" possui vida = "+health+" e "+knight2.getNome()+""
                + " possui vida = "+health2;
        
        return mensagem;
    }
    
    public String descricao(int escolha){  
        switch(escolha){
            case 1:
                return "Bom... , se ele usou aquele poder, significa\nque não exatamente se tornou cinzas ainda.";
      
            case 2:
                return "Adora ir a execuções públicas,\npois ele é o carrasco.";

            case 3:
                return "As vezes é difícil se esconder tendo\n tantos detalhes nas roupas.";
               
            case 4:
                return "Nunca deixe se enganar pelo tamanho do escudo!";
                
        }
       
        return null;
    }
    
}
