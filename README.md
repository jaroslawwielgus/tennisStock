# Tennis Stock App - Spring Boot & Vue.js Web App
## Requirements
- browsing the catalog of rackets
- browsing the catalog of balls
- browsing the catalog of tennis strings
- browsing specification, description and image of each racket from catalog of rackets
- browsing specification, description and image of each ball from catalog of balls
- browsing specification, description and image of each tennis string from catalog of tennis strings

## Running, technologies and more info
Data of rackets, balls and tennis strings are stored in MySQL database which can be run in a Docker container.

To download the database image, run the following command:  
`docker pull mysql`.

To start mysql server instance use this:  
`docker run --name tennisstock-mysql -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=tennisStockDatabase -d -p 3306:3306 mysql`.


To run app in VS Code, install the following extensions:
- Spring Boot Extension Pack
- Project Manager for Java
- Lombok Annotations Support for VS Code.

First you need to run RestapiApplication.java, then you need to go to the frontend directory and run the following commands:  
`npm i`  and   `npm run serve`  




From the backend side, all CRUD type operations are implemented.  
All requirements have been implemented.


