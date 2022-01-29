# Application
Simple application to show different testing leveles in bank account application. The end-user can increase and withdraw the account balance with REST messages and UI.

# System diagram
![System diagram](https://www.plantuml.com/plantuml/png/bPBDQkim48NtVeh1XalkmZSlS2aXf9GiIWjjLg6KiJKu8hRaIAEQ4lBkbHtbnpPfgLT7qdUEHZEUMKR3hYeZGpcZAag2UBK49iin9Cr6UbNfBS4-YW0kq7fkT6F9mFy_sL7TlG5Q28iMNhSXgQ3C5IdMTUfaHpW9IQ5BqOkBbugfCCXIgrkN0zIORx7mT3_PiwKiDfoLhaKXV9E_43_Sly8KyrmxnTEz58UuBM7do7o-anArbeeXgNoeOkmvdvzUhgo2QcqbT-wWV-Ll96-4mQOBE2r-IbXT0ZfVRWYPpgupl9uxAnLP2vRCXyofwtFGPshmw3GT4U5XtpBZsiVGiD0XScYdsPl-0Xapj7HZaY8SG_oeLQ4Ny-CSCaXmv_0wCrm3gT2D-kUHRZVybATT9pti7U3LSI-T3DhJFnisfdywQabqY6PUkwhy0W00)

# Requirement
JAVA 8
Gradle 6.3
Docker Compose

# Run
1. Run the MongoDB DBMS: docker-compose up
2. Start the application: gradle bootRun

# Endpoints
GET /account/{id}
POST /account/increase
POST /account/withdraw

# Examples
POST /account/increase
{
    user: 1
    amount: 10
}

POST /account/withdraw
{
    user: 1
    amount: 10
}
