package fr.uge.jee.servlet.hellosession;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// Pour se connecter sur ma machine : http://localhost:9090/App/hellosessionbetter (j'ai du changer le port dans la config de tomcat)

// Id de session : E4369864792BEC93D6ED060C9CDC7CC4
// curl -X GET -i -b JSESSIONID=E4369864792BEC93D6ED060C9CDC7CC4 http://localhost:9090/App/hellosessionbetter
/*
Réponse :
HTTP/1.1 200
Content-Type: text/html;charset=utf-8
Transfer-Encoding: chunked
Date: Tue, 09 Nov 2021 12:37:39 GMT

<!DOCTYPE html><html><h1>Bonjour pour la 11-ème fois</h1></html>
 */

// curl -X GET -i -b JSESSIONID=FFFFFFFF http://localhost:9090/App/hellosessionbetter
// On peut voir qu'un nouveau session_id est créé à chaque appel avec cette commande curl.
// On peut donc supposer qu'un nouveau session_id est créé à chaque fois que le programme n'est pas capable d'utiliser l'id donnée.
@WebServlet("/hellosessionbetter")
public class HelloSessionBetterServlet extends HttpServlet {
    private final Object lock = new Object();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var session = request.getSession(true);
        if (session.getAttribute("counter") == null) {
            session.setAttribute("counter", 0);
        }
        var i=0;
        synchronized (lock){
            i = (int) session.getAttribute("counter") + 1;
            session.setAttribute("counter", i);
        }
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html><html><h1>Bonjour pour la "+i+"-ème fois</h1></html>");
        writer.flush();
    }
}