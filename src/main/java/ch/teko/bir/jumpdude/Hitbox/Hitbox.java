package ch.teko.bir.jumpdude.Hitbox;

// https://www.stefanonsoftware.com/post/gamedev-hit-detection
public class Hitbox {

    private float x, y; // use position
    private float width, height;

    public Hitbox(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void offset(float dx, float dy) {
        x += dx;
        y += dy;
    }

    public void set(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // returns whether bounds of this Hitbox intersects the bounds of the given Hitbox
    public boolean intersects(Hitbox h) {
        return x + width >= h.x && h.x + h.width >= x && y + height >= h.y && h.y + h.height >= y;
    }
}