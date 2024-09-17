package ch.teko.bir.jumpdude;

public class GameSpeedController {
    private static int GAME_SPEED = 5;

    public static void increaseSpeed()
    {
        GAME_SPEED += 5;
    }

    public static int getSpeed()
    {
        return GAME_SPEED;
    }

    public static void setIdleSpeed() {
        GAME_SPEED = 0;
    }

    public static void setInitialSpeed()
    {
        GAME_SPEED = 5;
    }
}