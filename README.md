## DevTester - Website

### Build App and Run - Locally
* BuildImage - `./gradlew buildImage`
* CreateNetwork - `docker network create devtester_network`
* Run db - `docker run --name mysql-container --rm --network devtester_network -e MYSQL_ROOT_PASSWORD=<password> -d mysql:5.7`
* Run app - `docker run --name website --rm --network devtester_network -p 8080:8080 JDBC_CONNECTION_STRING=<url> JDBC_USER=<user> JDBC_PASSWORD=<password> levelik/devtester-website:0.1`
    
### Docker Repo
* Login - `docker login` - add credentials
* PushImage - `docker push levelik/devtester-website:0.1`

### Changelog

#### [3.3] - 2020-04-22
- Migrate from PHP to Grails
- Cloud friendly app

#### [1.0] - 2014-09-01
- Init commit
