package database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCreateNewBook", urlPatterns = "/createBook")
public class ServletCreateNewBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String cover = request.getParameter("cover");
        String author = request.getParameter("author");
        Double price = Double.parseDouble(request.getParameter("price"));

        Book book = new Book(title, category, cover, author, price);
        HBook.save(book);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showDB");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("createNewBook.jsp");
        requestDispatcher.forward(request, response);
    }
}
