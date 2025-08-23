package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {
    // CRUD Operations
    public void createPatient(Patient patient) throws Exception {
        Connection conn = DbUtil.getConnection();
        String sql = "insert into patients(patientname,height,weight,age,contact,qr) values(?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, patient.getPatientName());
        pstmt.setDouble(2, patient.getHeight());
        pstmt.setDouble(3, patient.getWeight());
        pstmt.setInt(4, patient.getAge());
        pstmt.setLong(5, patient.getContact());
        pstmt.setString(6, patient.getQrCode());
        int output = pstmt.executeUpdate();
        if(output>0)
            System.out.println("Patient has been created");
        else
            System.out.println("Patient has NOT been created");
        conn.close();
    }
    public List<Patient> getPatients() throws Exception {
        Connection conn = DbUtil.getConnection();
        String sql = "select * from patients";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Patient> patients = new ArrayList<>();
        while (rs.next()) {
            Patient patient = new Patient();
            patient.setPatientId(rs.getInt("patientid"));
            patient.setPatientName(rs.getString("patientname"));
            patient.setHeight(rs.getDouble("height"));
            patient.setWeight(rs.getDouble("weight"));
            patient.setAge(rs.getInt("age"));
            patient.setContact(rs.getLong("contact"));
            patient.setQrCode(rs.getString("qr"));
            patients.add(patient);
        }
        conn.close();
        return patients;
    }
}
