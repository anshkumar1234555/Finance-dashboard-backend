💰 Finance Dashboard Backend
📌 Overview

This project is a backend system for managing financial records with role-based access control. It allows users to create, view, update, and delete financial data while enforcing permissions based on user roles.

🚀 Features
🔹 User & Role Management
Role-based access control:
Viewer → View data only
Analyst → View data + access summary
Admin → Full access (CRUD operations)
🔹 Financial Records Management
Create financial records
View all records
Update records
Delete records
Fields:
Amount
Type (income / expense)
Category
Date
Description
🔹 Dashboard Summary API

Provides aggregated data:

Total Income
Total Expense
Net Balance
🔹 Security
Basic Authentication
Role-based Authorization using Spring Security
🔹 Database
H2 Database (in-memory / file-based)
Easy testing via H2 Console
🛠️ Tech Stack
Java
Spring Boot
Spring Security
Spring Data JPA
H2 Database
Maven
📂 Project Structure
src/
 ├── controller
 ├── service
 ├── repository
 ├── model
 ├── config
🔗 API Endpoints
📌 Financial Records
Method	Endpoint	Description
GET	/api/records	Get all records
POST	/api/records	Create record
PUT	/api/records/{id}	Update record
DELETE	/api/records/{id}	Delete record
📊 Summary
Method	Endpoint	Description
GET	/api/records/summary	Get dashboard summary
🔐 Roles & Access Control
Role	Permissions
Viewer	Read only
Analyst	Read + Summary
Admin	Full access
▶️ How to Run
mvn spring-boot:run
🌐 H2 Database Console
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb (or file DB if configured)
Username: sa
Password: (leave empty)
🧪 Sample JSON (POST)
{
  "amount": 5000,
  "type": "income",
  "category": "salary",
  "date": "2026-04-02",
  "description": "monthly salary"
}
📈 Example Summary Output
{
  "totalIncome": 5000,
  "totalExpense": 2000,
  "netBalance": 3000
}
📌 Key Highlights
Clean layered architecture (Controller → Service → Repository)
Proper validation and error handling
Secure APIs with role-based access
Real-world backend design
🎯 Conclusion

This project demonstrates backend development skills including API design, security implementation, database handling, and business logic processing in a structured and maintainable way.
