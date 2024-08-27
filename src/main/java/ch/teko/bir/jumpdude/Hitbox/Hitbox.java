package ch.teko.bir.jumpdude.Hitbox;

// https://www.stefanonsoftware.com/post/gamedev-hit-detection

import ch.teko.bir.jumpdude.Player.Position;

public class Hitbox {

    private Position position;
    private int width, height;

    public Hitbox(Position position, int width, int height) {
        this.position = position;
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

    public void setX(int x) {
        position.setX(x);
    }
    public void setY(int y) {
        position.setY(y);
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