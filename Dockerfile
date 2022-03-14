FROM maven:3.6.1-jdk-8 as maven-app

ENV BASE_DIR /opt/user-manager 

WORKDIR ${BASE_DIR} 
COPY ./ ${BASE_DIR} 

RUN mvn clean install -DskipTests=true

FROM openjdk:8u212-jre-slim

EXPOSE 7088

ARG DEFAULT_PROFILE=local
ENV DEFAULT_PROFILE_ENV ${DEFAULT_PROFILE}

ENV BASE_DIR /opt/user-manager
ENV DEFAULT_JAR_NAME user-manager-0.0.1-SNAPSHOT.jar
ENV JAR_PATH target/${DEFAULT_JAR_NAME}

WORKDIR ${BASE_DIR}
COPY --from=maven-app ${BASE_DIR}/${JAR_PATH} ${BASE_DIR}
ENTRYPOINT exec java -Dspring.profiles.active=${DEFAULT_PROFILE_ENV} -jar ${BASE_DIR}/${DEFAULT_JAR_NAME} com.dockerexample.usermanager.UserManagerApplication
