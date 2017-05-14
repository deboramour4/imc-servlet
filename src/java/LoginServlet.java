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
public class LoginServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        if(login.equals(senha)){
            HttpSession session = request.getSession(true);
            session.setAttribute("login", login);
            response.sendRedirect("principalServlet");
        } else {
            response.sendRedirect("logout.html");
        }

    }

}
