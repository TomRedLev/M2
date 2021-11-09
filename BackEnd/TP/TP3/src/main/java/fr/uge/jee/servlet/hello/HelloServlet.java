package fr.uge.jee.servlet.hello;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// Pour se connecter sur ma machine : http://localhost:9090/App/hello (j'ai du changer le port dans la config de tomcat)
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html><html><h1>Hello world!</h1></html>");
        writer.flush();
    }
}