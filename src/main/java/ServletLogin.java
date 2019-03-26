import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "ServletLogin", urlPatterns = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        Cookie cookie = new Cookie("login", login);
        response.addCookie(cookie);
        HttpSession session = request.getSession();
        synchronized (session) {
            List<String> pagesHistory = (List<String>) session.getAttribute("pages");
            if (pagesHistory == null) {
                pagesHistory = new LinkedList<>();
            }
            if (pagesHistory.size() == 3) {
                pagesHistory.remove(0);
                pagesHistory.add(request.getRequestURL().toString());
            } else {
                pagesHistory.add(request.getRequestURL().toString());
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        HttpSession session = request.getSession();
        synchronized (session) {
            List<String> pagesHistory = (List<String>) session.getAttribute("pages");
            if (pagesHistory == null) {
                pagesHistory = new LinkedList<>();
            }
            if (pagesHistory.size() == 3) {
                pagesHistory.remove(0);
                pagesHistory.add(request.getRequestURL().toString());
            } else {
                pagesHistory.add(request.getRequestURL().toString());
            }
            session.setAttribute("pages", pagesHistory);
        }
    }
}
