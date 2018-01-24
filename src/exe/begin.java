package exe;

import frames.Start;

public class begin {
    
    public static void main(String[] args) {     
      Start start = new Start();
      start.setLocationRelativeTo(start);
      start.setVisible(true);
      start.onLoad();
    }
}
