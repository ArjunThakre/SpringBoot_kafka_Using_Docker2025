# 🚀 Spring Boot Kafka with Docker 🐳

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)](https://spring.io/projects/spring-boot)
[![Apache Kafka](https://img.shields.io/badge/Apache%20Kafka-3.x-231F20)](https://kafka.apache.org/)
[![Docker](https://img.shields.io/badge/Docker-20.10+-2496ED)](https://www.docker.com/)
[![Java](https://img.shields.io/badge/Java-17+-007396)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue)](LICENSE)

A **Spring Boot 3** application demonstrating **Apache Kafka** integration using **Docker Compose** for seamless local development and deployment.

## 📋 **Table of Contents**
- [✨ Features](#-features)
- [🏗️ Architecture](#️-architecture)
- [⚡ Quick Start](#-quick-start)
- [📁 Project Structure](#-project-structure)
- [🔧 Configuration](#-configuration)
- [📡 API Endpoints](#-api-endpoints)
- [🐳 Docker Commands](#-docker-commands)
- [🧪 Testing](#-testing)
- [📊 Monitoring](#-monitoring)
- [🤝 Contributing](#-contributing)

---

## ✨ **Features**
✅ **Spring Boot 3.x** with auto-configuration  
✅ **Apache Kafka** Producer-Consumer implementation  
✅ **Docker Compose** for multi-container orchestration  
✅ **REST APIs** for message operations  
✅ **Health Checks** with Spring Actuator  
✅ **Environment-based** configuration  
✅ **Kafka UI** for visual monitoring (optional)  
✅ **Complete Dockerization** of all services  

---

## 🏗️ **Architecture**
┌─────────────────────────────────────────────────────────────┐
│ Docker Host │
│ ┌─────────────┐ ┌─────────────┐ ┌─────────────┐ │
│ │ Zookeeper │ │ Kafka │ │ Spring Boot│ │
│ │ (2181) │◄──►│ (9092) │◄──►│ (8080) │ │
│ └─────────────┘ └─────────────┘ └─────────────┘ │
│ │ │ │ │
│ └────────────────────┴────────────────────┘ │
│ Docker Network │
└─────────────────────────────────────────────────────────────┘
