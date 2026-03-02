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
git clone https://github.com/AlexanderAlves77/QA_Analyst/tree/main/qa-observability-stack

Navigate to the project folder:
cd qa-observability-stack

Start the observability stack:
docker compose up -d

Services and URLs:
Service	         URL	                      Description 
Prometheus	     http://localhost:9090        Metrics collection
Grafana	         http://localhost:3000    	  Metrics visualization
InfluxDB	     http://localhost:8086        Metrics storage


---

# Author

Alexander Alves
Computer Science Student
QA Automation Engineer
Game Developer

GitHub: https://github.com/alexanderalves77