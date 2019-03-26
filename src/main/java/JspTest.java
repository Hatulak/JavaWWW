import utils.Ksiazka;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "JspTest", urlPatterns = "/jspTest")
public class JspTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().setAttribute("liczba", 15);
        getServletContext().setAttribute("liczba2", 99.99);
        List<String> napisy = new LinkedList<>();
        napisy.add("napis1");
        napisy.add("napis2");
        napisy.add("napis3");
        getServletContext().setAttribute("napisy", napisy);
        Ksiazka ksiazka = new Ksiazka("Pan Tadeusz", "Adam Mickiewicz");
        getServletContext().setAttribute("ksiazka", ksiazka);

        HttpSession session = request.getSession();
        synchronized (session) {
            List<String> inne_napisy = (List<String>) session.getAttribute("inne_napisy");
            if (inne_napisy == null) {
                inne_napisy = new LinkedList<>();
                inne_napisy.add("Kolejny Napis");
            }
            inne_napisy.add("I jeszcze jeden napis");
            session.setAttribute("inne_napisy", inne_napisy);
        }


        RequestDispatcher rd = request.getRequestDispatcher("jspTest.jsp");
        rd.forward(request, response);
    }
}
