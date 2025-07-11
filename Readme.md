# NirajBhandariJavaFXApp

## 📘 Overview
This JavaFX application connects to a MySQL database and displays student data in a TableView. Data is fetched and displayed when the user clicks a button.

---

## ✅ Features

- GUI built with JavaFX
- Connects to MySQL using JDBC
- Loads and displays data from `students` table
- Button click triggers data retrieval

---

## 🗄️ MySQL Setup

```sql
CREATE DATABASE IF NOT EXISTS school_db;
USE school_db;

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    program VARCHAR(100)
);

INSERT INTO students (id, name, program) VALUES
(1, 'Niraj Bhandari', 'Computer Programming'),
(2, 'Alex Johnson', 'Software Engineering'),
(3, 'Priya Sharma', 'Information Technology'),
(4, 'Daniel Kim', 'Cybersecurity'),
(5, 'Lina Wong', 'Artificial Intelligence');
Some of the codes are through Ai. I have also used websites like W3Schools.
👤 Author
Name: Niraj Bhandari

Student ID: 123456789

Date: 2025-07-10
