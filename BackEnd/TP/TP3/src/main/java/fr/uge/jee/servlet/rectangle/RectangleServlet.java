package fr.uge.jee.servlet.rectangle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

// Pour se connecter sur ma machine : http://localhost:9090/App/rectangle (j'ai du changer le port dans la config de tomcat)

// Si l'utilisateur ne rentre pas de nombre, on obtient une erreur de type 500 : exception error.
@WebServlet("/rectangle")
public class RectangleServlet extends HttpServlet {
    private InputStream inputStream;

    @Override
    public void init() throws ServletException {
        super.init();
        inputStream = getServletContext().getResourceAsStream("/WEB-INF/templates/rectangle-form.html");
    }

    public static String readFromInputStream(InputStream inputStream) throws IOException {
        var lines = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines();
        return lines.collect(Collectors.joining("\n"));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println(readFromInputStream(inputStream));
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String height_str = request.getParameter("height");
        String width_str = request.getParameter("width");
        PrintWriter writer = response.getWriter();
        if (height_str == "" || width_str == "") {
            inputStream = getServletContext().getResourceAsStream("/WEB-INF/templates/rectangle-form-error.html");
            writer.println(readFromInputStream(inputStream));
            writer.flush();
            return ;
        }
        int height = Integer.parseInt(height_str);
        int width = Integer.parseInt(width_str);
        response.setContentType("text/html");
        writer.println("<html><h1>Area of the rectangle is : " + height * width + "</h1></html>");
        writer.flush();
    }
}