# QA Observability Stack

Professional observability stack using Docker Compose, Prometheus, Grafana, and InfluxDB for monitoring applications and automated test environments.

This project demonstrates how QA Engineers can implement real-time monitoring, metrics collection, and visualization to improve system reliability and test observability.

---

## Architecture

Docker Compose
├── Prometheus → Metrics collection
├── Grafana → Metrics visualization
└── InfluxDB → Time-series metrics storage


---

## Technologies Used

- Docker
- Docker Compose
- Prometheus
- Grafana
- InfluxDB

---

## Purpose

This project was created to demonstrate practical knowledge in:

- Observability implementation
- Metrics monitoring
- Containerized environments
- QA automation monitoring
- DevOps integration for QA Engineers

---

## Getting Started

### Prerequisites

- Docker Desktop installed
- Docker Compose enabled

Verify installation:

```bash
docker --version
docker compose version
```

---

## Installation

Clone the repository:
```bash
git clone https://github.com/AlexanderAlves77/QA_Analyst/tree/main/qa-observability-stack
```

Navigate to the project folder:
```bash
cd qa-observability-stack
```

Start the observability stack:
```bash
docker compose up -d
```

Services and URLs: <br/>
Service	         URL	                      Description             <br/>
Prometheus	     http://localhost:9090        Metrics collection      <br/>
Grafana	         http://localhost:3000    	  Metrics visualization   <br/>
InfluxDB	     http://localhost:8086        Metrics storage         <br/>


---

# Author

Alexander Alves            <br/>
Computer Science Student   <br/>
QA Automation Engineer     <br/>
Game Developer             <br/>

GitHub: https://github.com/alexanderalves77