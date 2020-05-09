## DevTester - Website

### Build App and Run - Locally
* BuildImage - `./gradlew buildImage`
* CreateNetwork - `docker network create devtester_network`
* Run db - `docker run --name mysql-container --rm --network devtester_network -e MYSQL_ROOT_PASSWORD=<password> -d mysql:5.7`
* Run app - `docker run --name website --rm --network devtester_network -p 8080:8080 JDBC_CONNECTION_STRING=<url> JDBC_USER=<user> JDBC_PASSWORD=<password> <user>/devtester-website:3.5`
    
### Docker Repo
* Login - `docker login` - add credentials
* PushImage - `docker push <user>/devtester-website:3.5`

### Changelog
- View - [changelog](https://devtester.ro/about#changelog)
