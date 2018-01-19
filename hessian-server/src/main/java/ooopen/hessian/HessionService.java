package ooopen.hessian;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class HessionService {

    public static void main(String[] args) {
        Server server = new Server(9011);
        ServletHolder servletHolder = new ServletHolder(new HelloImp());
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        //Hello.class.getName()使用了类名当做url。即“ooopen.hessian.Hello”
        context.addServlet(servletHolder, "/" + Hello.class.getName());
        context.setInitParameter("home-class", HelloImp.class.getName());
        context.setInitParameter("home-api", Hello.class.getName());
        server.setHandler(context);
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
