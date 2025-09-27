package m75.Controls;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
import m75.Entities.ParticleManager;
import m75.Entities.SandParticle;
import m75.Entities.SmokeParticle;

public class mouseInputs extends MouseInputAdapter {

    private ParticleManager manager;
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private int mouseX, mouseY;
    private int brushSize = 10; // number of particles per spawn
    private int spread = 8;     // max random offset in pixels

    public mouseInputs(ParticleManager manager) {
        this.manager = manager;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) leftPressed = true;
        if (e.getButton() == MouseEvent.BUTTON3) rightPressed = true;
        mouseX = e.getX();
        mouseY = e.getY();
        spawnParticles();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) leftPressed = false;
        if (e.getButton() == MouseEvent.BUTTON3) rightPressed = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        spawnParticles();
    }

    private void spawnParticles() {
        for (int i = 0; i < brushSize; i++) {
            int offsetX = (int)((Math.random() * 2 - 1) * spread);
            int offsetY = (int)((Math.random() * 2 - 1) * spread);
            int px = mouseX + offsetX;
            int py = mouseY + offsetY;
            if (leftPressed) manager.add(new SandParticle(px, py));
            if (rightPressed) manager.add(new SmokeParticle(px, py));
        }
    }

    public void spawnHeldParticles() {
        spawnParticles();
    }
}
