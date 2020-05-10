<%-- 
    Document   : proses-tambah-mhs
    Created on : May 6, 2020, 11:19:24 AM
    Author     : ITD
--%>

<%-- start web service invocation --%>
<%
 try {
  client.siakad.Mahasiswa_Service service = new client.siakad.Mahasiswa_Service();
  client.siakad.Mahasiswa port = service.getMahasiswaPort();
  // TODO initialize WS operation arguments here
      int nim = Integer.valueOf(request.getParameter("nim"));
      java.lang.String nama = request.getParameter("nama");
      java.lang.String jurusan = request.getParameter("jurusan");
      java.lang.String email = request.getParameter("email");
      java.lang.String alamat = request.getParameter("alamat");
      port.addMahasiswa(nim, nama, jurusan, email, alamat);
      response.sendRedirect("index.jsp");

 } catch (Exception ex) {
  // TODO handle custom exceptions here
 }
%>
<%-- end web service invocation --%>