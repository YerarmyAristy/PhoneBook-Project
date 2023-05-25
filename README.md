# PhoneBookApp

This repository contains the PhoneBook Project, a Java Spring Boot application with Angular CLI for managing contacts in a phonebook.

## Features

- Add a new contact with first name, phone number, and email address.
- View the list of existing contacts.
- Edit an existing contact.
- Delete a contact from the phonebook.

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Angular CLI (for frontend templating)
- PostgreSQL (as the database)

## Local Deployment

To deploy the PhoneBookApp locally, follow these steps:

### Prerequisites

- Java Development Kit (JDK) 8 or above
- Apache Maven or Gradle
- Node.js and npm (Node Package Manager)
- PostgreSQL

### Backend Deployment

1. Navigate to the backend directory:

   ```shell
   cd SBS/phoneBook

2. Build the backend:
	mvn clean install

3. Configure the database connection in the src/main/resources/application.properties file.

4. Run the backend server:

For Maven:
	mvn spring-boot:run 
  
  
  ### Frontend Deployment
1. Navigate to the frontend directory:
    ```shell
      cd frontend

3. Install the project dependencies:
       ```shell
        npm install

5.  Build the frontend:

       ```shell
       ng build --prod
  
 4.The production-ready build files will be generated in the dist/ directory.

Accessing the Application
Once both the backend and frontend are deployed:

1. Open a web browser and navigate to http://localhost:4200/ to access the application.

2. You can now use the PhoneBookApp to manage contacts in the phonebook.


