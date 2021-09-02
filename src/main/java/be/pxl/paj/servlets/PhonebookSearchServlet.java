package be.pxl.paj.servlets;

import be.pxl.paj.servlets.dao.PhonebookDAO;
import be.pxl.paj.servlets.service.PhonebookService;
import be.pxl.paj.servlets.service.dto.PhonebookDTO;
import be.pxl.paj.servlets.service.resources.PhonebookSearchResource;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SearchPhonenumber", value = "/SearchPhonenumber")
public class PhonebookSearchServlet extends HttpServlet {

    private PhonebookService phonebookService;

    private final RestTemplate restTemplate;

    public PhonebookSearchServlet(PhonebookService phonebookService, RestTemplate restTemplate) {
        this.phonebookService = phonebookService;
        this.restTemplate = restTemplate;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PhonebookSearchResource phonebookSearchResource = new PhonebookSearchResource();
        phonebookSearchResource.setFirstName(req.getParameter("firstName"));
        phonebookSearchResource.setLastName(req.getParameter("lastName"));
        PhonebookDTO phonebookDTO = phonebookService.findPhonenumberByName(phonebookSearchResource);

        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Phonenumber Found.</h1>");
        printWriter.print("<p> firstName :: " + phonebookDTO.getFirstName() + "</p>");
        printWriter.print("<p> lastName :: " + phonebookDTO.getLastName() + "</p>");
        printWriter.print("<p> phoneNumber :: " + phonebookDTO.getPhoneNumber() + "</p>");

        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();
    }
}
