# MiniCasino

A simple casino game backend implemented in Java using Spring Boot.

## Main features

- Storing user info safely, encrypted
- Sensitive data is never sent raw
- Easily expandable Bet-base

## Prerequisites

- Java 17 or newer (JDK)
- Maven (mvn)
- Git (optional, for cloning)
- Command line (PowerShell, CMD, Bash, etc.)

## Step-by-Step Guide to Run

### 1. Clone the Repository (if needed)
If you haven't already, clone the project:
```powershell
git clone <repo-url>
cd MiniCasino
```

### 2. Build the Project
Use Maven to build the project:
```powershell
./mvnw clean package
```
Or, if you have Maven installed globally:
```powershell
mvn clean package
```

### 3. Run the Application
After building, run the Spring Boot application:
```powershell
./mvnw spring-boot:run
```
Or, with global Maven:
```powershell
mvn spring-boot:run
```

Alternatively, run the JAR directly:
```powershell
java -jar target/MiniCasino-<version>.jar
```
Replace `<version>` with the actual version number from the `target` folder.

### 4. Access the Application
By default, the backend will be available at:
```
http://localhost:8080
```

### 5. Configuration
- Edit `src/main/resources/application.properties` or `application.yml` to change settings (e.g., port, database).

### 6. Running Tests
To run tests:
```powershell
./mvnw test
```
Or:
```powershell
mvn test
```

## Troubleshooting
- Ensure Java and Maven are in your PATH.
- If you get permission errors, try running commands as administrator.
- For Windows, use `mvnw.cmd` instead of `./mvnw` if needed.

## Useful Commands
- Build: `mvn clean package`
- Run: `mvn spring-boot:run` or `java -jar target/MiniCasino-<version>.jar`
- Test: `mvn test`

## Project Structure
```
MiniCasino/
├── README.md
├── pom.xml
├── mvnw / mvnw.cmd
├── compose.yaml
├── HELP.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── pa/
│   │   │       └── minicasino/
│   │   │           ├── MiniCasinoApplication.java
│   │   │           ├── auth/
│   │   │           │   └── JwtAuthenticationProvider.java
│   │   │           ├── configuration/
│   │   │           │   ├── Config.java
│   │   │           │   └── SecurityConfig.java
│   │   │           ├── controller/
│   │   │           │   ├── BetController.java
│   │   │           │   └── PlayerController.java
│   │   │           ├── entity/
│   │   │           │   └── PlayerEntity.java
│   │   │           ├── exception/
│   │   │           │   └── InvalidBetException.java
│   │   │           ├── filter/
│   │   │           │   └── JwtFilter.java
│   │   │           ├── gameLogic/
│   │   │           │   ├── BetType.java
│   │   │           │   └── DiceRoller.java
│   │   │           ├── model/
│   │   │           │   ├── BetModel.java
│   │   │           │   ├── BetTypeData.java
│   │   │           │   ├── PlayerDetails.java
│   │   │           │   ├── PlayerModel.java
│   │   │           │   └── ResultModel.java
│   │   │           ├── repository/
│   │   │           │   └── PlayerRepository.java
│   │   │           ├── service/
│   │   │           │   ├── BetService.java
│   │   │           │   ├── PlayerDetailsService.java
│   │   │           │   └── PlayerService.java
│   │   │           └── util/
│   │   │               ├── JwtUtil.java
│   │   │               └── Util.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application.yml
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/
│           └── pa/
│               └── minicasino/
│                   ├── ManualDBTest.java
│                   ├── MiniCasinoApplicationTests.java
│                   ├── gameLogic/
│                   │   └── BetTypeTest.java
│                   └── service/
│                       ├── BetServiceTest.java
│                       └── PlayerServiceTest.java
└── target/
    └── ... (build output)
```

---

For more details, see the source code and configuration files.

# Creator

Balázs Dénes Róbert
