import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "ServletAddNumberToList", urlPatterns = "/jspFormToAddNumber")
public class ServletAddNumberToList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Integer> list = (List<Integer>) request.getServletContext().getAttribute("list");
        Integer newNumber = Integer.valueOf(request.getParameter("newNumber"));
        list.add(newNumber);
        Collections.sort(list);
        request.getServletContext().setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jspFormToAddNumber.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jspFormToAddNumber.jsp");
        requestDispatcher.forward(request, response);

    }
}
