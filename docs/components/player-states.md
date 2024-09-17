# Player States

In der Klasse (PlayerState.java)[.\src\main\java\ch\teko\bir\jumpdude\Player\PlayerState.java] gibt es unterschiedliche Stati die die Klasse `Player` haben kann.

## Beschreibung der einzelnen Stati

Beim Starten des Spiels befindet sich der Player im `Running` State. Das ist somit der Initial State des Spielers.

Beim drücken der Pfeiltaste nach oben ↑ wird ein Sprung ausgeführt, somit befindet sich der Spieler im `Jumping` Status.
Wenn nichts gedrückt wird, bleibt der Spieler bis zur gesetztem Limite `maxDoubleJumpingHeight` der Klasser `Player`.

Beim erneuten drücken der Pfeiltaste nach oben ↑ wird ein Double Jump ausgeführt. Dann hat der Spieler den Status `FirstDoubleJumping` danach kommt er in den Status `FallingAfterFirstDoubleJumping`.
Im Status `FallingAfterFirstDoubleJumping` ist es im erlaubt erneut die Pfeiltaste nach oben ↑ zu drücken und es wird ein erneuter Double Jump ausgeführt. Dann befindet sich der Player im Status `SecondDoubleJumping`, ab diesem Status ist der double Jump blockiert, bis der Spieler wieder im initialen Status Running ist. Nach dem 2. Double Jump wechselt der Status auf `FallingAfterSecondDoubleJumping`, bis er den Boden berührt und dann wechselt er auf `Running`.

Im Gui passiert bei den 3 Falling `Falling`, `FallingAfterFirstDoubleJumping`, `FallingAfterFirstSecondJumping` Stati die gleiche Logik. Auch bei den 2 double jumping Stati `FirstDoubleJumping`, und `SecondDoubleJumping` geschieht im GUI die selbe Logik.

Der Status `Falling` wird nur dann ausgeführt, wenn **kein** Double Jump ausgeführt wurde.

Der Status `Hitting` ist dazu da um anzugeben ob der Player ein Obstacle berührt hat damit die Hitting Sprites geladen werden können für einen kurzen Moment. Anschliessend wird das Game beendet und der Player wechselt in den `GameOver` Stati.
