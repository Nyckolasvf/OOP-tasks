package Myhello;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RandomServlet", urlPatterns = {"/random.html"})
public class RandomServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RandomServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Números randômicos</h1>");
            int vet[] = new int[6];
            for(int i = 0;i<6;i++){                            
                int randomNum = (int)(Math.random() * 101);
                if(randomNum > 0 && randomNum <= 60)
                 vet[i] = randomNum;
                else 
                    i--;
            }
            for(int j=0;j<6;j++){
                out.println(vet[j]);
            }
            out.println("<p>Agora faça o que quiser.</p>");
            out.println("<a href=index.html> Voltar <a>");
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
