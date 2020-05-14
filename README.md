# test-debug-app
Simple application to show different testing leveles in bank account application. The end-user can increase and withdraw the account balance with REST messages and UI.

# system diagram
![System diagram](http://www.plantuml.com/plantuml/png/3SdB2SCm303GLTe1OjsxJ55auGWisUX3wVR9xS5xYz6ipkNpTMNk-00u_jgGlEgiOATboPQDbe8AXGmsI8uyEfyr3jmR52FP8PmUYe5ph7BYWFW_ezykE1orxT9v0m00)

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
