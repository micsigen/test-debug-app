# Application
Simple application to show different testing leveles in bank account application. The end-user can increase and withdraw the account balance with REST messages and UI.

# System diagram
![System diagram](https://www.plantuml.com/plantuml/png/bPBDQkim48NtVeh1XalkmZSlS2aXf9GiIWjjLg6KiJKu8hRaIAEQ4lBkbHtbnpPfgLT7qdUEHZEUMKR3hYeZGpcZAag2UBK49iin9Cr6UbNfBS4-YW0kq7fkT6F9mFy_sL7TlG5Q28iMNhSXgQ3C5IdMTUfaHpW9IQ5BqOkBbugfCCXIgrkN0zIORx7mT3_PiwKiDfoLhaKXV9E_43_Sly8KyrmxnTEz58UuBM7do7o-anArbeeXgNoeOkmvdvzUhgo2QcqbT-wWV-Ll96-4mQOBE2r-IbXT0ZfVRWYPpgupl9uxAnLP2vRCXyofwtFGPshmw3GT4U5XtpBZsiVGiD0XScYdsPl-0Xapj7HZaY8SG_oeLQ4Ny-CSCaXmv_0wCrm3gT2D-kUHRZVybATT9pti7U3LSI-T3DhJFnisfdywQabqY6PUkwhy0W00)

# Requirement
1. JAVA 11
2. Gradle 6.3
3. Docker Compose

# Run
1. Download and start the latest MongoDB: 
   > docker-compose up -d
2. Start the application with gradle wrapper: 
   > ./gradlew bootRun

The application run on default:
- server port: 8000
- management port: 9000 (/actuator/health supported)

# Endpoints
1. GET /account/{id} : return the specified account by account identifier
2. POST /account/withdraw : withdraw amount
3. POST /account/deposit : deposit ammount
4. PUT /account : create new account

# Examples
1. Increase amount of specified account with 10$

_POST /account/deposit_
>{
>    user: 1
>    amount: 10
>}

2. Withdraw amount of specified account with 10$

_POST /account/withdraw_
>{
>    user: 1
>    amount: 10
>}

3. Get actual balance of acount #1

_GET /account/1_
> {
>    "id": "1",
>    "name": "Foo",
>    "balance": 0.0
>}

The corresponding Postman scripts are placed under _src/resources_ folder.

