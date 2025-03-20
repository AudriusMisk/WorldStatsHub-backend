# World Stats Hub - Full Stack Application (Spring Boot & React)

This is a **full-stack web application** built with **Spring Boot (Java) for the backend** and **React.js for the frontend**. The application allows users to **browse countries by region, view details of each country, and perform CRUD operations** (Create, Read, Update, Delete) on countries.

## Features
- **Browse countries** by selecting a region.
- **View country details** such as population, capital, languages, and currencies.
- **Admin authentication** for CRUD operations.
- **Fetches real-time country data** from `restcountries.com`.
- **Stores data in a MySQL database**.
- **Frontend built with React and Axios** for API requests.

---

## Tech Stack
### **Backend (Spring Boot)**
- Java & Spring Boot
- Spring Data JPA (MySQL)
- Spring Security (JWT Authentication)
- RestTemplate (for API calls)
- Hibernate ORM

### **Frontend (React.js)**
- React.js (with Hooks & React Router)
- Axios (for API calls)
- Bootstrap & Custom CSS

---
## Backend Setup (Spring Boot)
### Configure MySQL Database
Create a new MySQL database:
#### `CREATE DATABASE world_stats_hub;`
### Update application.properties:

#### `spring.datasource.url=jdbc:mysql://localhost:3306/world_stats_hub`
#### `spring.datasource.username=root`
#### `spring.datasource.password=yourpassword`
#### `spring.jpa.hibernate.ddl-auto=update`

### Run the Backend:
#### `mvn spring-boot:run`
The backend will start at http://localhost:8080.

## Frontend Setup (React.js)
### Install Dependencies
#### `npm install`
### Run the React App
#### `npm start`
The frontend will run at http://localhost:3000.

## API Endpoints

### Public Endpoints
| Method | Endpoint                     | Description                |
|--------|------------------------------|----------------------------|
| `GET`  | `/api/regions`               | Get all regions            |
| `GET`  | `/api/regions/{id}/countries` | Get countries in a region  |
| `GET`  | `/api/countries/{id}`         | Get a specific country     |

### Admin-Only Endpoints (CRUD)
| Method   | Endpoint                  | Description         |
|----------|--------------------------|---------------------|
| `POST`   | `/api/countries`          | Add a new country  |
| `PUT`    | `/api/countries/{id}`     | Update a country   |
| `DELETE` | `/api/countries/{id}`     | Delete a country   |

## Authentication & Security (Work in Progress)
**JWT authentication is currently under development.**  
**Admin login and token-based authentication are not fully implemented yet.**

### Planned Features:
- **Secure login using JWT**
- **Restrict CRUD operations to Admins only**
- **Token-based authentication for protected routes**

![Screenshot 2025-03-20 123638](https://github.com/user-attachments/assets/eb19d3f2-1293-4c48-af28-08efc29a2844)
![Screenshot 2025-03-20 123659](https://github.com/user-attachments/assets/d9b4a065-9c7d-44cb-9b3d-70cbd299a64c)
![Screenshot 2025-03-20 123710](https://github.com/user-attachments/assets/35b6e469-a38f-4343-9ed2-6dec91e6dd88)
![Screenshot 2025-03-20 123746](https://github.com/user-attachments/assets/bbc2e371-9cba-4fd3-b354-7c37abe07b71)
![Screenshot 2025-03-20 123754](https://github.com/user-attachments/assets/4a44de4e-045f-4fcb-a483-8967d86055de)

