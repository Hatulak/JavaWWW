package database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletUpdateBook", urlPatterns = "/updateBook")
public class ServletUpdateBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String cover = request.getParameter("cover");
        String author = request.getParameter("author");
        Double price = Double.parseDouble(request.getParameter("price"));

        HttpSession session = request.getSession();
        Long bookId = Long.parseLong((String) session.getAttribute("bookToUpdateId"));
        if (bookId != null) {
            Book book = HBook.findById(bookId);
            book.setTitle(title);
            book.setCategory(category);
            book.setCover(cover);
            book.setAuthor(author);
            book.setPrice(price);
            HBook.update(book);
        }
        synchronized (session) {
            session.removeAttribute("bookToUpdateId");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showDB");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
