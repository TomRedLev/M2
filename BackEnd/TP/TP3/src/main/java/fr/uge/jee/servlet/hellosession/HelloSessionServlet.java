package fr.uge.jee.servlet.hellosession;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

// Pour se connecter sur ma machine : http://localhost:9090/App/hellosession (j'ai du changer le port dans la config de tomcat)
@WebServlet("/hellosession")
public class HelloSessionServlet extends HttpServlet {
    private final SessionTokens sessionTokens = new SessionTokens();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID session = null;
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 1) {
            session = sessionTokens.addToken();
            response.addCookie(new Cookie("session", session.toString()));
        } else {
            for (var cookie : cookies) {
                if (cookie.getName().equals("session")) {
                    session = UUID.fromString(cookie.getValue());
                }
            }

        }

        var i = sessionTokens.modifyToken(session);
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html><html><h1>Bonjour pour la "+i+"-ème fois</h1></html>");
        writer.flush();
    }
}