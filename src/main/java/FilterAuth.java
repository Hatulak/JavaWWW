import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterAuth", urlPatterns = "/highlySecret")
public class FilterAuth implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        if (session == null)
            response.sendRedirect("index.jsp");
        String login = (String) session.getAttribute("login");
        if (login == null)
            response.sendRedirect("index.jsp");
        else {
            if (login.matches("admin"))
                chain.doFilter(req, resp);
            else response.sendRedirect("index.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
