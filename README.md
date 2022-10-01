# REST API for an Bus Reservation System Portal 

* We have developed this REST API for an Bus Reservation System Portal Application. This API performs all the fundamental CRUD operations of any Bus Application platform with user validation at every step, Includes login signup models.
* This project is developed by team of 5 Back-end Developers during project week in Masai School. 

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Swagger

## Modules

* Login, Logout Module
* User Module
* Admin Module

## Features

* User and Admin authentication & validation with session uuid having.
* Admin Features:
    * Administrator Role of the entire application
    *------------------------------------need updation
    * -------------------------------------------------need updation.
* User Features:
    * A user can register himself or herself on the platform.
    * He/She can check the bus route and  bus availablity.
    * If bus is available, can reserve seat too.
    * After booking a bus, he will get bus details for start his/her journey.    


## Contributors

* [@Adarsh Khatri](https://github.com/AdarshKhatri1)
* [@Brajkishor Tomar](https://github.com/BKS2315)
* [@Vinay Kumar](https://github.com/vinaykumar2n)
* [@Pintu Kumar](https://github.com/pintu903)
* [@Sudarshan Chavan](https://github.com/Sudarshan2530)




## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/BusReservationSystemPortal/src/main/resources/application.properties) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8080

    spring.datasource.url=jdbc:mysql://localhost:3306/busdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

## AWS Deployed link
`http://will be updated`

## API Root Endpoint

`https://localhost:8080/`

`http://localhost:8080/swagger-ui/`


## API Module Endpoints

### Login Module

* `POST //api/adminlogin` : Admin can login with mobile number and password provided at the time of registation
<!--
### User Module


* `POST /customer/login` : Logging in customer with valid mobile number & password
* `GET /customer/availablecabs` : Getting the list of all the available cabs
* `GET /customers/cabs` : Getting All the cabs
* `GET /customers/checkhistory` : Getting the history of completed tr
* `PUT /customer/update/{mobile}` : Updates customer details based on mobile number
* `PATCH /customer/updatepassword/{mobile}` : Updates customer's password based on the given mobile number
* `POST /customer/booktrip` : Customer can book a cab
* `POST /customer/updatetrip` : Customer can modify or update the trip
* `POST /customer/logout` : Logging out customer based on session token
* `DELETE /customer/delete` : Deletes logged in user 
* `DELETE /customer/complete/{tripid}` : Completed the trip with the given tripid 
* `DELETE /customer/canceltrip` : Cancel the trip with the given tripid   


### Admin Module

* `POST /admin/register` : Register a new admin with proper data validation and admin session
* `POST /admin/login` : Admin can login with mobile number and password provided at the time of registation
* `GET /admin/logout` : Logging out admin based on session token
* `GET /admin/listoftripsbycustomer` : Get list of trips of by a customer id
* `GET /admin/listoftrips` : Get list of trips of all the trips
* `GET /admin/listocustomers` : Get list of all the customers
* `GET /admin/listodrivers` : Get list of all the drivers
* `PUT /admin/update/{username}` : Updates admin detaisl by passed user name
* `DELETE /admin/delete` : Deletes the admin with passed id   -->


### Sample API Response for Admin Login

`POST   localhost:8080/login/adminlogin`

* Request Body

```
    {
        "mobileNo": "7056319981",
        "password": "Clickme@007"
    }
```

* Response

```
   CurrentAdminSession( adminId=10, uuid=ZaVLaK,localDatetime=2022-10-01 12:29:52.376508)
   
```

## Video Explainer of flow control
 <a href="link will be updaate here">**There is no video yet** </a>
 
### E-R Diagram Of Bus Application
---
<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/ER%20Diagram.jpeg?raw=true" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### Swagger UI

---

<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/AllController.jpg?raw=true" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### User and User Login Controller

---

<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/User%26UserLoginController.jpg" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### Admin and Admin Login Controller

---

<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/admin%26adminlogincontroller.jpg?raw=true" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### Bus Controller

---

<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/BusController.jpg?raw=true" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### Reservation Controller

---

<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/ReservationController.jpg?raw=true" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### Route Controller

---

<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/RouteController.jpg?raw=true" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### Feedback Controller

---

<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/FeedbackController.jpg?raw=true" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/Thankyou.jpg?raw=true" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---
