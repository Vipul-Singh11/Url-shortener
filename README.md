# 🔗 URL Shortener with Analytics

A full-stack URL Shortener application built using **Spring Boot (Java)** for the backend and **React (Vite)** for the frontend.  
The application allows users to shorten long URLs and view real-time analytics such as click count, creation time, and last accessed time.

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

---

## 🖥️ Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

### Frontend
- React
- Vite
- CSS (custom styling)

---

## 📂 Project Structure

```
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

---

## 🚀 How to Run the Project Locally

### 1️⃣ Backend Setup

- Make sure **MySQL** is running
- Create a database (example):
  ```
  url_shortener_db
  ```

- Update `application.properties` if needed:
  ```
  spring.datasource.url=jdbc:mysql://localhost:3306/url_shortener_db
  spring.datasource.username=YOUR_USERNAME
  spring.datasource.password=YOUR_PASSWORD
  ```

- Run the backend:
  ```
  cd backend
  mvn spring-boot:run
  ```

Backend runs at:
```
http://localhost:8080
```

---

### 2️⃣ Frontend Setup

```
cd frontend
npm install
npm run dev
```

Frontend runs at:
```
http://localhost:5173
```

---

## 🔁 API Endpoints

### Shorten URL
```
POST /api/shorten
```

Request body:
```
{
  "longUrl": "https://example.com"
}
```

---

### Redirect
```
GET /r/{shortCode}
```

---

### Get Analytics
```
GET /api/stats/{shortCode}
```

Example response:
```
{
  "shortCode": "AGVOLVG",
  "longUrl": "https://example.com",
  "clickCount": 5,
  "createdAt": "2026-02-02T01:18:57",
  "lastAccessedAt": "2026-02-02T13:09:18",
  "expiresAt": null
}
```

---

## 🎨 UI Preview

- Single-page card-based layout
- Gradient background
- Real-time analytics display
- Copy button with feedback
- 
<img width="646" height="811" alt="Screenshot 2026-02-03 131508" src="https://github.com/user-attachments/assets/e9ddb947-178f-45a0-9978-c7c429a7c451" />
<img width="646" height="811" alt="Screenshot 2026-02-03 132415" src="https://github.com/user-attachments/assets/dfc307f8-942e-4e65-a061-1bce6039deac" />

(See screenshots above)

---

## 📌 Notes

- Backend and frontend are kept **in the same repository** for easy development
- `target/` is ignored via `.gitignore`
- `.vscode`, `.mvn`, and wrapper files are intentionally committed for consistency

---

## 🧑‍💻 Author

**Vipul Singh**

Built as a learning-focused full-stack project showcasing backend + frontend integration.

---

⭐ If you like this project, feel free to star the repository!
