# 🎓 Exam Portal Microservices Architecture

A robust, distributed microservice-based backend system built with **Spring Boot** and **Spring Cloud**, designed to manage online quizzes, dynamic questions, service discovery, and API routing.

---

## 🏗️ System Architecture & Services

The application follows a decoupled microservice pattern where external requests flow through an API Gateway, discover service instances via a Eureka Registry, and communicate securely via OpenFeign.

```
                  [ Client / Postman ]
                           │
                           ▼
             ┌──────────────────────────┐
             │    API Gateway           │ (Port: 8085)
             └─────────────┬────────────┘
                           │ (Load Balanced: lb://)
             ┌─────────────┴────────────┐
             ▼                          ▼
   ┌───────────────────┐      ┌───────────────────┐
   │   QuizService     │◄────►│  QuestionService  │ (OpenFeign)
   │   (Port: 8081)    │      │   (Port: 9082)    │
   └─────────┬─────────┘      └─────────┬─────────┘
             │                          │
             ▼                          ▼
       [ MySQL DB ]               [ MySQL DB ]
             │                          │
             └─────────────┬────────────┘
                           ▼
             ┌──────────────────────────┐
             │ Service Registry (Eureka)│ (Port: 8761)
             └──────────────────────────┘
```

---

## 🚀 Tech Stack & Versions

* **Language:** Java 21
* **Framework:** Spring Boot (`4.1.2`)
* **Cloud Ecosystem:** Spring Cloud (`2025.1.4`)
  * **Service Discovery:** Netflix Eureka Server & Client
  * **API Gateway:** Spring Cloud Gateway
  * **Inter-Service Communication:** Spring Cloud OpenFeign (with LoadBalancer)
* **Database:** MySQL
* **Utilities:** Lombok, Spring Data JPA, Hibernate

---

## 📂 Service Port & Mapping Reference

| Service Name | Port | Description |
| :--- | :--- | :--- |
| **Service Registry** | `8761` | Eureka Server dashboard for dynamic service discovery and health monitoring |
| **API Gateway** | `8085` | Single entry point routing external requests to downstream services |
| **QuizService** | `8081` | Manages quiz metadata, creation, and fetches associated questions |
| **QuestionService** | `9082` | Manages question banks, storage, and domain-specific lookups |

---

## ⚙️ Getting Started & Local Setup

### Prerequisites
* **Java Development Kit (JDK 21)** installed.
* **Gradle** (or use the included `./gradlew wrapper`).
* **MySQL Server** running locally.

### Step 1: Clone the Repository
```bash
git clone https://github.com/Kushagra-Kukreti/exam-portal-microservices.git
cd exam-portal-microservices
```

### Step 2: Configure Databases
Create databases in MySQL for your services:
```sql
CREATE DATABASE quiz_service_db;
CREATE DATABASE question_service_db;
```
Update your `application.properties` or `application.yml` files in each service with your local MySQL credentials.

### Step 3: Run the Services in Order
To ensure proper service discovery registration, start the applications in the following sequence:

1. **ServiceRegistry (Eureka Server):** Boot up on port `8761`.
2. **QuestionService:** Boot up; it will register itself with Eureka.
3. **QuizService:** Boot up; it utilizes OpenFeign to discover and communicate with `QUESTIONSERVICE`.
4. **ApiGateway:** Boot up on port `8085`.

---

## 🌐 API Endpoints (via API Gateway)

Once the API Gateway is running on port `8085`, you can route requests through it:

* **Get All Quizzes:** `GET http://localhost:8085/quiz`
* **Get Quiz by ID:** `GET http://localhost:8085/quiz/{id}`
* **Create Quiz:** `POST http://localhost:8085/quiz`

---

## 🛠️ Roadmap & Future Enhancements

* [ ] Integrate **Resilience4j** Circuit Breakers and Fallbacks for OpenFeign clients.
* [ ] Implement **Spring Security & JWT** validation filter at the API Gateway level.
* [ ] Add **Redis** caching layer for high-frequency question queries.
* [ ] Containerize services using **Docker & Docker Compose**.

---

## 👨‍💻 Author
**Kushagra Kukreti**  
[GitHub Profile](https://github.com/Kushagra-Kukreti)