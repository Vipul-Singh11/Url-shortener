# 🔗 URL Shortener with Analytics

A full-stack URL Shortener application built using **Spring Boot (Java)** for the backend and **React (Vite)** for the frontend.  
The application allows users to shorten long URLs and view real-time analytics such as click count, creation time, and last accessed time.

---

## 🌐 Live Demo

- **Frontend:** https://url-shortener-eight-ruddy.vercel.app/
- **Backend:** https://url-shortener-backend-6u50.onrender.com

---

## ✨ Features

- 🔗 Shorten long URLs into compact, shareable links
- ♻️ Reuse existing short URLs for the same long URL
- 📊 Real-time analytics:
  - Click count
  - Created timestamp
  - Last accessed timestamp
- ⏳ Optional expiration support
- 📋 One-click copy to clipboard
- 🎨 Clean, responsive, single-page UI
- ⚠️ Backend validation & global exception handling
- 🌍 Timezone-safe timestamp display (UTC → local)

---

## 🖥️ Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL (Supabase)
- Maven

### Frontend
- React
- Vite
- CSS (custom styling)

---

## 📂 Project Structure

```text
url-shortener/
│
├── backend/                  # Spring Boot backend
│   ├── src/main/java/com/example/url_shortener
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── entity
│   │   ├── dto
│   │   ├── exception
│   │   └── config
│   ├── src/main/resources
│   │   └── application.properties
│   ├── pom.xml
│   └── mvnw / mvnw.cmd
│
├── frontend/                 # React frontend (Vite)
│   ├── src
│   │   ├── App.jsx
│   │   ├── App.css
│   │   └── main.jsx
│   ├── index.html
│   ├── package.json
│   └── vite.config.js
│
└── README.md
```

## 🚀 How to Run the Project Locally

### Backend Setup

#### Prerequisites
- Java 21
- Maven
- PostgreSQL running locally

Verify installation:
java -version
mvn -version


---

#### 1. Create Database

Create a PostgreSQL database:
url_shortener_db


---

#### 2. Configure application.properties

Edit:
backend/src/main/resources/application.properties


Add:
spring.datasource.url=jdbc:postgresql://localhost:5432/url_shortener_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


---

#### 3. Run Backend

cd backend
mvn spring-boot:run


Backend runs at:
http://localhost:8080


---

### Frontend Setup

cd frontend
npm install
npm run dev


Frontend runs at:
http://localhost:5173


Create a `.env` file in `frontend/`:
VITE_API_BASE_URL=http://localhost:8080


---

## 🔁 API Endpoints

### Shorten URL
POST /api/shorten


Request body:
{
"longUrl": "https://example.com"
}


---

### Redirect
GET /r/{shortCode}


---

### Get Analytics
GET /api/stats/{shortCode}


Example response:
{
"shortCode": "AGVOLVG",
"longUrl": "https://example.com",
"clickCount": 5,
"createdAt": "2026-02-02T01:18:57",
"lastAccessedAt": "2026-02-02T13:09:18",
"expiresAt": null
}


---

## 🎨 UI Preview

- Single-page card-based layout
- Gradient background
- Real-time analytics display
- Copy button with feedback

<img width="1200" height="800" alt="url-shortener" src="https://github.com/user-attachments/assets/83431d29-07a0-4da8-8c53-e8a21c033fe1" />


---

## 📌 Notes

- Backend and frontend are maintained in the same repository
- Environment variables are used for production configuration
- Backend is deployed on Render
- Frontend is deployed on Vercel
- Database is hosted on Supabase (PostgreSQL)

---

## 🧑‍💻 Author

Vipul Singh

Built as a learning-focused full-stack project showcasing backend + frontend integration, cloud deployment, and production debugging.

---

⭐ If you like this project, feel free to star the repository!
