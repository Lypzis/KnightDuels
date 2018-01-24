package images;

import javax.swing.ImageIcon;

public class SeletorImagens {
    
    public ImageIcon determinaImagem(int escolha){
        switch(escolha){
            case 0:
                return new ImageIcon(getClass().getResource("/images/Interrogação.png"));
            case 1:
                return new ImageIcon(getClass().getResource("/images/Durak.jpg")); 
            case 2:
                return new ImageIcon(getClass().getResource("/images/Harkon.jpg"));
            case 3:
                return new ImageIcon(getClass().getResource("/images/Isran.jpg"));
            case 4:
                return new ImageIcon(getClass().getResource("/images/Soggoth.jpg"));
        }
        
        return null;
    }
    
}
