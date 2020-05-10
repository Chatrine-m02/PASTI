/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siakad.mahasiswa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ITD
 */
@WebService(serviceName = "Mahasiswa")
public class Mahasiswa {

    KoneksiMYSQL kon = new KoneksiMYSQL();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    /**
     * This is a sample web service operation
     * 
     */
    @WebMethod(operationName = "getMahasiswa")
    public List getMahasiswa(
    @WebParam(name = "nim") int nim) {
    List mahasiswa = new ArrayList();
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/siakad", "root", "");
        Statement st = conn.createStatement();
        con = kon.getCon();
        ps = con.prepareStatement("select * from mahasiswa where nim=?");
        ps.setInt(1, nim);
        ResultSet rst = ps.executeQuery();
        while (rst.next()) {
            mahasiswa.add("<div class=\"form-group\">\n" +
                " <label class=\"control-label col-sm-1\">NIM</label>\n" +
                " <div class=\"col-sm-2\">\n" +
                " <input type=\"text\" class=\"form-control\" name=\"nim\"value=\"" + rst.getInt("nim") + "\" readonly=\"true\">\n" +
                " </div>\n" +
                " </div>\n" +
                " \n" +
                " <div class=\"form-group\">\n" +
                " <label class=\"control-label col-sm-1\">Nama</label>\n" +
                " <div class=\"col-sm-2\">\n" +
                " <input type=\"text\" class=\"form-control\" name=\"nama\" value=\"" + rst.getString("nama") + "\">\n" +
                " </div>\n" +
                " </div>\n" +
                " \n" +
                " <div class=\"form-group\">\n" +
                " <label class=\"control-label col-sm-1\">Jurusan</label>\n" +
                " <div class=\"col-sm-2\">\n" +
                " <input type=\"text\" class=\"form-control\" name=\"jurusan\" value=\"" + rst.getString("jurusan") + "\">\n" +
                " </div>\n" +
                " </div>\n" +
                " \n" +
                " <div class=\"form-group\">\n" +
                " <label class=\"control-label col-sm-1\">Email</label>\n" +
                " <div class=\"col-sm-2\">\n" +
                " <input type=\"text\" class=\"form-control\" name=\"email\" value=\"" + rst.getString("email") + "\">\n" +
                " </div>\n" +
                " </div>\n" +
                " \n" +
                " <div class=\"form-group\">\n" +
                " <label class=\"control-label col-sm-1\">Alamat</label>\n" +
                " <div class=\"col-sm-2\">\n" +
                " <input type=\"text\" class=\"form-control\" name=\"alamat\"value=\"" + rst.getString("alamat") + "\">\n" +
                " </div>\n" +
                " </div>");
        }
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
    return mahasiswa;
}
     
    
    
    @WebMethod(operationName = "addMahasiswa")
    public void addDosen(
        @WebParam(name = "nim") int nim,
        @WebParam(name = "nama") String nama,
        @WebParam(name = "jurusan") String jurusan,
        @WebParam(name = "email") String email,
        @WebParam(name = "alamat") String alamat
    ) {
        try {
            con = kon.getCon();
            ps = con.prepareStatement("insert into mahasiswa value (?,?,?,?,?)");
            ps.setInt(1, nim);
            ps.setString(2, nama);
            ps.setString(3, jurusan);
            ps.setString(4, email);
            ps.setString(5, alamat);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
     
    @WebMethod(operationName = "delMahasiswa")
    public void delMahasiswa(
        @WebParam(name = "nim") int nim) {
        try {
            con = kon.getCon();
            ps = con.prepareStatement("delete from mahasiswa where nim = ?");
            ps.setInt(1, nim);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Failed to remove student because " + e.toString());
        }
    }
     
    @WebMethod(operationName = "editMahasiswa")
    public void editMahasiswa(
        @WebParam(name = "nim") int nim,
        @WebParam(name = "nama") String nama,
        @WebParam(name = "jurusan") String jurusan,
        @WebParam(name = "email") String email,
        @WebParam(name = "alamat") String alamat) {
        try {
            con = kon.getCon();
            ps = con.prepareStatement("update mahasiswa set nama=?,jurusan=?,email=?,alamat=? where nim=?");
            ps.setString(1, nama);
            ps.setString(2, jurusan);
            ps.setString(3, email);
            ps.setString(4, alamat);
            ps.setInt(5, nim);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Failed to edit student because " + e.toString());
        }
    }
    
        
    @WebMethod(operationName = "tampilMahasiswa")
    public List tampilMahasiswa() {
        List daftar = new ArrayList();
        String sql_daftar = "select * from mahasiswa";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/siakad", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql_daftar);
            while (rs.next()) {
                daftar.add("<td>" + rs.getInt("nim") + "</td><td>" + rs.getString("nama") + "</td><td>" + rs.getString("jurusan") + "</td><td>" + rs.getString("email") + "</td><td>" + rs.getString("alamat") + "</td><td><button class=\"btn-info\"><a href=\"edit-mhs.jsp?nim=" + rs.getString("nim") + "\">Edit</a>"
                        + "</button><button class=\"btn-danger\"><a href=\"hapus-mhs.jsp?nim=" + rs.getString("nim") + "\">Hapus</a></button></td><tr></tr>");
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return daftar;
    }


}
