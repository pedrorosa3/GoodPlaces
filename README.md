<div align="center">

# 🌿 GoodPlaces

### Sistema de Monitorização de Contextos

*Recolha de leituras de sensores, valores de referência e alertas automáticos quando as condições saem do normal.*

![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-22-blue)
![Docker](https://img.shields.io/badge/Docker-pronto-2496ED?logo=docker&logoColor=white)
![Eclipse](https://img.shields.io/badge/IDE-Eclipse-2C2255?logo=eclipseide&logoColor=white)
![FCUL](https://img.shields.io/badge/FCUL-ADS-green)

</div>

---

## 📋 Informação

| | |
|---|---|
| **👤 Autor** | Pedro Rosa ([@pedrorosa3](https://github.com/pedrorosa3)) |
| **👥 Grupo 20** | Pedro Rosa (nº 60294) · Tiago Raposo (nº 60293) · Tomás Nogueira (nº 60285) |
| **🏫 Unidade curricular** | Análise e Desenho de Software (ADS) — Faculdade de Ciências da Universidade de Lisboa |
| **📅 Data** | Maio de 2024 (última atualização do README: 13 de novembro de 2026) |

---

## 📖 Sobre o projeto

O **GoodPlaces** é uma aplicação desenvolvida no âmbito da cadeira de **Análise e Desenho de Software**, com o objetivo de aplicar na prática técnicas de análise e desenho orientados a objetos.

O sistema gere **Contextos** (por exemplo, uma sala, um tabuleiro de viveiro ou uma carruagem de comboio). Cada contexto tem **Características** (temperatura, luminosidade, humidade do solo, …) medidas por **Sensores**. As leituras são comparadas com **Valores de Referência** (mínimo/máximo) e, sempre que há uma não conformidade, é gerado um **alerta**.

### 👥 Perfis de utilizador

- **🔧 Técnico** — instala sensores, regista novos tipos de dispositivo e introduz leituras manualmente quando a recolha automática falha.
- **📊 Gestor** — define os valores de referência dos contextos e acompanha os dados recolhidos.

### ✨ Funcionalidades

- **Gestão de ativos** — unidades de medida, tipos de sensor e sensores.
- **Definição de contextos** — associação de características a medir em cada contexto.
- **Recolha de dados** — automática (leitura periódica) ou manual.
- **Sistema de alertas** — alertas sempre que uma leitura sai do intervalo de referência (para a consola ou para ficheiro).
- **Validação** — compatibilidade entre as unidades do sensor e da característica.

---

## 🗂️ Estrutura

```
GoodPlaces/
├── src/
│   ├── controller/     # Controladores JavaFX (casos de uso na interface)
│   ├── domain/         # Modelo de domínio (Contexto, Sensor, Leitura, …)
│   │   ├── alertas/    # Adaptadores de alerta (Sysout / Ficheiro)
│   │   ├── handlers/   # Handlers dos casos de uso
│   │   └── interfaces/ # Interfaces do domínio
│   ├── services/       # Gestão de sessão
│   ├── startup/        # Pontos de entrada (StartUp e TextClient)
│   └── view/           # Vistas FXML, CSS e arranque JavaFX
├── docker/run.sh            # Ponto de entrada do contentor (texto / gui)
├── Dockerfile               # Imagem com JDK 17 + JavaFX 22
├── configuracao.properties  # Configuração do adaptador de alertas
└── Relgrupo20.pdf           # Relatório do projeto
```

---

## 🚀 Como executar

### 🐳 Opção recomendada — Docker

A forma mais simples: só precisas do [Docker](https://www.docker.com/products/docker-desktop/). O JDK e o JavaFX são instalados dentro da imagem.

```bash
# Construir a imagem
docker build -t goodplaces .

# Correr o cliente de texto (executa os casos de uso na consola)
docker run --rm goodplaces
```

<details>
<summary><b>🖥️ Correr a interface gráfica (JavaFX) no Docker</b></summary>

A interface gráfica precisa de um servidor X11 na máquina anfitriã.

**Linux**

```bash
xhost +local:docker
docker run --rm -e DISPLAY=$DISPLAY -v /tmp/.X11-unix:/tmp/.X11-unix goodplaces gui
```

**Windows** (com [VcXsrv](https://sourceforge.net/projects/vcxsrv/) aberto e a opção *Disable access control* ativa)

```powershell
docker run --rm -e DISPLAY=host.docker.internal:0.0 goodplaces gui
```

**macOS** (com [XQuartz](https://www.xquartz.org/) e *Allow connections from network clients* ativo)

```bash
xhost + 127.0.0.1
docker run --rm -e DISPLAY=host.docker.internal:0 goodplaces gui
```

</details>

### Execução local (sem Docker)

#### Pré-requisitos

- **JDK 17** ou superior
- **JavaFX SDK 22** ([download](https://gluonhq.com/products/javafx/)), só necessário para a interface gráfica
- *(Opcional)* **Eclipse IDE**

#### Opção 1 — Eclipse

1. `File → Import → Existing Projects into Workspace` e escolher a pasta do repositório.
2. Em `Project → Properties → Java Build Path → Libraries`, corrigir o caminho dos JARs do JavaFX para o local onde está instalado o SDK na tua máquina.
3. Executar:
   - **Interface gráfica:** `src/startup/StartUp.java` → *Run As → Java Application*
   - **Cliente de texto:** `src/startup/TextClient.java` → *Run As → Java Application*

> Se a interface gráfica não arrancar, acrescenta em *Run Configurations → Arguments → VM arguments*:
> `--module-path "C:\caminho\para\javafx-sdk-22\lib" --add-modules javafx.controls,javafx.fxml`

#### Opção 2 — Linha de comandos

Na raiz do projeto (exemplo em PowerShell; ajusta `$FX` ao caminho do teu JavaFX SDK):

```powershell
$FX = "C:\caminho\para\javafx-sdk-22\lib"

# Compilar
javac --module-path $FX --add-modules javafx.controls,javafx.fxml -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
Copy-Item src\view\*.fxml, src\view\*.css out\view\

# Cliente de texto (corre os casos de uso na consola)
java -cp out startup.TextClient

# Interface gráfica
java --module-path $FX --add-modules javafx.controls,javafx.fxml -cp out startup.StartUp
```

### 🔑 Utilizadores de teste

| Utilizador | Password | Perfil |
|---|---|---|
| `Tecnico1` | `123` | Técnico |
| `Tecnico2` | `abc` | Técnico |
| `Gestor1` | `123` | Gestor |
| `Gestor2` | `abc` | Gestor |

### ⚙️ Configuração dos alertas

O ficheiro `configuracao.properties` define para onde vão os alertas:

```properties
# Alertas na consola
alertaAdapter=SysOutAlertaAdapter

# Alertas escritos em ficheiro
# alertaAdapter=FileAlertaAdapter
```

> No Docker, este ficheiro é copiado para a imagem no momento do build. Depois de o alterares, volta a correr `docker build -t goodplaces .`.

---

## 🧭 Metodologia

O projeto segue o **Processo Unificado (UP)** e inclui:

- **Modelo de Casos de Uso** — diagramas e descrições textuais
- **Modelo de Domínio** — representação conceptual das entidades
- **Diagramas de Sequência de Sistema (DSS)**
- **Diagramas de Classes de Desenho**

Toda a documentação está no relatório [Relgrupo20.pdf](Relgrupo20.pdf).

---

<div align="center">

*Projeto desenvolvido para fins académicos — FCUL, 2024.*

</div>
