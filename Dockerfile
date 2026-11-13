# ---------- Etapa 1: compilação ----------
FROM eclipse-temurin:17-jdk-jammy AS build

ARG JAVAFX_VERSION=22.0.1
ARG MAVEN=https://repo1.maven.org/maven2/org/openjfx

# JARs do JavaFX para Linux (incluem as bibliotecas nativas)
ADD ${MAVEN}/javafx-base/${JAVAFX_VERSION}/javafx-base-${JAVAFX_VERSION}-linux.jar         /javafx/
ADD ${MAVEN}/javafx-graphics/${JAVAFX_VERSION}/javafx-graphics-${JAVAFX_VERSION}-linux.jar /javafx/
ADD ${MAVEN}/javafx-controls/${JAVAFX_VERSION}/javafx-controls-${JAVAFX_VERSION}-linux.jar /javafx/
ADD ${MAVEN}/javafx-fxml/${JAVAFX_VERSION}/javafx-fxml-${JAVAFX_VERSION}-linux.jar         /javafx/

WORKDIR /app
COPY src ./src

RUN javac --module-path /javafx --add-modules javafx.controls,javafx.fxml \
        -d out $(find src -name '*.java') \
 && cp src/view/*.fxml src/view/*.css out/view/

# ---------- Etapa 2: execução ----------
FROM eclipse-temurin:17-jre-jammy

# Bibliotecas gráficas necessárias apenas para o modo "gui"
RUN apt-get update \
 && apt-get install -y --no-install-recommends libgtk-3-0 libxtst6 libgl1 \
 && rm -rf /var/lib/apt/lists/*

COPY --from=build /javafx /javafx
COPY --from=build /app/out /app/out
COPY configuracao.properties /app/
COPY docker/run.sh /usr/local/bin/run.sh
RUN sed -i 's/\r$//' /usr/local/bin/run.sh && chmod +x /usr/local/bin/run.sh

WORKDIR /app
ENTRYPOINT ["run.sh"]
CMD ["texto"]
