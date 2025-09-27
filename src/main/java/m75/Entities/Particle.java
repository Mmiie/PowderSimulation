package m75.Entities;

import java.awt.Graphics;

public class Particle {
    public float x, y;
    public float velocityX, velocityY;
    public int life = 200;
    public boolean canMove = true;
    public int updateCounter = 0;
    public double updateFrequency = 1;
    public static final int CELL_SIZE = 4;

    public Particle(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void performUpdate(ParticleManager manager) {
        updateCounter++;
        if (updateCounter < updateFrequency) return;
        updateCounter = 0;

        int gridX = Math.round(x / CELL_SIZE);
        int gridY = Math.round(y / CELL_SIZE);
        int direction = -1;

        if (manager.isCellEmpty(gridX, gridY + 1)) direction = 0;
        else if (manager.isCellEmpty(gridX - 1, gridY + 1)) direction = 1;
        else if (manager.isCellEmpty(gridX + 1, gridY + 1)) direction = 2;

        switch (direction) {
            case 0 -> y += CELL_SIZE;
            case 1 -> { x -= CELL_SIZE; y += CELL_SIZE; }
            case 2 -> { x += CELL_SIZE; y += CELL_SIZE; }
            default -> {
                canMove = false;
                updateFrequency = 10 + Math.random() * 9;
            }
        }

        if (direction != -1) {
            canMove = true;
            updateFrequency = 1;
        }
    }

    public void update(ParticleManager manager) {
        if (canMove || updateFrequency > 1) performUpdate(manager);
    }

    public void render(Graphics g) {
        g.setColor(java.awt.Color.GRAY);
        g.fillRect(Math.round(x), Math.round(y), CELL_SIZE, CELL_SIZE);
    }

    public boolean isDead() {
        return false;
    }
}
