package ch.teko.bir.jumpdude.Player;

public enum PlayerState {
    Running,
    Jumping,
    FirstDoubleJumping,
    FallingAfterFirstDoubleJumping,
    SecondDoubleJumping,
    FallingAfterSecondDoubleJumping,
    Falling,
    Hitting,
    GameOver
}