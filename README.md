# test-debug-app
Simple application to test and debug in different tools.

# Requirement
JAVA 14
Gradle

# Run
gradle bootRun

# Endpoints
POST /account/increase
POST /account/withdraw

# Examples
POST /account/increase
{
    user: 1
    amount: 10
}

{
    user: 1
    amount: 10
}

POST /account/withdraw
{
    user: 1
    amount: 10
}

{
    user: 1
    amount: 0
}
