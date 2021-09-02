package be.pxl.paj.servlets;

import be.pxl.paj.servlets.service.PhonebookService;
import be.pxl.paj.servlets.service.resources.PhonebookResource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddPhonebookEntry", value = "/AddPhonebookEntry")
public class PhonebookEntryServlet extends HttpServlet {


    private PhonebookService phonebookService;

    public PhonebookEntryServlet(PhonebookService phonebookService) {
        this.phonebookService = phonebookService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PhonebookResource phonebookResource = new PhonebookResource();
        phonebookResource.setFirstName(req.getParameter("firstName"));
        phonebookResource.setLastName(req.getParameter("lastName"));
        phonebookResource.setPhoneNumber(req.getParameter("phoneNumber"));
        phonebookService.createNewPhonebookEntry(phonebookResource);

        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Phonebook Entry succeeded.</h1>");
        printWriter.print("<p> firstName :: " + phonebookResource.getFirstName() + "</p>");
        printWriter.print("<p> lastName :: " + phonebookResource.getLastName() + "</p>");
        printWriter.print("<p> firstName :: " + phonebookResource.getPhoneNumber() + "</p>");

        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();
    }
}
