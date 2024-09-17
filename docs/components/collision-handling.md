# Collision Handling

Das Collision Handling ist mehrheitich im [CollisionHelper] implementiert.
Sie bildet das Bindestück zwischen [Player] und [Obstacle] und [Player] und Jetpack.
Grundsätzlich ist die Idee, dass die Klassen keine direkte Abhängigkeit zueinander haben.

Bei den Obstacles wird jeweils ein Loop durch alle [Obstacle] gemacht und geprüft mit `intersects` ob die [Hitbox] berührt wurde.

Beispiel beim Jetpack:

``` java
public boolean CheckIfPlayerHitsJetpack(Hitbox playerHitbox)
{
    var jetpack = jetpackModel.getJetpack();

    var hitJetpack = jetpack.hitbox.intersects(playerHitbox);
    return hitJetpack;
}
```

[CollisionHelper]: ../../src/main/java/ch/teko/bir/jumpdude/CollisionHelper/CollisionHelper.java
[Player]: ../../src/main/java/ch/teko/bir/jumpdude/Player/Player.java
[Obstacle]: ../../src/main/java/ch/teko/bir/jumpdude/Obstacles/Obstacle.java
[Hitbox]: ../../src/main/java/ch/teko/bir/jumpdude/Hitbox/Hitbox.java