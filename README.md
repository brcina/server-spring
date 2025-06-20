server-spring
=============

Mini application to write a server serving rest resources to be used by js app

### Prerequisites

* Java 17
* Gradle

### Development

* Create your own `setenv.sh`
```bash
export SONAR_TOKEN=<Your Personal Sonar Token>
```
> check https://docs.sonarsource.com/sonarqube-server/latest/user-guide/managing-tokens/ for instructions how create it

* Build it
```bash
./gradlew clean build -x test
```

* Test it
```bash
./gradlew test
``` 

* Run  it
```bash
./gradlew bootRun
```

* Quality check
```bash
./gradlew sonar
```




