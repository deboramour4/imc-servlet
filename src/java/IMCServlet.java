import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Débora Moura
 */
public class IMCServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        double imc = 23.04;
        

        HttpSession session = request.getSession();
        
        if(session != null && session.getAttribute("login") != null){   
            //escrever html
            try (PrintWriter out = response.getWriter()) {               
                request.getRequestDispatcher("view/header.html").include(request, response);
                out.println("<header><b>"+imc+" Kg/m²</b></header>");
                request.getRequestDispatcher("view/footer.html").include(request, response);
            }

        } else {
            response.sendRedirect("logout.html");
        }
    }
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.sendRedirect("logout.html");  
    }
}
