<%-- 
    Document   : hapus-mhs
    Created on : May 6, 2020, 11:48:29 AM
    Author     : ITD
--%>

  
   <%-- start web service invocation --%><hr>
<%
 try {
  client.siakad.Mahasiswa_Service service = new client.siakad.Mahasiswa_Service();
  client.siakad.Mahasiswa port = service.getMahasiswaPort();
   // TODO initialize WS operation arguments here
  int nim = Integer.valueOf(request.getParameter("nim"));
  response.sendRedirect("index.jsp");
  port.delMahasiswa(nim);
    } catch (Exception ex) {
  // TODO handle custom exceptions here
    }
    %>
<%-- end web service invocation --%><hr>