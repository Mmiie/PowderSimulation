package m75.Entities;

import java.util.ArrayList;
import java.util.Iterator;

public class ParticleManager {
    private ArrayList<Particle> particles = new ArrayList<>();
    public static final int PANEL_SIZE = 500;

    public void add(Particle p) {
        particles.add(p);
    }

    public boolean isCellEmpty(int gridX, int gridY) {
        int maxCells = PANEL_SIZE / Particle.CELL_SIZE;
        if (gridX < 0 || gridX >= maxCells || gridY < 0 || gridY >= maxCells) return false;
        for (Particle p : particles) {
            int px = Math.round(p.x / Particle.CELL_SIZE);
            int py = Math.round(p.y / Particle.CELL_SIZE);
            if (px == gridX && py == gridY) return false;
        }
        return true;
    }

    public void update() {
        Iterator<Particle> it = particles.iterator();
        while (it.hasNext()) {
            Particle p = it.next();
            p.update(this);
            if (p.isDead()) it.remove();
        }
    }

    public void render(java.awt.Graphics g) {
        for (Particle p : particles) p.render(g);
    }
}
