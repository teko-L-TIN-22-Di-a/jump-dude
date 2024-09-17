package ch.teko.bir.jumpdude.Hitbox;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import ch.teko.bir.jumpdude.Options.Options;
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

    public void setHeight(int value) {
        this.height = value;
    }
    public void setWidth(int value) {
        this.width = value;
    }

    public void draw(Graphics2D graphics2d, JPanel panel) {
        if (Options.DRAW_HITBOXES)
        {
            graphics2d.setColor(Color.red);
            graphics2d.drawRect(this.position.getX(), this.position.getY(), this.width, this.height);
        }
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