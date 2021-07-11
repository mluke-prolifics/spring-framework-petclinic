FROM jetty
ADD ./target/petclinic.war /var/lib/jetty/webapps/ROOT.war
EXPOSE 8080
USER jetty