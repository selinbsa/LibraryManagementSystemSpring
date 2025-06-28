# 📚 Library Management System

This is a Java-based Library Management System developed with **Hibernate (JPA)** and **PostgreSQL** for database operations. It allows storing and managing books, authors, publishers, categories, and borrowings using object-relational mapping.

## 🚀 Technologies Used

- Java 21
- Hibernate (JPA)
- PostgreSQL
- Maven
- Jakarta Persistence
- IntelliJ IDEA

## 📦 Project Structure

src/
├── main/
│ ├── java/org/example/ # Main Java files
│ │ ├── entities/ # Entity classes (Book, Author, etc.)
│ │ └── Main.java # Entry point (data seeding)
│ └── resources/
│ └── META-INF/persistence.xml

## 🗄️ Database Design
The application consists of the following entities:

- `Author`: id, name, birth date, country
- `Publisher`: id, name, address, establishment year
- `Category`: id, name, description
- `Book`: id, name, publication year, stock, customerMail (unique), author, publisher, categories
- `BookBorrowing`: id, borrower name, borrowing and return dates, associated book

## ⚙️ Configuration

Make sure your `persistence.xml` is placed in `src/main/resources/META-INF/` and contains:

```xml
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             version="3.0">
    <persistence-unit name="LibraryManagement">
        <class>org.example.entities.Author</class>
        <class>org.example.entities.Publisher</class>
        <class>org.example.entities.Category</class>
        <class>org.example.entities.Book</class>
        <class>org.example.entities.BookBorrowing</class>

        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/librarydb"/>
            <property name="jakarta.persistence.jdbc.user" value="postgres"/>
            <property name="jakarta.persistence.jdbc.password" value="your_password"/>

            <property name="hibernate.hbm2ddl.auto" value="create"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>

## How to Run
Make sure PostgreSQL is running and a database named librarydb is created.

Clone the repository or open the project in IntelliJ IDEA.

Configure the PostgreSQL connection in persistence.xml.

Run the Main.java class. It will:

Create tables

Add sample data (author, publisher, category, book, etc.)

Check console output for success.
