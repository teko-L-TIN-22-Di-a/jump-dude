# jump-dude

[![Java CI with Maven](https://github.com/teko-L-TIN-22-Di-a/jump-dude/actions/workflows/build.yml/badge.svg?branch=main)](https://github.com/teko-L-TIN-22-Di-a/jump-dude/actions/workflows/build.yml)

[![Deploy Javadoc](https://github.com/teko-L-TIN-22-Di-a/jump-dude/actions/workflows/publish-javadocs.yml/badge.svg)](https://github.com/teko-L-TIN-22-Di-a/jump-dude/actions/workflows/publish-javadocs.yml)

## Einleitung

Das Spiel soll einen simplen Aufbau haben. Keine besonderen grafischen Elemente. Gespielt wird das Spiel von einer Side-View.

## Beschreibung

Es soll ein Jump and Run Spiel implementiert werden mit der Sicht von der Seite. Ziel ist es dass die Hauptfigur möglichst lange am Leben bleibt.
Es sollen verschiedene Hindernisse implementiert werden, welche man bewältigen muss. Wenn die Hauptfigur ein Hindernis berührt, dann führt das zu einem Schaden. Bei zu viel Schaden stirbt die Hauptfigur und wird das Spiel beendet. Hindernisse sollen über einen Jump bewältigt werden können. Die Hindernisse sollen zufällig im Level platziert werden. In einem gewissen Zeitintervall sollen immer mehr und schwierigere Hindernisse im Spiel erscheinen.
Nach einer gewissen Zeit soll ein Jetpack erscheinen, welches eingesammelt werden muss. Beim einsammeln des Items ändert sich die Steuerung und es muss nun nicht mehr gesprungen werden, sondern es müssen den zufälligen Hindernissen in der Luft ausgewichen werden. Die Levelführung ist nicht mehr von links nach rechts, sondern von unten nach oben.
Es soll eine Stoppuhr ersichtlich sein, welche misst wie viel Zeit bereits vergangen ist, damit verschiedene Läufe verglichen werden können.
Optional: Multiplayerfähigkeit übers Netzwerk. Hierbei ist das Ziel, als Team möglichst lange zu überleben.
Optional: Items welche den Schaden von bereits berührten Hindernissen reduzieren oder bei der Hindernisbewältigung helfen können.

## Konzept

Im [Konzept](./docs/markdown/concept.md) ist die Grund Idee beschrieben, welche verfolgt wird.

## Entwicklungsprozess

Der Entwicklungsprozess wurde unter [Entwicklungsprozess](./docs/markdown/development-process.md) beschrieben.

## Komponenten

Die Dokumentation der wichtigen Komponenten wurde unter [Overview Components](./docs/components/overview-components.md) festgehalten.

## JavaDocs

[jump dude JavaDocs](https://teko-l-tin-22-di-a.github.io/jump-dude/)

## Used assets

* Sounds: [Pixabay](https://pixabay.com/sound-effects/search/)
* Player Sprites: [Pixel Adventure](https://pixelfrog-assets.itch.io/pixel-adventure-1)
* Sprites Handling: [Load a sprites image in java](https://stackoverflow.com/questions/35472233/load-a-sprites-image-in-java)
* Jetpack Sptite: [vecteezy](https://www.vecteezy.com/vector-art/21660057-jetpack-in-pixel-art-style)
