package m75.Entities;

import java.awt.Color;
import java.awt.Graphics;

public class SandParticle extends Particle {
    public SandParticle(float x, float y) {
        super(x, y);
    }

    @Override
    public void update(ParticleManager manager) {
        super.update(manager);
        life = 200;
    }

    @Override
    public void render(Graphics g) {
        int alpha = Math.max(0, Math.min(255, life * 255 / 200));
        g.setColor(new Color(194, 178, 128, alpha));
        g.fillRect(Math.round(x), Math.round(y), CELL_SIZE, CELL_SIZE);
    }

    @Override
    public boolean isDead() {
        return false;
    }
}
