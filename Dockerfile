FROM bitnami/tomcat:latest
ADD ./target/petclinic.war /opt/bitnami/tomcat/webapps_default
EXPOSE 8080
