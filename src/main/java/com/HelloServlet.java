package com;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
//        super.init();
        System.out.println("init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("doGet");

        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Hello, "
                + getNameByService()
                + "</h1>");
        response.getWriter().println("</body>");
        response.getWriter().println("</head>");
        response.getWriter().println("</html>");
    }

    private String getNameByService() {
        ApplicationContext context = (ApplicationContext) getServletContext()
                .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        HelloService helloService = context.getBean(HelloService.class);
        return helloService.getName();
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
