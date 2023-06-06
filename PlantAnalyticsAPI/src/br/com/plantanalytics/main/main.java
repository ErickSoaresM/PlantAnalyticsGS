package br.com.plantanalytics.main;

import br.com.plantanalytics.api.PlantAnalyticsAPI;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;

public class main {
    public static void main(String[] args) throws ServletException {
        String webappDirLocation = "src/main/webapp/";
        String webPort = System.getenv("PORT") != null ? System.getenv("PORT") : "8080";

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.parseInt(webPort));

        Context context = tomcat.addWebapp("", webappDirLocation);
        Tomcat.addServlet(context, "jersey-container-servlet", new org.glassfish.jersey.servlet.ServletContainer(new PlantAnalyticsAPI()));
        context.addServletMappingDecoded("/api/*", "jersey-container-servlet");

        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

