package ch.teko.bir.jumpdude;

public class GameSpeedController {
    private static int RUNNING_SPEED = 5;
    private static int FLYING_SPEED = 5;

    public static void increaseRunningSpeed()
    {
        RUNNING_SPEED += 5;
    }

    public static int getRunningSpeed()
    {
        return RUNNING_SPEED;
    }

    public static void setRunningSpeedToIdle() {
        RUNNING_SPEED = 0;
    }

    public static void setInitialRunningSpeed()
    {
        RUNNING_SPEED = 5;
    }
    public static void increaseFlyingSpeed()
    {
        FLYING_SPEED += 5;
    }

    public static int getFlyingSpeed()
    {
        return FLYING_SPEED;
    }

    public static void setFlyingSpeedToIdle() {
        FLYING_SPEED = 0;
    }

    public static void setInitialFlyingSpeed()
    {
        FLYING_SPEED = 5;
    }
}