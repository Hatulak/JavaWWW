package database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletDB", urlPatterns = "/showDB")
public class ServletDB extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book("sad", "dsa", "asd", "asd", 13.0);
        HBook.save(book);
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = HBook.getAll();
        HttpSession session = request.getSession();

        synchronized (session) {
            session.setAttribute("books", books);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showDB.jsp");
        requestDispatcher.forward(request, response);
    }
}
