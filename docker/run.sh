#!/bin/sh
# Ponto de entrada do contentor GoodPlaces.
#   texto -> cliente de texto (consola)
#   gui   -> interface gráfica JavaFX (requer servidor X11 / DISPLAY)
set -e

case "${1:-texto}" in
  texto|text)
    exec java -cp /app/out startup.TextClient
    ;;
  gui)
    exec java -Dprism.order=sw \
      --module-path /javafx --add-modules javafx.controls,javafx.fxml \
      -cp /app/out startup.StartUp
    ;;
  *)
    exec "$@"
    ;;
esac
