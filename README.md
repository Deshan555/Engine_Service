# 📧 Template Engine API 🚀

Welcome to the Email Template API documentation! This API allows you to effortlessly create, manage, and store email templates in a MongoDB database. Whether you're building a newsletter system, notification service, or any application requiring email templates, this API has you covered. 💌💼

## 📋 Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Data Model](#data-model)
- [Getting Started](#getting-started)
- [Contributing](#contributing)
- [License](#license)

## 🌟 Introduction

The Email Template API is a robust RESTful web service developed with Spring Boot and MongoDB. It simplifies email template management, offering a range of operations: create, retrieve, update, and delete templates. Whether you're a developer or part of a team, this API makes managing email templates a breeze. 🚀🌐

## ✅ Prerequisites

Before you dive in, make sure you have the following:

- **Java**: Ensure Java is installed on your system, as the API is built with Java and Spring Boot. ☕

- **MongoDB**: MongoDB should be up and running, as this API stores email templates in it. 📊🏢

- **Maven**: Maven is necessary for building and running the project. Make sure it's installed. 🛠️📦

- **IDE**: For smoother development, consider using an integrated development environment like IntelliJ IDEA or Eclipse. 💻🧰

## 🏗️ Project Structure

Our project adheres to the standard Spring Boot application structure. Here are the key components:

- **Controllers**: `Template_Controller` contains REST endpoints for managing email templates. 🎮🌐

- **Services**: `Template_ServiceIMPL` provides the business logic for template management. 🛠️📋

- **Entity**: The `Template` class defines the data model for email templates, mapped to a MongoDB collection. 📂📄

- **Configuration**: MongoDB connection settings are configured in the `MongoDBConfig` class. ⚙️🏢

## 🚀 API Endpoints

The Email Template API offers the following endpoints:

1. **Create New Template**
   - **Endpoint**: `POST /api/engine/v01/new`
   - **Description**: Create a new email template and save it in MongoDB.
   - **Request Body**: JSON representing the email template (see [Data Model](#data-model)).
   - **Response**: JSON response indicating success or failure. ✉️✨

2. **Get Template By ID**
   - **Endpoint**: `GET /api/engine/v01/look/id/{id}`
   - **Description**: Retrieve an email template by its ID.
   - **Path Parameter**: `id` - The ID of the template to retrieve.
   - **Response**: JSON response containing the template data or an error message. 🔍🆔

3. **Get Template Filter By Template Name**
   - **Endpoint**: `GET /api/engine/v01/look/name/{templateName}`
   - **Description**: Retrieve an email template by its name.
   - **Path Parameter**: `templateName` - The name of the template to retrieve.
   - **Response**: JSON response containing the template data or an error message. 🔍📝

4. **Get All Templates**
   - **Endpoint**: `GET /api/engine/v01/all`
   - **Description**: Retrieve all email templates stored in the database.
   - **Response**: JSON response containing a list of all templates or an error message. 🔍📂

5. **Get All Templates Filtered By Type**
   - **Endpoint**: `GET /api/engine/v01/all/{type}`
   - **Description**: Retrieve all email templates of a specific type.
   - **Path Parameter**: `type` - The type of templates to retrieve.
   - **Response**: JSON response containing a list of templates of the specified type or an error message. 🔍📂

6. **Update Template By ID**
   - **Endpoint**: `PUT /api/engine/v01/update/{templateID}`
   - **Description**: Update an existing email template by its ID.
   - **Path Parameter**: `templateID` - The ID of the template to update.
   - **Request Body**: JSON representing the updated template data (see [Data Model](#data-model)).
   - **Response**: JSON response indicating success or failure. 🔄📝

7. **Delete Template By ID**
   - **Endpoint**: `DELETE /api/engine/v01/delete/{templateID}`
   - **Description**: Delete an email template by its ID.
   - **Path Parameter**: `templateID` - The ID of the template to delete.
   - **Response**: JSON response indicating success or failure. ❌🗑️

## 📊 Data Model

The data model for email templates is defined by the `Template` class, which includes the following fields:

- `id`: The unique identifier for the template.
- `templateName`: The name of the template.
- `subject`: The subject of the email template.
- `body`: The body content of the email template.
- `templateType`: The type or category of the template.
- `createdDate`: The timestamp when the template was created. 📄🗃️

## 🚀 Getting Started

To begin using the Email Template API, follow these steps:

1. Clone the project repository.

2. If necessary, configure MongoDB connection settings in the `MongoDBConfig` class.

3. Build the project using Maven: `mvn clean install`.

4. Run the Spring Boot application: `mvn spring-boot:run`.

5. Access the API endpoints as described in the [API Endpoints](#api-endpoints) section. 🏃‍♂️💨

## 🤝 Contributing

Contributions to this project are encouraged. Feel free to open issues, submit pull requests, or suggest improvements. Together, we can make this API even better. 🤗🛠️

## 📜 License

This project is licensed under the [MIT License](LICENSE). You're welcome to use and modify it as needed for your own projects. 📝📋
