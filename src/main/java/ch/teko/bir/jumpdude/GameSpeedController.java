package ch.teko.bir.jumpdude;

public class GameSpeedController {
    private int RUNNING_SPEED;
    private int FLYING_SPEED = 5;

    public void increaseRunningSpeed()
    {
        RUNNING_SPEED += 1;
    }

    public int getRunningSpeed()
    {
        return RUNNING_SPEED;
    }

    public void setRunningSpeedToIdle() {
        RUNNING_SPEED = 0;
    }

    public void setInitialRunningSpeed()
    {
        RUNNING_SPEED = 5;
    }
    public void increaseFlyingSpeed()
    {
        FLYING_SPEED += 5;
    }

    public int getFlyingSpeed()
    {
        return FLYING_SPEED;
    }

    public void setFlyingSpeedToIdle() {
        FLYING_SPEED = 0;
    }

    public void setInitialFlyingSpeed()
    {
        FLYING_SPEED = 5;
    }
}