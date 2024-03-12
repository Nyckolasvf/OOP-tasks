package Myhello;

import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "GreetingServlet", urlPatterns = {"/greeting.html"})
public class GreetingServlet extends HttpServlet {
    


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GreetingServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>" + new java.util.Date() + "</h2>");
            Date dt = new Date();
            int hours = dt.getHours();    
            if(hours>=5 && hours<12){
                out.println("<h1> Bom dia!</h1>");
                out.println("<img src=https://i.pinimg.com/originals/05/d5/05/05d5057fc7371e63ecfdb2b743ee82ab.gif>");
            }else if(hours>=12 && hours<16){
                out.println("<h1> Boa tarde!</h1>");
                out.println("<img src=https://i.pinimg.com/originals/a4/7e/5b/a47e5b19b0dfdb05c0773938d8b0a698.gif>");
            }else if(hours>=16 && hours<23){
                out.println("<h1> Boa noite!</h1>");
                out.println("<img src=https://www.frasesdiarias.com.br/wp-content/uploads/2021/02/boa-noite-gif-permita-se-ser-feliz.gif>");
            }else if(hours>=23 && hours<5){
                out.println("<h1> VAI DORMIR!</h1>");
                out.println("<img src=https://j.gifs.com/864ZQl.gif>");
            }
            out.println("<a href=random.html> Random <a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
