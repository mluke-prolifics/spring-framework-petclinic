FROM bitnami/tomcat:9.0
ADD ./target/petclinic.war /opt/bitnami/tomcat/webapps_default
EXPOSE 8080
