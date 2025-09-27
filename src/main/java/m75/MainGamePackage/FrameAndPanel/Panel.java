package m75.MainGamePackage.FrameAndPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

import m75.Controls.mouseInputs;
import m75.Entities.ParticleManager;

public class Panel extends JPanel implements ActionListener {

    private ParticleManager manager;
    private Timer timer;
    private mouseInputs mouse;

    public Panel() {
        this.setPreferredSize(new java.awt.Dimension(500, 500));
        this.setBackground(Color.BLACK);

        manager = new ParticleManager();
        mouse = new mouseInputs(manager);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);

        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        manager.render(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        manager.update();
        mouse.spawnHeldParticles();
        repaint();
    }
}
