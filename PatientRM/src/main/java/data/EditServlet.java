package data;

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

@WebServlet("/update")
@MultipartConfig
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Patient obj = new Patient();
        obj.setPatientId(Integer.parseInt(req.getParameter("patientId")));
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
        new PatientDao().update(obj);
        resp.sendRedirect("/PatientRM_war/view");
    }
}
