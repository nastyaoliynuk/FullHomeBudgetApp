# Вибираємо базовий образ з JDK і Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Копіюємо весь проєкт у контейнер
COPY . /app
WORKDIR /app

# Збираємо додаток за допомогою Maven
RUN mvn clean package -DskipTests

# Запускаємо додаток з JDK
FROM eclipse-temurin:17
WORKDIR /app

# Копіюємо зібраний jar-файл з попереднього шару
COPY --from=build /app/target/*.jar app.jar

# Відкриваємо порт (залежно від вашої програми, зазвичай 8080)
EXPOSE 8080

# Команда запуску
ENTRYPOINT ["java", "-jar", "app.jar"]
