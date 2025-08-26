package data;

import data.hiber.HiberORM;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/admit")
@MultipartConfig
public class AdmissionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        // set all jsp input into patient object attributes
        Patient obj = new Patient();
        obj.setPatientName(req.getParameter("patientName"));
        obj.setHeight(Double.parseDouble(req.getParameter("height")));
        obj.setWeight(Double.parseDouble(req.getParameter("weight")));
        obj.setAge(Integer.parseInt(req.getParameter("age")));
        obj.setContact(Long.parseLong(req.getParameter("contact")));

        // file upload handling
        // receive multipart
        Part filePart = req.getPart("qrCode");
        // find name of the submitted file
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        // decide the location where to keep the uploaded files
        String uploadLocation = "D:/Course backups/Java/TechnoICT GnanamaniAug2025/Execution/uploaded";
        // try to cgheck the uploaded directory available or not
        File uploadDir = new File(uploadLocation);
        // if not available create folder
        if(!uploadDir.exists())
            uploadDir.mkdir();
        // build the final path include upload dire separator filename
        String filePath = uploadLocation + File.separator + fileName;
        // write/ create uploaded file physically in the uploaded directory
        filePart.write(filePath);
        obj.setQrCode(filePath);

        // insert into table by calling create DAO fun
        try {
            // jdbc call
//            new PatientDao().createPatient(obj);
            new HiberORM().createPatient(obj);
            RequestDispatcher rd = req.getRequestDispatcher("/admit.jsp");
            rd.forward(req, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
