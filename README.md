# 📚 Exam Management System (Standalone)

## 🚀 Project Overview
The **Exam Management System** is a standalone Java-based application built using the Swing framework and MySQL database. This system allows administrators to manage exams, students, and results efficiently.

## 🛠️ Tech Stack
- **Programming Language:** Java (JDK 11 required)
- **Framework:** Swing (Java GUI)
- **Database:** MySQL (XAMPP Server)
- **IDE:** NetBeans (Recommended)

## 📂 Project Setup Guide
### 🔹 Prerequisites
1. Install **JDK 11**.
2. Install **XAMPP** (for MySQL database).
3. Install **NetBeans IDE**.
4. Download and add the required JAR files to the project:
   - `mysql-connector-java-8.0.30.jar`
   - `xdatepicker-support-1.0.jar`
   - `jcalendar-1.2.2.jar`
   - `jxdatepicker-support-1.0.jar`

### 🔹 Adding JAR Libraries to NetBeans
1. Open **NetBeans IDE**.
2. Right-click on the **Libraries** folder of the project.
3. Click **Add JAR/Folder...**.
4. Browse and select the required JAR files.
5. Click **Open** to import them into the project.

### 🔹 Adding a New Palette in NetBeans (for UI Components)
1. Open **NetBeans IDE**.
2. Navigate to **Tools > Palette > Swing/AWT Components**.
3. Click **Add from JAR...**.
4. Select the `jcalendar-1.2.2.jar` file.
5. Choose the required components and click **Next**.
6. Assign a suitable category and finish the process.

## 📦 Database Setup (XAMPP)
There are **two ways** to set up the database:

### 🔹 Method 1: Using the Backup & Restore Program
1. Open **XAMPP Control Panel** and start **MySQL**.
2. Create a new database named **`oes2`**.
3. Go to **D:\ (This PC)** and create a folder named **"Database Backup & Restore"**.
4. Add the `.sql` file (available in the repository) to this folder.
5. Open the project and run `backup_restore.java`.
6. Click the **Restore** button – this will automatically import the database.

### 🔹 Method 2: Manual Import
1. Open **XAMPP Control Panel** and start **MySQL**.
2. Open **phpMyAdmin** (http://localhost/phpmyadmin/).
3. Create a new database named **`oes2`**.
4. Click **Import** and select `oes2.sql` from the repository.
5. Click **Go** – this will import the database manually.

## 🎯 Features
✅ User-friendly UI built with Java Swing  
✅ Database-driven exam management  
✅ Secure login system  
✅ Student and administrator modules  
✅ Automated backup and restore feature  

## 🤝 Contributing
Feel free to fork this repository and contribute. If you encounter any issues, create a new issue in the repository.

## 📜 License
This project is open-source and available under the **MIT License**.

---
📌 **Author:** Your Name  
📌 **GitHub Repository:** https://github.com/siddhant-fast-codeing/Exam-Management.git
📌 **Contact:** siddhant8796@gmail.com

