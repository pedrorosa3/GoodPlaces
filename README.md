# GoodPlaces - Context Monitoring System 🌡️🌿

## About the Project
**GoodPlaces** is a software application designed to establish a context for the practical evaluation of Object-Oriented Software Analysis and Design. Developed for the **Software Analysis and Design (ADS)** course at the Faculty of Sciences, University of Lisbon (FCUL).

The primary goal of the system is to allow users to visualize data collected automatically (via sensors) or manually, and to receive alerts when environmental conditions (such as temperature, light intensity, or soil humidity) deviate from specific control values.

## Core Concept
The application manages **Contexts** (e.g., a specific room, a plant nursery tray, a train carriage). Each context has **Characteristics** measured by **Sensors**. The system monitors these values against a **Configuration** (min/max thresholds) and triggers alerts if non-conformities are detected.

## Features

### User Roles
* **Technician:** Responsible for installing sensors/actuators, registering new device types, and inputting data manually when automatic collection fails.
* **Manager:** Responsible for defining reference values (configurations) for contexts and monitoring the collected data.

### Key Functionalities
* **Asset Management:** Create and manage Units of Measurement, Sensor Types, and specific Sensors.
* **Context Definition:** Define contexts and associate specific characteristics to be measured.
* **Data Collection:**
    * **Automatic:** Periodic reading of sensor values.
    * **Manual:** Technicians can manually input readings.
* **Alert System:** Automatically generates alerts when readings fall outside the defined reference intervals.
* **Validation:** Ensures compatibility between sensor units and characteristic units (e.g., converting Celsius to Fahrenheit).

## Development Methodology
This project follows the **Unified Process (UP)** and applies rigorous Object-Oriented Analysis and Design techniques. The repository includes:
* **Use Case Model:** Diagrams and detailed textual descriptions.
* **Domain Model:** Conceptual representation of the system entities.
* **System Sequence Diagrams (SSDs):** Modeling system interaction.
* **Design Class Diagrams:** Detailed software architecture.

## Technologies
* **Language:** Java.
* **Scope:** Backend logic and Data Modeling.



---
*This project was developed for educational purposes.*
