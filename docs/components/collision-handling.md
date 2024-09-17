# Collision Handling

Das Collision Handling ist mehrheitich im [CollisionHelper] implementiert.

/**
 * Is the Middleware from Obstacle and Player and Jetpack. 
 * It's main job is to detect if a Player hits a obstacle.
 * The idea is, to remove the direct dependency between player and obstacle and jetpack.
 **/

## Obstacle

Loop durch alle Obstacle und prüft mit `intersects` ob die Hitbox berührt wurde.

## Jetpack

``` java
public boolean CheckIfPlayerHitsJetpack(Hitbox playerHitbox)
{
    var jetpack = jetpackModel.getJetpack();

    var hitJetpack = jetpack.hitbox.intersects(playerHitbox);
    return hitJetpack;
}
```

[CollisionHelper]: ../../src/main/java/ch/teko/bir/jumpdude/CollisionHelper/CollisionHelper.java