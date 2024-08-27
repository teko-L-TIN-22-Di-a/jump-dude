package ch.teko.bir.jumpdude.Hitbox;

// https://www.stefanonsoftware.com/post/gamedev-hit-detection

import ch.teko.bir.jumpdude.Player.Position;

public class Hitbox {

    private Position position;
    private float width, height;

    public Hitbox(int x, int y, int width, int height) {
        this.position.setX(x);
        this.position.setY(y);
        this.width = width;
        this.height = height;
    }

    public void offset(int dx, int dy) {
        this.position.addToX(dx);
        this.position.addToY(dy);
    }

    public void set(int x, int y, int width, int height) {
        this.position.setX(x);
        this.position.setY(y);
        this.width = width;
        this.height = height;
    }

    // returns whether bounds of this Hitbox intersects the bounds of the given Hitbox
    public boolean intersects(Hitbox hitbox) {
        int x = position.getX();
        int y = position.getY();
        int hitboxX = hitbox.position.getX();
        int hitboxY = hitbox.position.getY();
        return x + width >= hitboxX && hitboxX + hitbox.width >= x && y + height >= hitboxY && hitboxY + hitbox.height >= y;
    }
}