package m75.Entities;

import java.awt.Color;
import java.awt.Graphics;

public class SmokeParticle extends Particle {
    private int life = 100;

    public SmokeParticle(float x, float y) {
        super(x, y);
        this.velocityX = (float)(Math.random() * 2 - 1);
        this.velocityY = (float)(Math.random() * -1);
    }

    @Override
    public void update(ParticleManager manager) {
        super.update(manager);
        x += velocityX;
        y += velocityY;
        if (!manager.isCellEmpty(Math.round(x / CELL_SIZE), Math.round(y / CELL_SIZE))) canMove = false;
        life--;
    }

    @Override
    public void render(Graphics g) {
        int alpha = Math.max(0, Math.min(255, life * 255 / 100));
        g.setColor(new Color(100, 100, 100, alpha));
        g.fillOval((int)x, (int)y, CELL_SIZE, CELL_SIZE);
    }

    @Override
    public boolean isDead() {
        return life <= 0;
    }
}
