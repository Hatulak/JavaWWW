package database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletProcess", urlPatterns = "/process")
public class ServletProcess extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("updateButton") != null) {
            String bookId = request.getParameter("selected");
            if (bookId != null) {
                Book book = HBook.findById(Long.valueOf(bookId));
                request.setAttribute("bookToUpdate", book);
                HttpSession session = request.getSession();
                synchronized (session) {
                    session.setAttribute("bookToUpdateId", bookId);
                }
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("updateBook.jsp");
            requestDispatcher.forward(request, response);
        } else if (request.getParameter("deleteButton") != null) {
            String[] checked = request.getParameterValues("checked");
            if (checked != null) {
                for (int i = 0; i < checked.length; i++) {
                    HBook.delete(HBook.findById(Long.valueOf(checked[i])));
                }
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showDB");
            requestDispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
