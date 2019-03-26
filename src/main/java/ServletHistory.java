import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "ServletHistory", urlPatterns = "/ServletHistory")
public class ServletHistory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        boolean isLogged = false;
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("login")) {
                String login = cookie.getValue();
                isLogged = true;
                break;
            }
        }
        if (isLogged) {
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
                pagesHistory.forEach(p -> {
                    out.println("<a href=\"" + p + "\">" + p + "</a><br />");
                });

            }
        }
        out.println("</body>");
        out.println("</html>");
    }
}
