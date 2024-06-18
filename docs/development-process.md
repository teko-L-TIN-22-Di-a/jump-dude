# Level build

Als erstes wurde das Level simpel generiert. Die Idee war es möglichst viele Erfahrungen zu sammen und den Aufbau von Java und den Komponenten zu verstehen.

[Testing Java Features](./videos/levelBuild.mp4)

# Refactoring

Der zweite step war es ein Refactoting des Spiels zu machen. Dabei wurde versucht eine Komponenten Struktur mit MVC zu implementieren. Das Refactoring ist aber noch nicht abgeschlossen. Die Komponenten, welche beim erstellen eines neuen Features negativ auffallen, werden bei Bedarf überarbeitet.

# Implementation des Jump & Double Jump

Das erste Feature welches implementiert wurde ist der Jump. Dabei gab es einige Schwierigkeiten. Diese konnten aber mit einem kleinen Aufwand gefixt werden.

## Jump, Fall and Double Jump

Bei einem Jump wird lediglich die Y Achse angepasst. Problematik hier war aber, dass ich an einer anderen Stelle im Code statt der Y Achse die X Achse geladen habe. Dieser Fehler kam durch das Refactoring rein. Deshalb bewegt sich der Dude auch nicht direkt auf dem Boden. :-)
Zudem wurde jeweils bei einem Sprung die Y achse nur +10 oder -10 verändert. Dabei habe ich mir dann Gedanken über einen State für den Player gemacht.
[First Try](./videos/first-try-jump.mp4)

Nach dem ergänzen eines Player States, welcher Aktuell 4 Stati hat Running, Jumping und Falling. Sah dann der Jump so aus.
[Second Try](./videos/second-try-jump.mp4)

Nach dem setzen einer Limite für die Höhe eines Sprunges und implementierung des Falles sah es dann so aus.
[Third Try](./videos/third-try-jump.mp4)

Nach dem setzen einer Limite für die Höhe eines Sprunges und implementierung des Falles sah es dann so aus.
[Third Try](./videos/third-try-jump.mp4)

Nach dem rumprobieren hatte ich dann die Idee einen Jump zu implementieren, welcher bei einem längeren Knopfdruck auch höher springt.
[Jump with long key press](./videos/jump-with-long-key-press.mp4)

Nun leider musste ich dieses Feature wieder entfernen, da es mit dem Double Jump nicht funktionierte. Bei einem längeren Key Press wurde dann direkt ein double jump erkannt. Dabei wollte ich aber keine spezielle Implementation machen und habe mich deshalb für das double jump feature entschieden.

[Double Jump](./videos/double-jump.mp4)
