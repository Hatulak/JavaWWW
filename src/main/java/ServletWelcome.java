import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletWelcome", urlPatterns = "/ServletWelcome")
public class ServletWelcome extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("login")) {
                String login = cookie.getValue();
                out.println("<h1>Jestes zalogowany " + login + "</h1><br />");
                return;
            }
        }
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Welcome</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Witaj gosciu </h1><br />");
        out.println("<form action=\"ServletLogin\" method=\"post\" id=\"from_login\"><br/>");
        out.println("<input type=\"text\" name=\"login\" value=\"Login\"><br/>");
        out.println("<input type=\"submit\" value=\"Send\">");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");

    }
}
