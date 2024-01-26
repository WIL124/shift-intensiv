FROM maven:3-openjdk-11
COPY / /application
CMD cd /application
CMD mvn clean test || true
CMD mvn allure:install
EXPOSE 8090
CMD mvn test || true
CMD mvn allure:report || true
CMD mvn allure:serve