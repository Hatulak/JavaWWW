import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import utils.Ksiazka;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
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

        //WALIDACJA XML
        File schemaFile = new File("E:\\MEGA\\JavaWWW\\testjava\\src\\main\\webapp\\WEB-INF\\xmls\\breakfastMenuXMLDocument.xsd"); // etc.
        Source xmlFile = new StreamSource(new File("E:\\MEGA\\JavaWWW\\testjava\\src\\main\\webapp\\WEB-INF\\xmls\\breakfastMenuXMLDocument.xml"));
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (SAXException e) {
            System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
        } catch (IOException e) {
        }

        //UMIESZANIE LISTY ELEMENTÓW Z XMLA DO SESJI
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        File fXmlFile = new File("E:\\MEGA\\JavaWWW\\testjava\\src\\main\\webapp\\WEB-INF\\xmls\\breakfastMenuXMLDocument.xml");

        List<List<String>> foodList = new LinkedList<>();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("food");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String type = "type : " + eElement.getAttribute("type");
                    String name = "name : " + eElement.getElementsByTagName("name").item(0).getTextContent();
                    String curr = "";
                    if (eElement.getElementsByTagName("price").item(0).getAttributes().item(0) != null)
                        curr = eElement.getElementsByTagName("price").item(0).getAttributes().item(0).getTextContent();

                    String price = "price : " + eElement.getElementsByTagName("price").item(0).getTextContent() + " " + curr;
                    String description = "description : " + eElement.getElementsByTagName("description").item(0).getTextContent();
                    String calories = "calories : " + eElement.getElementsByTagName("calories").item(0).getTextContent();
                    List<String> food = new LinkedList<>();
                    food.add(type);
                    food.add(name);
                    food.add(price);
                    food.add(description);
                    food.add(calories);
                    foodList.add(food);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        synchronized (session) {
            session.setAttribute("XMLList", foodList);
        }

        RequestDispatcher rd = request.getRequestDispatcher("jspTest.jsp");
        rd.forward(request, response);
    }
}
