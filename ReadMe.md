🔗 URL Shortener with Analytics

A full-stack URL shortener application that allows users to shorten long URLs and track real-time analytics such as click count, creation time, and last accessed time.

Built with Spring Boot, MySQL, and React, following clean architecture and REST API best practices.

✨ Features

🔗 Shorten long URLs into compact short links

🔁 Redirect short URLs to the original long URL

📊 Track analytics:

Click count

Created date

Last accessed date

Optional expiration time

♻️ Reuse existing short URLs for the same long URL

✅ Input validation with global exception handling

🖥️ Clean, responsive React UI

🌐 RESTful API design

🧱 Tech Stack
Backend

Java 21

Spring Boot

Spring Data JPA

Hibernate

MySQL

Maven

Frontend

React

Vite

Fetch API

CSS

📂 Project Structure
url-shortener/
│
├── backend/
│   ├── src/main/java/com/example/url_shortener
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── entity
│   │   ├── dto
│   │   ├── exception
│   │   └── config
│   └── src/main/resources
│       └── application.properties
│
├── frontend/
│   ├── src/
│   │   ├── App.jsx
│   │   ├── App.css
│   │   └── main.jsx
│   ├── index.html
│   └── vite.config.js
│
└── pom.xml

🚀 How It Works

User enters a long URL in the frontend

React sends a request to the Spring Boot backend

Backend:

Generates a unique Base62 short code

Stores it in MySQL

Returns the shortened URL

Visiting the short URL:

Redirects to the original URL

Updates analytics in real time

Analytics can be fetched via API and displayed in the UI

📡 API Endpoints
Create Short URL
POST /api/shorten


Request Body

{
  "longUrl": "https://example.com"
}


Response

{
  "shortCode": "AGVOLVG",
  "shortUrl": "http://localhost:8080/r/AGVOLVG"
}

Redirect to Original URL
GET /r/{shortCode}

Get URL Analytics
GET /api/stats/{shortCode}


Response

{
  "shortCode": "AGVOLVG",
  "longUrl": "https://example.com",
  "clickCount": 3,
  "createdAt": "2026-02-02T01:18:57",
  "lastAccessedAt": "2026-02-02T01:41:26",
  "expiresAt": null
}

🛠️ Running the Project Locally
Backend

Create a MySQL database

CREATE DATABASE url_shortener_db;


Update application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/url_shortener_db
spring.datasource.username=root
spring.datasource.password=your_password


Run the backend

cd backend
mvn spring-boot:run

Frontend
cd frontend
npm install
npm run dev


Frontend runs on:

http://localhost:5173


Backend runs on:

http://localhost:8080

📸 Screenshots

<img width="806" height="870" alt="Screenshot 2026-02-03 131508" src="https://github.com/user-attachments/assets/3f937d4d-39c1-4d98-ab23-ce104b11b753" />
<img width="646" height="811" alt="Screenshot 2026-02-03 132415" src="https://github.com/user-attachments/assets/98c4b299-486d-4577-8fcf-0e395d8cd82c" />

🎯 Why This Project?

This project demonstrates:

Backend API design

Database modeling

Analytics handling

Full-stack integration

Clean code structure

Real-world system design concepts

👤 Author

Vipul Singh

If you found this project interesting, feel free to ⭐ the repository.
