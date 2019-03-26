import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "Servlet1", urlPatterns = "/Servlet1")
public class Servlet1 extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String fname = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String age = request.getParameter("age");
        String[] interests = request.getParameterValues("interests");
        String inter = new String();
        if (interests != null)
            for (String interest : interests) {
                inter += interest + " ";
            }

        ServletContext sc = this.getServletContext();
        synchronized (getServletContext()) {
            List<String> users = (List<String>) sc.getAttribute("users");
            if (users == null) {
                users = new LinkedList<String>();
            }
            users.add(fname + " " + lastName + " " + login + " " + age + " " + inter);
            sc.setAttribute("users", users);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/Servlet2");
        rd.forward(request, response);
    }


}
