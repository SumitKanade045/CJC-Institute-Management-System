# CJC Institute Management System (IMS)

## Project Overview
The CJC Institute Management System is a console-based Java application designed to manage institute information, including courses, faculty, batches, and students. It uses Java Collections to store and manage records in memory.

## Technologies Used
- Core Java
- Object-Oriented Programming (OOP)
- Interfaces and Implementation Classes
- Java Collections Framework
- `Map` and `LinkedHashMap`
- Exception Handling
- Scanner for User Input

## Project Structure
```text
CJC-IMS/
└── src/
    └── com/
        └── cjc/
            └── ims/
                └── app/
                    ├── client/
                    │   └── Test.java
                    ├── model/
                    │   ├── Course.java
                    │   ├── Faculty.java
                    │   ├── Batch.java
                    │   └── Student.java
                    ├── servicei/
                    │   └── Cjc.java
                    └── serviceimpl/
                        └── Karvenagar.java
```

## Features
1. Add and view courses.
2. Add and view faculty members.
3. Assign courses to faculty members.
4. Add and view batches.
5. Assign faculty members to batches.
6. Add and view students.
7. Assign students to batches.
8. Delete all or individual course, faculty, batch, and student records.

## Relationships
- A Faculty is assigned to a Course.
- A Batch is assigned to a Faculty.
- A Student is assigned to a Batch.

## How to Run
1. Open the project in Eclipse, IntelliJ IDEA, or VS Code.
2. Ensure all Java files are in their corresponding packages.
3. Run `Test.java` from the `com.cjc.ims.app.client` package.
4. Select an option from the console menu to manage institute records.

## Data Storage
The application uses `LinkedHashMap` collections to store records in memory. Data is not permanently saved in a database and will be lost when the application terminates.

## Learning Outcomes
This project demonstrates Java OOP concepts, interfaces, object relationships, collection management, CRUD operations, and exception handling.

## Author
Java Developer Fresher
