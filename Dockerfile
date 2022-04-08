FROM bitnami/wildfly:latest
ADD target/spring-swaggerDemo.war /opt/bitnami/wildfly/standalone/deployments/
RUN /opt/bitnami/wildfly/bin/add-user.sh admin Admin#70365 --silent
CMD ["/opt/bitnami/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]