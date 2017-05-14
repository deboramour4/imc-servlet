import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
        
        //calculo do IMC
        double imc;
        double altura = Double.parseDouble(request.getParameter("altura"));
        double massa = Double.parseDouble(request.getParameter("massa"));
        imc = massa/(altura*altura);
        
        //formatação do resultado
        BigDecimal bd = new BigDecimal(imc).setScale(3, RoundingMode.HALF_EVEN); 

        HttpSession session = request.getSession();
        
        if(session != null && session.getAttribute("login") != null){   
            //escrever html
            try (PrintWriter out = response.getWriter()) {               
                request.getRequestDispatcher("view/header.html").include(request, response);
                out.println("<header><b>"+bd.doubleValue()+" Kg/m²</b></header>");
                request.getRequestDispatcher("view/footer.html").include(request, response);
            }

        } else {
            response.sendRedirect("logoutServlet");
        }
    }
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.sendRedirect("logoutServlet");  
    }
}
