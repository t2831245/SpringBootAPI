## build app as an image:
    mvn spring-boot:build-image

## how to start:
    docker-compose up -d
    docker-compose down

## api:
`post http://127.0.0.1:8080/accounts
{
    "username":"abc",
    "password": "123AaCc"
}`

`put http://127.0.0.1:8080/accounts/validation
{
    "username":"abc",
    "password": "123AaCc"
}`