# Tennis Stock App - Spring Boot & Vue.js Web App
## How it looks
![](https://github.com/jaroslawwielgus/tennisStock/blob/main/rakiety_i_rakieta_widok.gif)

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
`npm i`  and   `npm run serve`.  

To add rackets, balls, racket strings to database you can take use of the "data" folder which contains sample data in JSON format.  

From the backend side, all CRUD type operations are implemented.  
All requirements have been implemented.

## Views
1. Catalog of rackets:  

![image](https://user-images.githubusercontent.com/80279763/212596173-0709a499-a082-496c-8709-6c6b4eebaf08.png)


2. Catalog of balls:  

![image](https://user-images.githubusercontent.com/80279763/212596201-7157d659-b963-43df-9a63-e654c50517f9.png)


3. Catalog of tennis strings:  

![image](https://user-images.githubusercontent.com/80279763/212596225-78c4906c-a6bd-46aa-b411-21731932f2d1.png)


4. Racket:  

![image](https://user-images.githubusercontent.com/80279763/212596284-b09daff6-eeb6-4874-9f94-d085f27097b6.png)


5. Ball:  

![image](https://user-images.githubusercontent.com/80279763/212596269-23a7959c-c243-43f3-8b91-2686a6d88959.png)


6. Tennis string:    

![image](https://user-images.githubusercontent.com/80279763/212596236-c43bb643-7523-473c-8a36-67c3aae7603b.png)


