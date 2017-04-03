# Schnick Schnack Schnuck
Eine einfache Implementierung von Stein, Schere, Papier über REST

## Tests ausführen
`./gradlew test`

## Applikation bauen und ausführen
```
./gradlew build
java -jar build/libs/kata-0.0.1-SNAPSHOT.jar

# Applikation im Standard-Modus starten (Stein, Schere, Papier)
java -Dgame.type=standard -jar build/libs/kata-0.0.1-SNAPSHOT.jar

# Applikation im Erweitert-Modus starten (Stein, Schere, Papier, Brunnen). Dies ist der Default.
java -Dgame.type=erweitert -jar build/libs/kata-0.0.1-SNAPSHOT.jar
```

## Bedienungsanleitung

```
# Lokal
curl --data "symbol=STEIN"   http://localhost:8080/spiel/v1/spielen
curl --data "symbol=SCHERE"  http://localhost:8080/spiel/v1/spielen
curl --data "symbol=PAPIER"  http://localhost:8080/spiel/v1/spielen
curl --data "symbol=BRUNNEN" http://localhost:8080/spiel/v1/spielen

# Remote
curl --data "symbol=STEIN"   https://schnick-schnack-schnuck.herokuapp.com/spiel/v1/spielen
curl --data "symbol=SCHERE"  https://schnick-schnack-schnuck.herokuapp.com/spiel/v1/spielen
curl --data "symbol=PAPIER"  https://schnick-schnack-schnuck.herokuapp.com/spiel/v1/spielen
curl --data "symbol=BRUNNEN" https://schnick-schnack-schnuck.herokuapp.com/spiel/v1/spielen

```
## Projektinfrastruktur
* Code findet sich unter https://github.com/svenwelte/schnick_schnack_schnuck
* Der aktuelle Continuous Integration Stand [![CircleCI](https://circleci.com/gh/svenwelte/schnick_schnack_schnuck.svg?style=svg)](https://circleci.com/gh/svenwelte/schnick_schnack_schnuck) findet sich unter https://circleci.com/gh/svenwelte/schnick_schnack_schnuck
* Die Applikation ist deployed unter https://schnick-schnack-schnuck.herokuapp.com
