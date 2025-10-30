package m75.MainGamePackage.FrameAndPanel;

import javax.swing.JFrame;

public class Frame extends JFrame{

    public Frame(){
        this.setTitle("powder sim");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel panel = new Panel();
        this.add(panel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
}
