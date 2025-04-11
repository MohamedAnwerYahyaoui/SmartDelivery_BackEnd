# 🧑‍💼 User Management Microservice

Welcome to the **User Management Microservice**, a critical component of a modern **Construction Management System** built using a microservices architecture. This microservice is responsible for handling **user authentication, registration, and role-based authorization** using **Keycloak** as an Identity and Access Management (IAM) solution.

---

## 🧭 Project Overview

This microservice manages all **user-related operations**, such as:
- User registration and login
- Client account creation
- Password recovery
- Fetching and updating user information
- Role creation, assignment, and management

All of these actions are secured and powered by **Keycloak**, ensuring a robust, centralized, and secure user management flow.

---

## 🧱 Architecture

This microservice is a part of a distributed microservice system built using:

- `Spring Boot`: for creating the service logic
- `Spring Cloud Gateway`: for API routing and centralized entry point
- `Eureka Server`: for service discovery
- `Spring Cloud Config`: for centralized configuration
- `Keycloak`: for Identity and Access Management
- `Docker & Docker Compose`: for containerization and orchestration
- `Angular`: frontend client consuming this service

The entire architecture is built with modularity, scalability, and security in mind.

---

## 🛡️ Keycloak Integration

**Keycloak** is an open-source Identity and Access Management solution for modern applications and services.

### 🔐 How Keycloak Works in This Microservice:

1. **Authentication**:  
   When a user logs in, Keycloak verifies credentials and issues a **JWT (JSON Web Token)** and a **refresh token**.

2. **Authorization**:  
   Based on the user's roles (assigned in Keycloak), they get access to specific endpoints or features.

3. **User Management**:  
   This microservice communicates with Keycloak via its Admin REST API to:
    - Create new users
    - Update user details
    - Assign or remove roles
    - Delete users
    - Handle password reset
    - Fetch user and role information

Keycloak acts as the **Single Source of Truth** for all identity and access concerns, enabling stateless, token-based security across microservices.

---

## 🚀 Exposed REST API Endpoints

### 🔑 Authentication Endpoints

| Method | Endpoint       | Description              |
|--------|----------------|--------------------------|
| POST   | `/login`       | Authenticates a user and returns a token |
| POST   | `/logout`      | Invalidates the refresh token and logs out |

### 👥 User Management

| Method | Endpoint           | Description                   |
|--------|--------------------|-------------------------------|
| POST   | `/add`             | Create a new user             |
| POST   | `/addClient`       | Create a new client user      |
| GET    | `/all`             | Retrieve all users            |
| GET    | `/{id}`            | Get user by ID                |
| PUT    | `/{userId}`        | Update an existing user       |
| DELETE | `/{id}`            | Delete a user by ID           |
| PUT    | `/forgot-password` | Initiate password reset using email |
| GET    | `/{id}/roles`      | Get user roles by user ID     |

### 🛡️ Role Management

| Method | Endpoint                          | Description                        |
|--------|-----------------------------------|------------------------------------|
| POST   | `/add`                            | Create a new role                  |
| GET    | `/all`                            | Retrieve all roles                 |
| PUT    | `/{originalRoleName}`             | Update a role                      |
| DELETE | `/{roleName}`                     | Delete a role                      |
| PUT    | `/assign/users/{userId}`          | Assign role to user                |
| DELETE | `/remove/users/{userId}`          | Remove role from user              |
| GET    | `/role/{roleName}`                | Get role details by name           |
| GET    | `/id/{roleId}`                    | Get role details by ID             |

---

## 🧰 Technologies Used

| Layer        | Technology         |
|--------------|--------------------|
| Backend      | Spring Boot, Spring Web |
| Auth/IAM     | Keycloak           |
| Service Discovery | Eureka Server     |
| Gateway      | Spring Cloud Gateway |
| Config       | Spring Cloud Config |
| Containerization | Docker, Docker Compose |
| Frontend     | Angular            |

---

## 🐳 Dockerization

This microservice is designed to run in containers and is part of a Dockerized environment:

- Each microservice runs in its own container
- Keycloak server is containerized and exposed to all services
- `docker-compose.yml` is used to orchestrate services including:
    - Spring Boot services
    - Spring Gateway
    - Eureka Discovery Server
    - Spring Config Server
  

Example snippet from `docker-compose.yml` for Keycloak:

```yaml
services:
    authService-service:
    build: ./microservices/authService
    image: authManagement:latest
    container_name: authManagementContainer
    ports:
      - "8070:8070"
    depends_on:
      - eureka
      - gateway
    environment:
      - EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://eureka:8076/eureka/
    networks:
      - microservices-network
